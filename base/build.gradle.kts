plugins {
    id(GradlePluginId.ANDROID_LIBRARY)
    id(GradlePluginId.BASE_GRADLE_PLUGIN)
}

android {
    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(Libraries.timber)
}