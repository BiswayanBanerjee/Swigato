FROM openjdk:25-jdk-slim

# Render injects PORT dynamically, default to 10000
ENV PORT=10000
ENV TRUSTSTORE_PASSWORD=changeit

WORKDIR /app

# Copy app JAR
COPY target/*.jar app.jar

# Copy the truststore (created from ca.pem)
COPY src/main/resources/aiven-truststore.jks aiven-truststore.jks

EXPOSE ${PORT}

# Run app with truststore configured
ENTRYPOINT ["java", "-Djavax.net.ssl.trustStore=/app/aiven-truststore.jks", "-Djavax.net.ssl.trustStorePassword=changeit", "-Djavax.net.ssl.trustStoreType=JKS", "-jar", "app.jar"]
