plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.BASE_GRADLE_PLUGIN)
}

dependencies {
    apis(LibraryList.RetrofitLibraries)
    apis (LibraryList.roomLibrary)
    apis(LibraryList.rx)

}
fun org.gradle.api.artifacts.dsl.DependencyHandler.apis(  dependencies:List<String>){
    dependencies.forEach {
        api(it)
    }
}