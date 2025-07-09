
# Use an OpenJDK base image
FROM openjdk:17-jdk-slim

# Add a label (optional)
LABEL maintainer="vinitparamane2810@gmail.com"

# Set a working directory
WORKDIR /app

# Copy the JAR file into the image
COPY target/MyFitMomAndDad-0.0.1-SNAPSHOT.jar app.jar

# Expose the port your app runs on (optional but recommended)
EXPOSE 8080

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]

