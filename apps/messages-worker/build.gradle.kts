plugins {
	java
	application
	id("org.springframework.boot") version "3.1.2"
	id("io.spring.dependency-management") version "1.1.2"
}

group = "com.javachallenge"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_19
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")
	implementation("org.springframework.boot:spring-boot-starter-data-redis-reactive")
	implementation("org.springframework.kafka:spring-kafka")
	implementation("com.fasterxml.jackson.core:jackson-databind:2.15.1")
	implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:2.14.2")
	implementation("jakarta.validation:jakarta.validation-api:3.0.2")
	implementation("redis.clients:jedis:5.0.0-alpha2")
	implementation("org.springframework.data:spring-data-redis:3.1.2")
	implementation("com.google.guava:guava:31.1-jre")
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("org.postgresql:postgresql")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
	testImplementation("org.springframework.kafka:spring-kafka-test")
}

application {
	mainClass.set("com.javachallenge.streamworker.StreamWorkerApplication")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
