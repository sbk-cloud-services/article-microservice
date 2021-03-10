package de.leuphana.shop.articlemicroservice.connector;

import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
@TestMethodOrder(OrderAnnotation.class)
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
    @Order(1)
    public void canArticleBeCreated() {
        Assertions.assertNotNull(articleDatabaseConnector.createArticle(article));
    }

    @Test
    @Order(2)
    public void canArticleBeObtained() {
        Assertions.assertNotNull(articleDatabaseConnector.getArticle(1));
    }

    @Test
    @Order(3)
    public void canArticlesBeSearched() {
        List<Article> testArticle = articleDatabaseConnector.searchArticles("TShirt");
        Iterator<Article> iterator = testArticle.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getName() + " ");
        }
        Assertions.assertNotNull(articleDatabaseConnector.searchArticles("TShirt"));
    } 

    @Test
    @Order(4)
    public void canArticlesBeEdited() {
        articleDatabaseConnector.editArticle(1, "Hoodie", 24.99);
        Assertions.assertEquals("Hoodie", articleDatabaseConnector.getArticle(1).getName());
    }

    @Test
    @Order(5)
    public void canArticlesBeDeleted() {
        articleDatabaseConnector.deleteArticle(1);
        Assertions.assertNull(articleDatabaseConnector.getArticle(1));
    }
}