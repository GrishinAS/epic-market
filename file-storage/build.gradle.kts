import net.researchgate.release.GitAdapter
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	application
	id("com.palantir.docker") version "0.32.0"
	id("net.researchgate.release") version "2.8.1"
}

java.sourceCompatibility = JavaVersion.VERSION_17
version = "0.0.9" // todo move outside

release { // is not used right now
	tagTemplate = "v${version}"
	with (propertyMissing("git") as GitAdapter.GitConfig) {
		requireBranch =""
	}
	failOnCommitNeeded = false
	failOnUnversionedFiles = false
}

application {
	applicationDefaultJvmArgs = mutableListOf("--add-opens", "java.base/java.net=ALL-UNNAMED")
}

val incrementVersion by tasks.registering {
	doFirst {
		val version = version.toString()
		val minor = version.substring(version.lastIndexOf('.') + 1)
		val incremented : Int = 1 + Integer.parseInt(minor)
		val major=version.substring(0, version.length - 1)
		val changedScript = buildFile.readText().replaceFirst("version = \"$version\"", "version = \"$major$incremented\"")
		buildFile.writeText(changedScript)
	}
}

docker {
	dependsOn(tasks.bootJar.get(), incrementVersion.get())
	copySpec.into("build/libs")
	name = "${project.name}:latest"
	files("build/libs/${project.name}-${project.version}.jar")
}

task("deploy-local") {
	dependsOn(":docker")
	doLast {
		exec {
			workingDir = file("deployment")
			executable = "kubectl"
			args("apply", "-f", "file-service.yml")
		}
	}
}

task("redeploy-local") {
	dependsOn(":docker")
	doLast {
		exec {
			workingDir = file("deployment")
			executable = "kubectl"
			args("replace", "--force", "-f", "file-service.yml")
		}
	}
}


repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-data-jdbc")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation("io.springfox:springfox-boot-starter:3.0.0")
	implementation("io.springfox:springfox-swagger-ui:3.0.0")

	implementation("org.postgresql:postgresql:42.3.1")
	implementation("commons-io:commons-io:20030203.000550")
	implementation("org.imgscalr:imgscalr-lib:4.2")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
