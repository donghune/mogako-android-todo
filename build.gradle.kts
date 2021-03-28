buildscript {
    val kotlin_version by extra("1.4.31")
    repositories {
        google()
        jcenter()
    }

    dependencies {
        classpath(GradleClasspath.androidGradlePlugin)
        classpath(GradleClasspath.kotlinGradlePluginClasspath)
        classpath(GradleClasspath.hiltGradlePlugin)
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version")
        classpath(GradleClasspath.safeArgs)
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven("https://jitpack.io")
    }
}

task("clean") {
    delete(rootProject.buildDir)
}