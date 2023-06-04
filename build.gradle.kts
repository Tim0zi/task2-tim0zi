import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.10"
    application
}

group = "task2"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

tasks.jar {
    manifest {
        attributes["Tar-Class"] = "TarKt"
        attributes["Main-Class"] = "softdevSpringTask.TarKt"
    }
    configurations["compileClasspath"].forEach { file: File ->
        from(zipTree(file.absoluteFile))
    }
    duplicatesStrategy = DuplicatesStrategy.INCLUDE
}


dependencies {
    // Use the Kotlin JUnit 5 integration.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    // testImplementation(kotlin("test"))
    // https://mvnrepository.com/artifact/args4j/args4j
    implementation("args4j:args4j:2.33")
    implementation("info.picocli:picocli:4.7.1")
}