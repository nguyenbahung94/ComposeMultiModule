package plugins

import com.android.build.api.dsl.ApplicationExtension
import extensions.configureAndroidCompose
import extensions.configureBuildTypes
import extensions.libs
import extensions.setJvmToolchain
import extensions.setKotlinCompile
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("com.android.application")
                apply(libs.findPlugin("compose-compiler").get().get().pluginId)
            }
            extensions.configure<ApplicationExtension> {
                compileSdk = libs.findVersion("compileSdk").get().toString().toInt()
                defaultConfig.apply {
                    minSdk = libs.findVersion("minSdk").get().toString().toInt()
                }

                defaultConfig {
                    buildFeatures {
                        buildConfig = true
                    }

                    vectorDrawables {
                        useSupportLibrary = true
                    }
                }

                lint {
                    baseline = file("lint-baseline.xml")
                }

                configureAndroidCompose(this)
                configureBuildTypes(this)
            }

            setKotlinCompile()
            setJvmToolchain()
        }
    }
}
