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
        buildConfigField("String", "DB_NAME", "\"todo_database\"")
    }

    sourceSets {
        main {
            java.srcDir("src/main/kotlin")
        }
    }
}

dependencies {
    implementation(project(":data"))
    implementation(project(":util"))

    implementation(hilt("android"))
    kapt(hilt("compiler"))
}
