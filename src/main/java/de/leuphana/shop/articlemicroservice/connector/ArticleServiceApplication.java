package de.leuphana.shop.articlemicroservice.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication

@ImportResource
public class ArticleServiceApplication implements CommandLineRunner {
    
    private static ApplicationContext applicationContext;
    
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }
    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }
    
    @Override
    public void run(String... args) throws Exception {
      applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");       
    }
}
