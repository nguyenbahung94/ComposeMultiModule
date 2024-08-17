package plugins

import extensions.configureDetekt
import extensions.libs
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType

class AndroidDetektConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("io.gitlab.arturbosch.detekt")
            }

            val extension = extensions.getByType<DetektExtension>()
            configureDetekt(extension)

            dependencies {
                "detektPlugins"(libs.findLibrary("detekt-formatting").get())
            }
        }
    }
}
