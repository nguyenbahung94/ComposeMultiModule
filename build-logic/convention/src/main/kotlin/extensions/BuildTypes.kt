package extensions

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project

fun Project.configureBuildTypes(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildTypes {
      /*      getByName("release") {
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }*/
            getByName("debug") {
                isMinifyEnabled = false
                buildConfigField("String", "BASE_URL", "\"https://raw.githubusercontent.com/\"")
                buildConfigField("Boolean", "DEVELOPMENT_MODE", "true")
            }
        }
    }
}
