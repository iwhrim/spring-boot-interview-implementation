FROM openjdk:8-jdk-alpine
WORKDIR /usr/src
ADD city-0.0.1-SNAPSHOT.jar city-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar -Dspring.profiles.active=prod city-0.0.1-SNAPSHOT.jar
EXPOSE 8082