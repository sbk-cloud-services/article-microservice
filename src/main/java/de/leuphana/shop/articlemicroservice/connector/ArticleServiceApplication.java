package de.leuphana.shop.articlemicroservice.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class ArticleServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }

    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    @Override
    public void run(String... args) throws Exception {
      applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");       
    }
}
