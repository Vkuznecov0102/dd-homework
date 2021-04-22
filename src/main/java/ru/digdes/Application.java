package ru.digdes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.digdes.server.DatabaseConnection;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        var context=SpringApplication.run(Application.class);
        context.getBean(DatabaseConnection.class).connect();
    }
}
