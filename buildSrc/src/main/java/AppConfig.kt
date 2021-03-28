object AppConfig {
    const val id = "com.namu.todo"

    const val versionCode = 1
    const val versionName = "0.0.1"

    const val compileSdk = 29
    const val minSdk = 21
    const val targetSdk = 29
    const val buildToolsVersion = "29.0.3"

    const val androidTestInstrumentation = "android.support.test.runner.AndroidJUnitRunner"
}

object GradlePluginId {
    const val BASE_GRADLE_PLUGIN = "base-gradle-plugin"
    const val ANDROID_APP = "com.android.application"
    const val ANDROID_LIBRARY = "com.android.library"

    const val kotlin = "kotlin"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinKapt = "kotlin-kapt"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val hilt = "dagger.hilt.android.plugin"
    const val SAFE_ARG = "androidx.navigation.safeargs.kotlin" //navigation

}

object GradleClasspath {
    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.gradlePlugin}"
    const val kotlinGradlePluginClasspath = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val hiltGradlePlugin = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltCore}"
    const val googleCrashlytics = "com.google.firebase:firebase-crashlytics-gradle:2.2.0"
    const val safeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2"
    const val googleService = "com.google.gms:google-services:4.3.4"
}