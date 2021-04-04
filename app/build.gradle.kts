plugins {
    id(GradlePluginId.ANDROID_APP)
    id(GradlePluginId.BASE_GRADLE_PLUGIN)
    id(GradlePluginId.SAFE_ARG)

    //id(GradlePluginId.googlePluginService)
   // id("com.google.firebase.crashlytics")
}

android {

    defaultConfig {
        applicationId = AppConfig.id
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false

            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )


            manifestPlaceholders["appName"] = "투두"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
        }

        getByName("debug") {
            isMinifyEnabled = false
            isDebuggable = true
            applicationIdSuffix = ".dev"


            manifestPlaceholders["appName"] = "투두"
            manifestPlaceholders["appIcon"] = "@mipmap/ic_launcher"
        }
    }

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
        exclude("META-INF/LICENSE.md")
        exclude("META-INF/LICENSE-notice.md")
        exclude("META-INF/metadata.jvm.kotlin_module")
        exclude("META-INF/gradle/incremental.annotation.processors")
        exclude("META-INF/metadata.kotlin_module")
    }


    buildFeatures {
        dataBinding = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(Modules.presentation))
    apis(LibraryList.rx)
    apis(LibraryList.RecyclerViewLibraries)
    implementationList(LibraryList.appLibraries)
    apis(LibraryList.NavigationLibraries)
    apis(LibraryList.Glide)


}

fun org.gradle.api.artifacts.dsl.DependencyHandler.apis(  dependencies:List<String>){
    dependencies.forEach {
        api(it)
    }
}