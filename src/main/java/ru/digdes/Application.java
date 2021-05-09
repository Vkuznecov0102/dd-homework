package ru.digdes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import ru.digdes.servlet.DemoServlet;

import java.sql.SQLException;

@SpringBootApplication
public class Application {

    @Bean
    public ServletRegistrationBean<DemoServlet> servletRegistrationBean() {
        return new ServletRegistrationBean<>(
                new DemoServlet(), "/first");
    }

    public static void main(String[] args) throws SQLException {
        var context=SpringApplication.run(Application.class);
//        Console.main();
    }
}
