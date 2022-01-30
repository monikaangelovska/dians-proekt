FROM openjdk:17
EXPOSE 9001
ADD target/clinic-docker.jar clinic-docker.jar
ENTRYPOINT ["java", "-jar", "/clinic-docker.jar"]