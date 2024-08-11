import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
}

dependencies {
    implementation(libs.build.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApp") {
            id = "composeln.application"
            implementationClass = "plugins.AndroidApplicationComposeConventionPlugin"
        }
        register("androidHilt") {
            id = "composeln.hilt"
            implementationClass = "plugins.AndroidHiltConventionPlugin"
        }
        register("androidLibrary") {
            id = "composeln.library"
            implementationClass = "plugins.AndroidLibraryComposeConventionPlugin"
        }
        register("androidKotlin") {
            id = "composeln.kotlin.android"
            implementationClass = "plugins.AndroidKotlinConventionPlugin"
        }
    }
}
