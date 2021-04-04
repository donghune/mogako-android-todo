import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

object Modules {
    val app = ":app"
    val data = ":data"
    val domain = ":domain"
    val presentation = ":presentation"
}

object Libraries {
    // Hilt
    val hilt = "com.google.dagger:hilt-android:${Versions.hiltCore}"
    val hiltLifecycle = "androidx.hilt:hilt-lifecycle-viewmodel:${Versions.hiltAndroidX}"
    val hiltCore = "com.google.dagger:hilt-android:${Versions.hiltCore}"

    // hiltKapt
    val hiltKapt = "com.google.dagger:hilt-android-compiler:${Versions.hiltCore}"
    val hiltAndroidx = "androidx.hilt:hilt-compiler:${Versions.hiltAndroidX}"

    // REACTIVEX
    val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rxKotlin}"
    val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
    val rxbinding = "com.jakewharton.rxbinding2:rxbinding-kotlin:${Versions.rxbinding}"

    // RETROFIT
    val gson = "com.google.code.gson:gson:${Versions.gson}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitGson}"
    val retrofitMoshiConverter = "com.squareup.retrofit2:converter-moshi:${Versions.retrofitGson}"
    val httpLoggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    val retrofitRxAdapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.rxjava2Adapter}"

    // GLIDE
    val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"


    val jodaTime ="joda-time:joda-time:${Versions.jodaTime}"

}


object AndroidLibraries {
    // ANDROID
    val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
    val materialDesign = "com.google.android.material:material:${Versions.materialDesign}"
    val coreKtx = "androidx.core:core-ktx:${Versions.coreKtx}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
    val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.lifecycle}"
    val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
    val fragment = "androidx.fragment:fragment-ktx:${Versions.fragmentVersion}"
    val googleCore = "com.google.android.play:core:${Versions.googleCore}"

    // recyclerview
    val recyclerView = "androidx.recyclerview:recyclerview:${Versions.recyclerview}"

    // navigation
    val navigationRuntimeKtx = "androidx.navigation:navigation-runtime-ktx:${Versions.navigation}"
    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"

    // Room
    val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
    val roomKapt = "androidx.room:room-compiler:${Versions.room}"
    val roomKtx = "androidx.room:room-ktx:${Versions.room}"
    val roomRxJava ="androidx.room:room-rxjava2:${Versions.room}"
    val roomGuava = "androidx.room:room-guava:${Versions.room}"
    val concurrent ="androidx.concurrent:concurrent-futures-ktx:${Versions.concurrent}"

}

object LibraryList {
    val appLibraries = arrayListOf<String>().apply {
        add(AndroidLibraries.kotlin)
        add(AndroidLibraries.appCompat)
        add(AndroidLibraries.materialDesign)
        add(AndroidLibraries.coreKtx)
        add(AndroidLibraries.constraintLayout)
        add(AndroidLibraries.lifecycleViewModel)
        add(AndroidLibraries.lifecycleExtensions)
        add(AndroidLibraries.lifecycleLiveData)
        add(AndroidLibraries.fragment)
        add(AndroidLibraries.googleCore)
    }


    val roomLibrary = arrayListOf<String>().apply {
        add(AndroidLibraries.roomRuntime)
        add(AndroidLibraries.roomKapt)
        add(AndroidLibraries.roomKtx)
        add(AndroidLibraries.roomRxJava)
        //add(AndroidLibraries.roomGuava)
       // add(AndroidLibraries.concurrent)

    }

    val RecyclerViewLibraries = arrayListOf<String>().apply {
        add(AndroidLibraries.recyclerView)
    }

    val NavigationLibraries = arrayListOf<String>().apply {
        add(AndroidLibraries.navigationRuntimeKtx)
        add(AndroidLibraries.navigationFragmentKtx)
        add(AndroidLibraries.navigationUiKtx)
    }

    val HiltLibraries = arrayListOf<String>().apply {
        add(Libraries.hilt)
        add(Libraries.hiltCore)
        add(Libraries.hiltLifecycle)
    }

    val HiltLibraryKapt = arrayListOf<String>().apply {
        add(Libraries.hiltKapt)
        add(Libraries.hiltAndroidx)
    }

    val rx = arrayListOf<String>().apply {

        add(Libraries.rxKotlin)
        add(Libraries.rxAndroid)
        add(Libraries.rxbinding)
    }

    val RetrofitLibraries = arrayListOf<String>().apply {
        add(Libraries.gson)
        add(Libraries.retrofit)
        add(Libraries.retrofitGsonConverter)
        add(Libraries.httpLoggingInterceptor)
        add(Libraries.retrofitRxAdapter)
    }


    val Glide = arrayListOf<String>().apply {
        add(Libraries.glide)
        add(Libraries.glideCompiler)
    }


}

fun DependencyHandler.kaptList(list: List<String>) {
    list.forEach { dependency ->
        add("kapt", dependency)
    }
}

fun DependencyHandler.implementationList(list: List<String>) {
    list.forEach { dependency ->
        add("implementation", dependency)
    }
}

fun DependencyHandler.androidTestImplementationList(list: List<String>) {
    list.forEach { dependency ->
        add("androidTestImplementation", dependency)
    }
}

fun DependencyHandler.testImplementationList(list: List<String>) {
    list.forEach { dependency ->
        add("testImplementation", dependency)
    }
}