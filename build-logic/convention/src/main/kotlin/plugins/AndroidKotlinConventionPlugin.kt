package plugins

import com.android.build.api.dsl.LibraryExtension
import extensions.configureAndroidKotlin
import extensions.configureBuildTypes
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure

class AndroidKotlinConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.android")
                apply("composeln.detekt")
            }
            extensions.configure<LibraryExtension> {
                configureAndroidKotlin(this)
                configureBuildTypes(this)
            }
        }
    }
}
