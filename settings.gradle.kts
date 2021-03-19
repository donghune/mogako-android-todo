rootProject.name = "todo"

includeProject(":presentation", "modules/presentation")
fun includeProject(name: String, projectPath: String? = null) {
    include(name)
    projectPath?.run { project(name).projectDir = File(this) }
}