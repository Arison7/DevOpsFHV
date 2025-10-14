	plugins {
    id("org.sonarqube") version "6.3.1.5724"
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
	id("jacoco")
	application
}

group = "be.kdg.integration4"
version = "0.0.1-SNAPSHOT"
description = "demo"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}
sonar {
    properties {
        property("sonar.projectKey", "Team12")
        property("sonar.projectName", "Team12")
		property("sonar.java.coveragePlugin", "jacoco")
        property("sonar.coverage.jacoco.xmlReportPaths", "coverage-reports/jacoco/test/jacocoTestReport.xml")
    }
}


repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.test {
    finalizedBy(tasks.jacocoTestReport)
}
tasks.jacocoTestReport {
    dependsOn(tasks.test)
	reports {
        xml.required = true
    }
}
