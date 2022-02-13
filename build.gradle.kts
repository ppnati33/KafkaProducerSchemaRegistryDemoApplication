plugins {
    java
    idea

    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("com.avast.gradle.docker-compose") version "0.14.13"
}

group = "org.kafka.producer"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    mavenCentral()
    maven(url = "https://jitpack.io")
    maven(url = "https://packages.confluent.io/maven")
}

dependencies {
    val springCloudVersion: String by project

    // Spring
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.apache.kafka:kafka-streams")
    implementation(platform("org.springframework.cloud:spring-cloud-dependencies:$springCloudVersion"))
    implementation("org.springframework.cloud:spring-cloud-stream")
    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka")
    implementation("org.springframework.cloud:spring-cloud-stream-binder-kafka-streams")
    implementation("org.springframework.kafka:spring-kafka")
    //implementation("org.springframework.cloud:spring-cloud-schema-registry-client")
    implementation("io.confluent:kafka-json-schema-serializer:7.0.1")
}

tasks {
    withType(Test::class).configureEach { useJUnitPlatform() }
}