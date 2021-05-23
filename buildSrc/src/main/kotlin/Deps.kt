import org.gradle.kotlin.dsl.DependencyHandlerScope

fun DependencyHandlerScope.buildGradle(
    version: String = Ver.studio
) = "com.android.tools.build:gradle:$version"

fun DependencyHandlerScope.kotlinStdlib(
    version: String = Ver.kotlin
) = kotlin("stdlib", version)

fun DependencyHandlerScope.androidCore(
    version: String = Ver.android_core
) = androidx("core", "core-ktx", version)

fun DependencyHandlerScope.constraintLayout(
    version: String = Ver.constraint_layout
) = androidx("constraintlayout", "constraintlayout", version)

fun DependencyHandlerScope.androidMaterial(
    version: String = Ver.android_material
) = "com.google.android.material:material:$version"

fun DependencyHandlerScope.androidAppcompat(
    version: String = Ver.android_appcompat
) = androidx("appcompat", "appcompat", version)

fun DependencyHandlerScope.coroutines(
    name: String,
    version: String = Ver.coroutines
) = kotlinx("coroutines-$name", version)

fun DependencyHandlerScope.androidActivity(
    version: String = Ver.android_activity
) = androidx("activity", "activity-ktx", version)

fun DependencyHandlerScope.androidActivityCompose(
    version: String = "1.3.0-alpha08"
) = androidx("activity", "activity-compose", version)

fun DependencyHandlerScope.androidFragment(
    version: String = Ver.android_fragment
) = androidx("fragment", "fragment-ktx", version)

fun DependencyHandlerScope.lifecycle(
    name: String,
    version: String = when (name) {
        "viewmodel-compose" -> Ver.viewmodel_compose
        else -> Ver.android_lifecycle
    }
) = androidx("lifecycle", "lifecycle-$name", version)

fun DependencyHandlerScope.room(
    name: String,
    version: String = Ver.android_room
) = androidx("room", "room-$name", version)

fun DependencyHandlerScope.javaxInject(
    version: String = Ver.javax_inject
) = "javax.inject:javax.inject:$version"

fun DependencyHandlerScope.hilt(
    name: String,
    version: String = Ver.hilt
) = "com.google.dagger:hilt-$name:$version"

fun DependencyHandlerScope.compose(
    group: String,
    name: String,
    version: String = Ver.compose
) = androidx("compose.$group", name, version)

fun DependencyHandlerScope.composeUi(
    name: String,
    version: String = Ver.compose
) = compose("ui", name, version)

fun DependencyHandlerScope.composeFoundation(
    name: String,
    version: String = Ver.compose
) = compose("foundation", name, version)

fun DependencyHandlerScope.composeMaterial(
    name: String,
    version: String = Ver.compose
) = compose("material", name, version)

fun DependencyHandlerScope.composeLiveData(
    name: String = "runtime-livedata",
    version: String = Ver.compose
) = compose("runtime", name, version)

fun DependencyHandlerScope.junit(
    version: String = Ver.junit
) = "junit:junit:$version"

fun DependencyHandlerScope.androidJunit(
    version: String = Ver.android_junit
) = androidx("test.ext", "junit", version)

fun DependencyHandlerScope.espresso(
    name: String,
    version: String = Ver.android_espresso
) = androidx("test.espresso", "espresso-$name", version)

fun DependencyHandlerScope.kotlin(
    name: String,
    version: String = Ver.kotlin
) = "org.jetbrains.kotlin:kotlin-$name:$version"

fun DependencyHandlerScope.kotlinx(
    name: String,
    version: String = Ver.kotlin
) = "org.jetbrains.kotlinx:kotlinx-$name:$version"

fun DependencyHandlerScope.androidx(
    group: String,
    name: String,
    version: String
) = "androidx.$group:$name:$version"
