plugins {
    id("java")
    id("io.papermc.paperweight.userdev") version "2.0.0-beta.11"
    id("io.github.goooler.shadow") version "8.1.8"
}

repositories {
    maven("https://repo.papermc.io/repository/maven-public/") // Paper
}

dependencies {
    compileOnly(project(":core"))
    paperweight.paperDevBundle("1.21.3-R0.1-SNAPSHOT")
}

tasks {
    compileJava {
        options.encoding = Charsets.UTF_8.name()
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}