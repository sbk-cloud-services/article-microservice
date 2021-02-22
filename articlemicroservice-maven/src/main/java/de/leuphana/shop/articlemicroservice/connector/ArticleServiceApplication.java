package de.leuphana.shop.articlemicroservice.connector;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleServiceImplementation;

public class ArticleServiceApplication implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(ArticleServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        ArticleDatabaseConnector articleDatabaseConnector = (ArticleDatabaseConnector) applicationContext.getBean("customerDatabaseConnector");
        ArticleServiceImplementation.getInstance().setArticleDatabaseConnector(articleDatabaseConnector);
    }
}
