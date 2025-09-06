# Use lightweight OpenJDK image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven wrapper and pom.xml
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy source code
COPY src ./src

# Package the application
RUN ./mvnw clean package -DskipTests

# Expose the port (Render will override with $PORT)
EXPOSE 8080

# Run the Spring Boot jar
CMD ["java", "-jar", "target/portfolio-builder-0.0.1-SNAPSHOT.jar"]
