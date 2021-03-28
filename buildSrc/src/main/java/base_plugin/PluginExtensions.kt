package base_plugin


import AppConfig
import GradlePluginId
import LibraryList
import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

internal fun Project.configureDefaultPlugins() = listOf(
    GradlePluginId.kotlinAndroid,
    GradlePluginId.kotlinAndroidExtensions,
    GradlePluginId.hilt,
    GradlePluginId.kotlinKapt
).forEach {
    plugins.apply(it)
}

private typealias AndroidBaseExtension = BaseExtension

internal fun Project.configureAndroidApp() = extensions.getByType<AndroidBaseExtension>().run {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig.apply {
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)

        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation

        compileOptions {
            sourceCompatibility = JavaVersion.VERSION_1_8
            targetCompatibility = JavaVersion.VERSION_1_8
        }
    }

    testOptions.apply {
        unitTests.isReturnDefaultValues = true
        animationsDisabled = true
    }
}

internal fun Project.configureBaseDependencies() = dependencies {
    fun DependencyHandler.kapt(list: List<String>) {
        list.forEach { dependency ->
            add("kapt", dependency)
        }
    }

    fun DependencyHandler.implementation(list: List<String>) {
        list.forEach { dependency ->
            add("implementation", dependency)
        }
    }

    fun DependencyHandler.androidTestImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("androidTestImplementation", dependency)
        }
    }

    fun DependencyHandler.testImplementation(list: List<String>) {
        list.forEach { dependency ->
            add("testImplementation", dependency)
        }
    }

    implementation(LibraryList.rx)
    implementation(LibraryList.HiltLibraries)
    implementation(LibraryList.RecyclerViewLibraries)
    implementation(LibraryList.appLibraries)
    implementation(LibraryList.NavigationLibraries)
    implementation(LibraryList.Glide)
    kapt(LibraryList.HiltLibraryKapt)

    //  testImplementation(LibraryList.TestLibrary)
 //   androidTestImplementation(LibraryList.AndroidTestLibrary)
}

