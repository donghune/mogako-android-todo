plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.BASE_GRADLE_PLUGIN)
}

dependencies {
    implementation(project(Modules.base))
    implementation(project(Modules.data))
    implementation(Libraries.timber)

}