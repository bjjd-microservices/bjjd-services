# Use a minimal OpenJDK image as the base
FROM openjdk:11-jre-slim-buster

# Set the working directory
WORKDIR /app

# Copy the application code and any other necessary files
COPY target/account-service-*.jar /app

# Expose the port on which the application will listen
EXPOSE 7379

# Set the entry point
CMD ["java","-Dspring.profiles.active=kubernetes","-jar","/app/account-service-0.0.1-RELEASE.jar"]