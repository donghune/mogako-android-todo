plugins {
    `android-application`
    `kotlin-android`
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
        jvmTarget = Ver.jvm_target
    }
}

dependencies {
    implementation(kotlinStdlib())
    implementation(androidCore())
    implementation(androidAppcompat())
    implementation(androidMaterial())
    implementation(constraintLayout())
    implementation(coroutines("android"))

    testImplementation(junit())
    androidTestImplementation(androidJunit())
    androidTestImplementation(espresso("core"))
}
