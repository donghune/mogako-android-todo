import org.gradle.kotlin.dsl.kotlin
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

inline val PluginDependenciesSpec.`android-application`: PluginDependencySpec
    get() = id("com.android.application")

inline val PluginDependenciesSpec.`kotlin-android`: PluginDependencySpec
    get() = kotlin("android")

inline val PluginDependenciesSpec.`android-library`: PluginDependencySpec
    get() = id("com.android.library")

inline val PluginDependenciesSpec.`kotlin-kapt`: PluginDependencySpec
    get() = kotlin("kapt")

inline val PluginDependenciesSpec.`hilt-plugin`: PluginDependencySpec
    get() = id("dagger.hilt.android.plugin")

inline val PluginDependenciesSpec.`ktlint-plugin`: PluginDependencySpec
    get() = id("org.jlleitschuh.gradle.ktlint")
