package cw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Specification {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx =  SpringApplication.run(Specification.class, args);
        ctx.close();
    }
}