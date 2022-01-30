FROM openjdk:17
EXPOSE 8761
ADD target/search-server-docker.jar search-server-docker.jar
ENTRYPOINT ["java", "-jar", "/search-server-docker.jar"]