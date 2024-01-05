# Rajouter à terme les param mémoire
FROM openjdk:17.0.2-jdk-slim-bullseye as build-env

MAINTAINER ali.lachiheb@gmail.com

ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
