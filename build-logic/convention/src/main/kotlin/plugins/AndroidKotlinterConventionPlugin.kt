package plugins

import extensions.libs
import org.gradle.api.Plugin
import org.gradle.api.Project

class AndroidKotlinterConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        target.run {
            pluginManager.apply {
                apply(libs.findPlugin("android-kotliner").get().get().pluginId)
            }
        }
    }
}
