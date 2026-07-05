plugins {
    id("java")
    id("org.springframework.boot")
    id("io.spring.dependency-management")
}

dependencies {
    implementation(project(":shared"))
    implementation(platform("org.springframework.ai:spring-ai-bom:2.0.0"))
    implementation("org.springframework.ai:spring-ai-starter-model-ollama")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    compileOnly("org.projectlombok:lombok")
    annotationProcessor("org.projectlombok:lombok")
}