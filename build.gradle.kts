plugins {
    id("java")
    id("application")
}

repositories {
    mavenCentral()
}

dependencies {

    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
    testImplementation("io.rest-assured:rest-assured:5.3.0")


}

tasks.test {
    useJUnitPlatform()
}
