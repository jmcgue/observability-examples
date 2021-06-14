FROM openjdk:8-alpine

EXPOSE 8080

WORKDIR /opt/app
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]