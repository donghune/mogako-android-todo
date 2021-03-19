plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

android {
    compileSdkVersion(Ver.compile_sdk)

    defaultConfig {
        minSdkVersion(Ver.min_sdk)
        targetSdkVersion(Ver.target_sdk)
    }

    sourceSets {
        main {
            java.srcDir("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(project(":data"))

    implementation(hilt("android"))
    kapt(hilt("compiler"))
}
