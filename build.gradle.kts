// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        jcenter()
    }
    dependencies {
        classpath(buildGradle())
        classpath(kotlin("gradle-plugin"))
        classpath(hilt("android-gradle-plugin"))
    }
}

plugins {
    `ktlint-plugin` version Ver.ktlint apply false
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }
}
