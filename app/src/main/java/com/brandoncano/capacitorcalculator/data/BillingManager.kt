package com.brandoncano.capacitorcalculator.data

import android.app.Activity
import android.content.Context
import android.util.Log
import com.android.billingclient.api.BillingClient
import com.android.billingclient.api.BillingClientStateListener
import com.android.billingclient.api.BillingFlowParams
import com.android.billingclient.api.BillingResult
import com.android.billingclient.api.ConsumeParams
import com.android.billingclient.api.PendingPurchasesParams
import com.android.billingclient.api.Purchase
import com.android.billingclient.api.PurchasesUpdatedListener
import com.android.billingclient.api.QueryProductDetailsParams


class BillingManager(
    context: Context,
) {
    private companion object {
        const val TAG = "DonationBillingClient"
    }

    private val purchaseListener = PurchasesUpdatedListener { billingResult, purchases ->
        when (billingResult.responseCode) {
            BillingClient.BillingResponseCode.OK -> {
                purchases?.forEach { purchase ->
                    handlePurchase(purchase)
                }
            }

            BillingClient.BillingResponseCode.USER_CANCELED -> {
                Log.e(TAG, "User canceled the purchase")
            }

            BillingClient.BillingResponseCode.ITEM_ALREADY_OWNED -> {
                // Note: This should never occur but will be here just in case
                Log.e(TAG, "ITEM_ALREADY_OWNED")
            }

            else -> {
                Log.e(TAG, "Error during purchase: ${billingResult.debugMessage}")
            }
        }
    }

    private val billingClient = BillingClient.newBuilder(context)
        .setListener(purchaseListener)
        .enablePendingPurchases(
            PendingPurchasesParams.newBuilder()
                .enableOneTimeProducts()  // Covers consumable one-time purchases (donations)
                .build()
        )
        .enableAutoServiceReconnection()
        .build()

    fun startConnection(
        onError: () -> Unit,
    ) {
        billingClient.startConnection(object : BillingClientStateListener {
            override fun onBillingSetupFinished(billingResult: BillingResult) {
                if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                    Log.i(TAG, "Billing client connected successfully")
                } else {
                    Log.e(TAG, "Error connecting billing client: ${billingResult.debugMessage}")
                    onError()
                }
            }

            override fun onBillingServiceDisconnected() {
                Log.w(TAG, "Billing service disconnected. Retrying connection...")
            }
        })
    }

    fun launchPurchaseFlow(activity: Activity, productId: String) {
        val queryProductDetailsParams = QueryProductDetailsParams.newBuilder()
            .setProductList(
                listOf(
                    QueryProductDetailsParams.Product.newBuilder()
                        .setProductId(productId)
                        .setProductType(BillingClient.ProductType.INAPP)
                        .build()
                )
            )
            .build()

        billingClient.queryProductDetailsAsync(queryProductDetailsParams) {
                billingResult,
                queryProductDetailsResult ->

            if (billingResult.responseCode != BillingClient.BillingResponseCode.OK) {
                Log.e(TAG, "Error querying product details: ${billingResult.debugMessage}")
                return@queryProductDetailsAsync
            }

            val productDetails = queryProductDetailsResult.productDetailsList.firstOrNull()
            if (productDetails == null) {
                Log.e(TAG, "Product details not found for: $productId")
                queryProductDetailsResult.unfetchedProductList.forEach { product ->
                    Log.e(TAG, "Unable to fetch product: ${product.productId}")
                }
                return@queryProductDetailsAsync
            }

            val billingFlowParams = BillingFlowParams.newBuilder()
                .setProductDetailsParamsList(
                    listOf(
                        BillingFlowParams.ProductDetailsParams.newBuilder()
                            .setProductDetails(productDetails)
                            .build()
                    )
                )
                .build()

            val launchResult = billingClient.launchBillingFlow(activity, billingFlowParams)

            if (launchResult.responseCode != BillingClient.BillingResponseCode.OK) {
                Log.e(TAG, "Unable to launch billing flow: ${launchResult.debugMessage}")
            }
        }
    }

    private fun handlePurchase(purchase: Purchase) {
        when (purchase.purchaseState) {
            Purchase.PurchaseState.PURCHASED -> {
                consumePurchase(purchase)
            }
            Purchase.PurchaseState.PENDING -> {
                Log.i(TAG, "Purchase pending: ${purchase.orderId}")
            }
            else -> {
                Log.w(TAG, "Purchase has unspecified state: ${purchase.orderId}")
            }
        }
    }

    private fun consumePurchase(purchase: Purchase) {
        val params = ConsumeParams.newBuilder()
            .setPurchaseToken(purchase.purchaseToken)
            .build()

        billingClient.consumeAsync(params) { billingResult, _ ->
            if (billingResult.responseCode == BillingClient.BillingResponseCode.OK) {
                Log.i(TAG, "Purchase consumed. Donation can be purchased again.")
            } else {
                Log.e(TAG, "Failed to consume purchase: " + billingResult.debugMessage)
            }
        }
    }
}
