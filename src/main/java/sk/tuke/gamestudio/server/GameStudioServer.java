package sk.tuke.gamestudio.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.tuke.gamestudio.service.CommentJPA;
import sk.tuke.gamestudio.service.CommentService;
import sk.tuke.gamestudio.service.UserJPA;
import sk.tuke.gamestudio.service.UserService;

@SpringBootApplication
@Configuration
@EntityScan(basePackages = "sk.tuke.gamestudio.entity")
public class GameStudioServer {

    public static void main(String[] args) {
        SpringApplication.run(GameStudioServer.class);
    }

    @Bean
    public UserService userService() {
        return new UserJPA();
    }

    @Bean
    public CommentService commentService() {
        return new CommentJPA();
    }
}
