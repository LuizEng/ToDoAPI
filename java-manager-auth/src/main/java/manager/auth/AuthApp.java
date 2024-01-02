package manager.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"manager.auth", "manager.core"})
public class AuthApp {
    public static void main(String[] args) {
        SpringApplication.run(AuthApp.class, args);
    }
}
