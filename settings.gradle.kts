rootProject.name = "todo"

includeProject(":presentation", "modules/presentation")
includeProject(":domain", "modules/domain")
includeProject(":data", "modules/data")
includeProject(":local", "modules/local")
includeProject(":remote", "modules/remote")
includeProject(":util", "modules/util")
fun includeProject(name: String, projectPath: String? = null) {
    include(name)
    projectPath?.run { project(name).projectDir = File(this) }
}
