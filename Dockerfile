FROM openjdk:8
FROM maven:3.8-jdk-11
COPY * /home/test/
WORKDIR /home/test/
RUN 'mvn spring-boot:run'
