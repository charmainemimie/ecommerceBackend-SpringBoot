# Stage 1: Build the application
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app
COPY . .
RUN mvn clean package -DskipTests

# Stage 2: Run the application
FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]



# Use Java 21
#FROM eclipse-temurin:21

# Set working directory
#WORKDIR /app

# Copy jar file
#COPY target/*.jar app.jar

# Expose port
#EXPOSE 8083

# Run app
#ENTRYPOINT ["java", "-jar", "app.jar"]