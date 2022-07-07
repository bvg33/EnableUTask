FROM openjdk:8-jdk-alpine
MAINTAINER Dima.Savkov
COPY build/libs/task-0.0.1.jar task.jar
ENTRYPOINT ["java","-jar","/task.jar"]