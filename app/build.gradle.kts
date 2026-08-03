import com.android.build.api.variant.ResValue
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
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
        versionCode = 13 // for 2.4.0
        versionName = "2.4.0"

        vectorDrawables {
            useSupportLibrary = true
        }
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
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

androidComponents {
    onVariants { variant ->
        val suffix = if (variant.buildType == "debug") ", DEBUG" else ""
        variant.resValues.put(
            variant.makeResValueKey("string", "version"),
            ResValue("${variant.outputs.single().versionName.get()}$suffix", "Application version")
        )
        variant.resValues.put(
            variant.makeResValueKey("string", "last_updated"),
            ResValue("3/16/2025", "Application last updated date")
        )
    }
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
