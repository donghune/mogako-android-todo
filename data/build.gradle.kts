plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.BASE_GRADLE_PLUGIN)
}

dependencies {
    implementationList(LibraryList.RetrofitLibraries)
    implementation(project(Modules.base))
    implementation(project(Modules.entity))
}