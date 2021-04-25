plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

android {
    compileSdkVersion(Ver.compile_sdk)
    buildToolsVersion(Ver.build_tools)

    defaultConfig {
        minSdkVersion(Ver.min_sdk)
        targetSdkVersion(Ver.target_sdk)
    }

    sourceSets {
        main {
            java.srcDir("src/main/kotlin")
        }
    }

    buildFeatures {
        dataBinding = true
        buildConfig = false
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    implementation(androidAppcompat())
    implementation(androidCore())
    implementation(androidActivity())
    implementation(androidFragment())

    implementation(lifecycle("runtime-ktx"))
    implementation(lifecycle("viewmodel-ktx"))
    implementation(lifecycle("livedata-ktx"))
    implementation(lifecycle("common-java8"))
}
