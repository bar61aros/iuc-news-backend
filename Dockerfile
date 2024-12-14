# Use an OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy Gradle wrapper and project configuration files
COPY gradlew ./
COPY gradle ./gradle
COPY build.gradle settings.gradle ./

# Pre-cache dependencies
RUN ./gradlew build --no-daemon -x test || true

# Copy the application source code
COPY src ./src

# Expose the application port
EXPOSE 8080

# Build the Spring Boot JAR file
RUN ./gradlew bootJar --no-daemon

# Run the application
ENTRYPOINT ["java", "-jar", "build/libs/iuc-news-backend-0.0.1-SNAPSHOT.jar"]
