plugins {
	java
	id("org.springframework.boot") version "3.3.1"
	id("io.spring.dependency-management") version "1.1.5"
	id("org.sonarqube") version "4.4.1.3373"
	jacoco // Plugin do JaCoCo
}

jacoco {
	toolVersion = "0.8.8" // Última versão do JaCoCo
}

tasks.test {
	useJUnitPlatform()
	finalizedBy(tasks.jacocoTestReport) // Garante que o relatório seja gerado após os testes
}

tasks.jacocoTestReport {
	dependsOn(tasks.test) // Garante que os testes sejam executados antes do relatório
	reports {
		xml.required.set(true) // Necessário para o SonarCloud
		csv.required.set(false)
		html.required.set(true)
	}
}

tasks.sonarqube {
	dependsOn(tasks.jacocoTestReport) // Garante que o SonarCloud tenha a cobertura antes de rodar
}

sonarqube {
	properties {
		property("sonar.projectKey", "marceloebert_Fastfood-Microservico-Production-API")
		property("sonar.host.url", "https://sonarcloud.io")
		property("sonar.organization", "marceloebert")
		property("sonar.login", System.getenv("SONAR_TOKEN"))
	}
}

group = "com.fiap"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	//implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	//implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-validation")
	implementation("mysql:mysql-connector-java:8.0.30")
	implementation("org.springframework.boot:spring-boot-starter-test")
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.6.0")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	compileOnly("org.projectlombok:lombok")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("com.h2database:h2")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	implementation("software.amazon.awssdk:aws-core:2.30.3")
	implementation("software.amazon.awssdk:sdk-core:2.30.3")
	implementation("software.amazon.awssdk:auth:2.30.3")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
