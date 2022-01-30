FROM openjdk:17
EXPOSE 9191
ADD target/api-docker.jar api-docker.jar
ENTRYPOINT ["java", "-jar", "/api-docker.jar"]