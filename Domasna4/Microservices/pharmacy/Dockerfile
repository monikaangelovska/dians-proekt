FROM openjdk:17
EXPOSE 9003
ADD target/pharmacy-docker.jar pharmacy-docker.jar
ENTRYPOINT ["java", "-jar", "/pharmacy-docker.jar"]