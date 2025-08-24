enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.spongepowered.org/repository/maven-public/")
        maven("https://maven.fabricmc.net/")
        maven {
            name = "canvasmc"
            url = uri("https://maven.canvasmc.io/snapshots")
        }
    }
    includeBuild("build-logic")
}

rootProject.name = "gaia"

include("jmh")
setupSubproject("api")
setupSubproject("common")
setupSubproject("paper")
setupSubproject("fabric")

fun setupSubproject(moduleName: String) {
    val name = "gaia-$moduleName"
    include(name)
    project(":$name").projectDir = file(moduleName)
}
