package de.leuphana.shop.articlemicroservice.connector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.articlemicroservice.component.structure.Article;

public class ArticleDatabaseConnectorTest {
    private static ApplicationContext applicationContext;
    private static ArticleDatabaseConnector articleDatabaseConnector;
    private static Article article;

    @BeforeAll
    public static void setupBeforeClass() {
        applicationContext = new ClassPathXmlApplicationContext("applicationcontext-jpa-connector.xml");
        
        article = new Article();
        article.setName("Tshirt");
        article.setPrice(12.99);

        articleDatabaseConnector = (ArticleDatabaseConnector) applicationContext.getBean("articleDatabaseConnector");
    }

    @Test
    public void canArticleBeCreated() {
        articleDatabaseConnector.createArticle(article);
    }
}