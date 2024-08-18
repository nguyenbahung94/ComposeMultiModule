package plugins

import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("composeln.library")
                apply("composeln.kotlin.android")
                apply("composeln.hilt")
                apply("composeln.detekt")
                apply("composeln.ktlint")
                apply(libs.findPlugin("kotlin-parcelize").get().get().pluginId)
                apply(libs.findPlugin("kotlin-serialization").get().get().pluginId)
            }

            dependencies {
                "implementation"(project(":core"))
                "implementation"(project(":network"))
            }
        }
    }
}
