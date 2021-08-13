import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar

plugins {
    `java-library`
    `maven-publish`
    signing
    id("io.freefair.lombok") version("6.1.0")
    id("com.github.johnrengelman.shadow") version("7.0.0")
}

group  = "com.github.jacekpoz"
version  = "0.4.2"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.7.2")
    implementation("com.kosprov.jargon2:jargon2-api:1.1.1")
    runtimeOnly("com.kosprov.jargon2:jargon2-native-ri-backend:1.1.1")
    implementation("com.github.mpkorstanje:simmetrics-core:4.1.1")
    implementation("com.fasterxml.jackson.core:jackson-core:2.12.4")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.4")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.12.4")
}

tasks {
    test {
        useJUnitPlatform()
    }
    val shadowJar by getting(ShadowJar::class) {
        archiveClassifier.set("")
        archiveFileName.set("${project.name}-${project.version}.jar")
    }
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            groupId = "com.github.jacekpoz"
            artifactId = "xnor-lib"
            version = project.version as String?

            from(components["java"])
        }
    }
}