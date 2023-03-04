FROM maven:3.8.1-openjdk-11-slim AS builder
RUN mkdir -p /usr/app
COPY .. /usr/app
WORKDIR /usr/app
RUN mvn clean install -DskipTests -P prod

FROM openjdk:11-jre-slim-buster as runtime
COPY --from=buider /usr/app/target/user-service-*.jar user-service-0.0.1-RELEASE.jar
EXPOSE 3379
CMD ["java","-jar","/user-service-0.0.1-RELEASE.jar"]