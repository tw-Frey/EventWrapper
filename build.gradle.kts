import Versions.ANDROID_BUILD_VERSION
import Versions.ANDROID_MIN_VERSION
import Versions.ANDROID_SDK_VERSION

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

android {
    compileSdkVersion(ANDROID_SDK_VERSION)
    buildToolsVersion(ANDROID_BUILD_VERSION)
    defaultConfig {
        targetSdkVersion(ANDROID_SDK_VERSION)
        minSdkVersion(ANDROID_MIN_VERSION)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        named("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

}

dependencies {
    implementation(Libs.Kotlin.StdLib)
    implementation(Libs.AndroidX.Core)
    implementation(Libs.AndroidX.AppCompat)
    testImplementation(Libs.Kotlin.TestJunit)
    androidTestImplementation(Libs.AndroidX.Test.Runner)
    androidTestImplementation(Libs.AndroidX.Test.Espresso)
}
