# Use the official OpenJDK image as the base image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the pom.xml file first to avoid rebuilding dependencies on every change
COPY pom.xml .

# Install Maven and fetch dependencies
RUN apt-get update && apt-get install -y maven
RUN mvn dependency:go-offline

# Copy the rest of the application code
COPY . .

# Build the application using Maven
RUN mvn clean package -DskipTests

# Run the application
CMD ["java", "-jar", "target/hello-world-1.0-SNAPSHOT.jar"]

