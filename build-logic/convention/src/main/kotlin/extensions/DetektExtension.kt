package extensions

import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.named

internal fun Project.configureDetekt(extension: DetektExtension) = extension.apply {
    tasks.named<Detekt>("detekt") {
        reports {
            xml.required.set(true)
            html.required.set(true)
            txt.required.set(true)
        }
    }
    toolVersion = libs.findVersion("detekt").get().toString()
    source.setFrom("src/main/java", "src/main/kotlin")
    autoCorrect = true
    config.setFrom(files("$rootDir/config/detekt/detekt.yml"))
    dependencies {
        "detektPlugins"(libs.findLibrary("detekt-formatting").get())
    }
}
