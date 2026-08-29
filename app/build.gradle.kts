import com.android.build.api.variant.ResValue
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    //alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.jetbrains.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.brandoncano.capacitorcalculator"
    compileSdk = 37

    defaultConfig {
        applicationId = "com.brandoncano.capacitorcalculator"
        minSdk = 24
        targetSdk = 37
        versionCode = 14 // for 2.4.0
        versionName = "2.4.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }

        resValue(
            "string",
            "version",
            versionName!!,
        )

        resValue(
            "string",
            "last_updated",
            "8/26/2026",
        )
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        compose = true
        resValues = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    // androidx
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.graphics.path)
    // androidx.compose.ui
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.compose.ui)
    implementation(libs.androidx.compose.ui.graphics)
    implementation(libs.androidx.compose.ui.tooling.preview)
    debugImplementation(libs.androidx.compose.ui.tooling)
    debugImplementation(libs.androidx.compose.ui.test.manifest)
    androidTestImplementation(libs.androidx.compose.ui.test.junit4)
    // androidx.compose
    implementation(libs.androidx.compose.runtime.livedata)
    implementation(libs.androidx.compose.material.icons)
    implementation(libs.androidx.compose.material3)
    // com.google
    implementation(libs.gson)
    // unit testing
    testImplementation(libs.junit)
    // external libraries
    implementation(libs.ostermiller.util) // Job: can count number of sig figs in a string and round
    implementation(libs.bmcano.util)
    // jetbrains
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.billing.client)
}
