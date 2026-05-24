# Use Java 21
FROM eclipse-temurin:21

# Set working directory
WORKDIR /app

# Copy jar file
COPY target/*.jar app.jar

# Expose port
EXPOSE 8083

# Run app
ENTRYPOINT ["java", "-jar", "app.jar"]