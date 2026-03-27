# ==============================================================
# Stage 1 — Build the application using Gradle wrapper
# ==============================================================
FROM eclipse-temurin:25-jdk@sha256:8e17df130e8d767ecc5241fe9a78aa489bfddab8c39a91e31f235159413325ff AS builder

WORKDIR /app

# Copy Gradle wrapper and build config first (layer caching)
COPY gradlew settings.gradle build.gradle ./
COPY gradle/ gradle/

# Download dependencies (cached unless build files change)
RUN ./gradlew dependencies --no-daemon || true

# Copy source code
COPY src/ src/

# Build the fat jar, skip tests (they run in CI)
RUN ./gradlew bootJar --no-daemon -x test

# ==============================================================
# Stage 2 — Minimal runtime image
# ==============================================================
FROM eclipse-temurin:25-jre-alpine@sha256:0611ca158a2497b7ed6c2594a06fe88aa234401af0a43495f084ba1e986eba50

LABEL maintainer="dinesh"

# Create a non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /opt/app

# Copy the built jar from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Optionally copy external config (can be overridden via volume mount)
COPY src/main/resources/application.properties application.properties

# Set ownership
RUN chown -R appuser:appgroup /opt/app

USER appuser

EXPOSE 8080

# JVM tuning: respect container memory limits
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0 -XX:+UseZGC"

HEALTHCHECK --interval=30s --timeout=5s --start-period=30s --retries=3 \
    CMD wget -qO- http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar --spring.config.location=optional:classpath:/application.properties,optional:file:./application.properties"]
