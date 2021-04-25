object Ver {
    val version_code: Int
        get() = (System.currentTimeMillis() / 60_000).toInt()
    val version_name: String
        get() = "0.0.1"

    const val kotlin = "1.4.31"
    const val compile_sdk = 30
    const val build_tools = "30.0.2"
    const val min_sdk = 23
    const val target_sdk = 30
    const val jvm_target = "1.8"
    const val javax_inject = "1"

    const val coroutines = "1.4.2"

    const val android_core = "1.3.2"
    const val constraint_layout = "2.0.2"
    const val android_material = "1.3.0-alpha03"
    const val android_appcompat = "1.1.0"
    const val android_activity = "1.2.0-beta02"
    const val android_fragment = "1.3.0-beta02"
    const val android_lifecycle = "2.3.0"
    const val android_room = "2.2.6"
    const val compose = "1.0.0-alpha12"

    const val junit = "4.12"
    const val android_junit = "1.1.2"
    const val android_espresso = "3.3.0"

    const val studio = "4.1.2"
    const val ktlint = "10.0.0"

    const val hilt = "2.33-beta"
}
