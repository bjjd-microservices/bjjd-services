FROM openjdk:11 as builder
RUN mkdir -p /usr/app/src
COPY . /usr/app/src
WORKDIR /usr/app/src
RUN apt-get update && apt-get install -y dos2unix
RUN dos2unix ./mvnw
RUN ./mvnw clean install -DskipTests -P prod

FROM openjdk:11 as runtime
COPY --from=buider /usr/app/src/target/user-service-*.jar user-service-0.0.1-RELEASE.jar
EXPOSE 3379
CMD ["java","-jar","/user-service-0.0.1-RELEASE.jar"]