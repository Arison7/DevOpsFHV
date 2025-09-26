# Stage 1: Build
FROM gradle:8.3-jdk17 AS build
WORKDIR /app

# Copy Gradle files first to cache dependencies
COPY build.gradle settings.gradle gradle* ./
RUN gradle build -x test --no-daemon || true

# Copy source code
COPY src ./src

# Build the bootJar
RUN gradle bootJar --no-daemon

# Stage 2: Runtime image
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy bootJar from build stage
COPY --from=build /app/build/libs/*.jar app.jar

# Expose port
EXPOSE 8080

ENTRYPOINT ["java","-jar","app.jar"]
