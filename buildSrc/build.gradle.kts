
plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    google()
    jcenter()
}

gradlePlugin {
    plugins {
        register("base-gradle-plugin") {
            id = "base-gradle-plugin"
            implementationClass = "base_plugin.BaseGradlePlugin"
        }
    }
}

dependencies {

    implementation(kotlin("stdlib"))
    implementation("com.android.tools.build:gradle:4.1.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.31")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.4.21")
}
