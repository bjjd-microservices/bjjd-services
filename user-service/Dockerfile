FROM openjdk:11 as builder
RUN mkdir /app/src
COPY . /app/src
WORKDIR /app/src
RUN ./mvnw clean install -DskipTests -P prod

FROM openjdk:11 as runtime
COPY --from=buider /app/src/target/user-service-*.jar user-service-0.0.1-RELEASE.jar
EXPOSE 3379
CMD ["java","-jar","/user-service-0.0.1-RELEASE.jar"]