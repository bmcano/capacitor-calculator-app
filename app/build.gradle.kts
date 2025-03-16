plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin)
    alias(libs.plugins.jetbrains.kotlin.compose)
    alias(libs.plugins.jetbrains.kotlin.serialization)
}

android {
    namespace = "com.brandoncano.capacitorcalculator"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.brandoncano.capacitorcalculator"
        minSdk = 24
        targetSdk = 35
        versionCode = 12 // for 2.3.0
        versionName = "2.3.0-develop"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    applicationVariants.configureEach {
        val suffix = if (buildType.name == "debug") ", DEBUG" else ""
        resValue("string", "version", "$versionName$suffix")
        resValue("string", "last_updated", "3/16/2025")
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
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
}

composeCompiler {
    enableStrongSkippingMode = true
}

dependencies {
    // androidx
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.navigation.compose)
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
}
