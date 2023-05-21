FROM openjdk:11-jre-slim-buster
COPY target/user-service-*.jar user-service-0.0.1-RELEASE.jar
EXPOSE 3379
CMD ["java","-Dspring.profiles.active=prod","-jar","/user-service-0.0.1-RELEASE.jar"]