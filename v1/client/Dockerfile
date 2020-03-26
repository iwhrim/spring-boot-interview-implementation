FROM openjdk:8-jdk-alpine
WORKDIR /usr/src
ADD client-0.0.1-SNAPSHOT.jar client-0.0.1-SNAPSHOT.jar
ENTRYPOINT java -jar -Dspring.profiles.active=prod client-0.0.1-SNAPSHOT.jar
EXPOSE 8081