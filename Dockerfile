# ==============================================================
# Stage 1 — Build the application using Gradle wrapper
# ==============================================================
FROM eclipse-temurin:25-jdk AS builder

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
FROM eclipse-temurin:25-jre-alpine

LABEL maintainer="dinesh"

# Create a non-root user for security
RUN addgroup -S appgroup && adduser -S appuser -G appgroup

WORKDIR /opt/app

# Copy the built jar from the builder stage
COPY --from=builder /app/build/libs/*.jar app.jar

# Optionally copy external config (can be overridden via volume mount)
COPY docker/application.properties application.properties

# Set ownership
RUN chown -R appuser:appgroup /opt/app

USER appuser

EXPOSE 8080

# JVM tuning: respect container memory limits
ENV JAVA_OPTS="-XX:MaxRAMPercentage=75.0 -XX:+UseZGC"

HEALTHCHECK --interval=30s --timeout=5s --start-period=30s --retries=3 \
    CMD wget -qO- http://localhost:8080/actuator/health || exit 1

ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar --spring.config.location=optional:classpath:/application.properties,optional:file:./application.properties"]
