package ca.jrvs.apps.twitter.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TwitterCLISpringBoot {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TwitterCLISpringBoot.class);
        app.setWebApplicationType(WebApplicationType.NONE);
        runner.run(args);
    }


}
