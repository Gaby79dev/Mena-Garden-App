import java.net.URI
import org.gradle.api.tasks.Delete

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.31")
    val compileSdkVersion by extra(29)
    val targetSdkVersion by extra(30)
    val minSdkVersion by extra(21)
    //Plugins
    val gradleVersion by extra("3.6.3")
    val safeArgsVersion by extra("2.2.0")
    //KTX
    val ktxVersion by extra("1.3.2")
    val ktxFragmentVersion by extra("1.2.5")
    val ktxLifecycleVersion by extra("2.2.0")
    val ktxNavigationVersion by extra("2.3.2")
    //androidx
    val appCompatVersion by extra("1.2.0")
    val recyclerViewVersion by extra("1.1.0")
    val preferenceVersion by extra("1.1.1")
    val lifecycleVersion by extra("2.2.0")
    val constraintLayoutVersion by extra("2.0.4")

    repositories {
        google()
        jcenter()
        mavenCentral()
        maven { url = uri("https://maven.google.com") }
    }

    dependencies {
        classpath("com.android.tools.build:gradle:4.1.2")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:${property("kotlin_version")}")
        classpath("com.google.gms:google-services:4.3.5")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.28-alpha")
        // Corrected to use safeArgsVersion from extra, which is 2.2.0
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:${property("safeArgsVersion")}")
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        maven { url = uri("https://jitpack.io") }
    }
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
