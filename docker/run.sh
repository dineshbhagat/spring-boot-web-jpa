#!/bin/sh
set -e

echo "Starting Spring Boot application..."

exec java \
    -XX:MaxRAMPercentage=75.0 \
    -XX:+UseZGC \
    ${JAVA_OPTS:-} \
    -jar /opt/app/app.jar \
    --spring.config.location=optional:classpath:/application.properties,optional:file:/opt/app/application.properties
