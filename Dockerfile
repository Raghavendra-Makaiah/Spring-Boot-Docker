FROM openjdk:8-jdk-alpine
RUN addgroup -S sbdd && adduser -S sbdd -G sbdd
USER sbdd:sbdd
RUN mvn -f pom.xml clean package
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","target/app.jar"]
