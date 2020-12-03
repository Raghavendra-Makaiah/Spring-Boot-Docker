FROM openjdk:8-jdk-alpine
RUN addgroup -S sbdd && adduser -S sbdd -G sbdd
USER sbdd:sbdd
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
