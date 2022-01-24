package mk.finki.ukim.dians.searchregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SearchRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SearchRegistryApplication.class, args);
    }

}
