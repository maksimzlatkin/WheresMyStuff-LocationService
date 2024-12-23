FROM openjdk:21-jdk
ARG JAR_FILE=target/*.jar
COPY ./target/location-service-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]