plugins {
    application
    kotlin("jvm")
    id("io.ktor.plugin")
    kotlin("plugin.serialization")
    id("com.squareup.sqldelight")
}
group = "com.example"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

sqldelight {
    database("ServerSideDatabase") {
        packageName = "com.example.db"
    }
}

val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val kmongo_version: String by project

dependencies {
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")

    implementation("org.litote.kmongo:kmongo:$kmongo_version")
    implementation("org.litote.kmongo:kmongo-coroutine:$kmongo_version")

    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("com.squareup.sqldelight:core:1.5.5")
    implementation("com.squareup.sqldelight:sqlite-driver:1.5.5")
    // implementation("com.squareup.sqldelight:android-driver:1.5.5")
    // implementation("com.squareup.sqldelight:android-paging-extensions:1.5.5")
    // implementation("com.squareup.sqldelight:android-paging3-extensions:1.5.5")
    implementation("com.squareup.sqldelight:coroutines-extensions:1.5.5")//Kotlin extension functions to expose SQLDelight's Query as a Flow
    implementation("com.squareup.sqldelight:coroutines-extensions-jvm:1.5.5")
    implementation("com.squareup.sqldelight:runtime:1.5.5")
    implementation("com.squareup.sqldelight:runtime-jvm:1.5.5")
    // implementation("com.squareup.sqldelight:jdbc-driver:1.5.5")
}