import java.util.*

plugins {
    id("org.jetbrains.kotlin.jvm")
    id("maven-publish")
    id("com.jfrog.bintray")
    application
}

version = Dependencies.apiClassesGeneratorVersion
group = "org.godotengine.kotlin"

repositories {
    mavenLocal()
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    implementation("com.beust:klaxon:3.0.1") //5.2
    implementation("com.squareup:kotlinpoet:${Dependencies.kotlinPoetVersion}")
}

application {
    mainClassName = "GeneratorKt"
}

publishing {
    publications {
        register("apiClassesGenerator", MavenPublication::class.java) {
            from(components["java"])
        }
    }
}

tasks.build {
    finalizedBy(tasks.run) //execute godot api classes generation after building the api_classes_generator project
}

tasks.clean {
    doFirst {
        delete("${rootDir}/wrapper/godot-library/src/main/kotlin/godot/generated") //delete classes generated by this generator
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

val bintrayUser: String by project
val bintrayKey: String by project

if(project.hasProperty("bintrayUser") && project.hasProperty("bintrayKey")) {
    bintray {
        user = bintrayUser
        key = bintrayKey

        setPublications("apiClassesGenerator")
        pkg(delegateClosureOf<com.jfrog.bintray.gradle.BintrayExtension.PackageConfig> {
            userOrg = "utopia-rise"
            repo = "kotlin-godot"

            name = project.name
            vcsUrl = "https://github.com/utopia-rise/kotlin-godot-wrapper"
            setLicenses("Apache-2.0")
            version(closureOf<com.jfrog.bintray.gradle.BintrayExtension.VersionConfig> {
                this.name = project.version.toString()
                released = Date().toString()
                description = "Godot API classes generator ${project.version}"
                vcsTag = project.version.toString()
            })
        })
    }
}