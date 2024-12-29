plugins {
    java
    checkstyle
}

group = "hexlet.code"
version = "1.0-SNAPSHOT"

checkstyle {
    toolVersion = "10.20.1"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.apache.commons:commons-lang3:3.17.0")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}