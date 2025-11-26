// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:8.1.0")       // Android Gradle plugin
        classpath("com.google.gms:google-services:4.3.15")      // Firebase Services plugin
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}

allprojects {
    repositories {

    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
