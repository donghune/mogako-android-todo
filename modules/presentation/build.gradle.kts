plugins {
    `android-application`
    `kotlin-android`
    `kotlin-kapt`
    `hilt-plugin`
}

android {
    compileSdkVersion(Ver.compile_sdk)
    buildToolsVersion(Ver.build_tools)

    defaultConfig {
        applicationId = "com.namu.todo"
        minSdkVersion(Ver.min_sdk)
        targetSdkVersion(Ver.target_sdk)
        versionCode = Ver.version_code
        versionName = Ver.version_name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    sourceSets {
        main {
            java.srcDir("src/main/kotlin")
        }
        test {
            java.srcDir("src/test/kotlin")
        }
        androidTest {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
        useIR = true
    }

    buildFeatures {
        dataBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Ver.compose
    }
}

dependencies {
    implementation(project(":domain"))
    implementation(project(":data"))
    implementation(project(":local"))
    implementation(project(":remote"))
    implementation(project(":util"))

    implementation(kotlinStdlib())
    implementation(androidCore())
    implementation(androidAppcompat())
    implementation(androidMaterial())
    implementation(constraintLayout())
    implementation(androidActivity())
    implementation(androidActivityCompose())
    implementation(androidFragment())
    implementation(coroutines("android"))

    implementation(lifecycle("runtime-ktx"))
    implementation(lifecycle("livedata-ktx"))
    implementation(lifecycle("viewmodel-ktx"))
    implementation(lifecycle("viewmodel-compose"))

    implementation(hilt("android"))
    kapt(hilt("compiler"))

    implementation(composeUi("ui"))
    implementation(composeUi("ui-tooling"))
    implementation(compose("runtime", "runtime"))
    implementation(composeFoundation("foundation"))
    implementation(composeMaterial("material"))
    implementation(composeMaterial("material-icons-core"))
    implementation(composeMaterial("material-icons-extended"))
    implementation(composeLiveData())

    testImplementation(junit())
    androidTestImplementation(androidJunit())
    androidTestImplementation(espresso("core"))
}
