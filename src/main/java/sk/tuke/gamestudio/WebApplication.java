package sk.tuke.gamestudio;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.client.RestTemplate;
import sk.tuke.gamestudio.consoleui.ConsoleUI;
import sk.tuke.gamestudio.core.Field;
import sk.tuke.gamestudio.service.UserJPA;
import sk.tuke.gamestudio.service.UserService;

@SpringBootApplication
@Configuration
@ComponentScan(excludeFilters = @ComponentScan.Filter(type = FilterType.REGEX, pattern = "sk.tuke.gamestudio.server.*"))
public class WebApplication {

    public static void main(String[] args) {
//        SpringApplication.run(WebApplication.class, args);
        new SpringApplicationBuilder(WebApplication.class).web(WebApplicationType.NONE).run(args);
    }

    @Bean
    public CommandLineRunner runner(ConsoleUI console) {
        return s -> console.play();
    }

    @Bean
    public ConsoleUI console(Field field) {
        return new ConsoleUI(field);
    }

    @Bean
    public Field field() {
        return new Field();
    }


    @Bean
    public UserService userService() {
        return new UserJPA();
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
