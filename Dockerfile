# Use lightweight OpenJDK 21 image
FROM openjdk:21-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Ensure Maven wrapper is executable
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Package the application (skip tests for faster build)
RUN ./mvnw clean package -DskipTests

# Expose the port (Render uses $PORT automatically)
EXPOSE 8080

# Run the Spring Boot application
CMD ["java", "-jar", "target/portfolio-builder-0.0.1-SNAPSHOT.jar"]
