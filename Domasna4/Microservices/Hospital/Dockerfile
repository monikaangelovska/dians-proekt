FROM openjdk:17
EXPOSE 9004
ADD target/hospital-docker.jar hospital-docker.jar
ENTRYPOINT ["java", "-jar", "/hospital-docker.jar"]