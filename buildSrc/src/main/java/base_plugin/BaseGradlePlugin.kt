package base_plugin


import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.create
import org.gradle.kotlin.dsl.invoke
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

open class BaseGradlePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.configureDefaultPlugins()
        target.configureAndroidApp()
        target.configureBaseDependencies()
    }
}