// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}
buildscript {
    dependencies {
        // Ensure this is present for Kotlin annotation processing (kapt)
        classpath(libs.kotlin.gradle.plugin) // Match your Kotlin version
    }
}