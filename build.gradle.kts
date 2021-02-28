import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.10"
    application
}

group = "unir.pfm.ingestor"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // kmongo
    implementation("org.litote.kmongo:kmongo:4.2.4")

    //OpenCSV
    implementation("com.opencsv:opencsv:5.3")
}


tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClassName = "MainKt"
}