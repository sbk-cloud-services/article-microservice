package de.leuphana.shop.articlemicroservice.component;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.annotation.Order;

import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleService;

@TestMethodOrder(OrderAnnotation.class)
public class ArticleServiceTest {

    private static ArticleService articleService;

    @BeforeAll
    public static void setupBeforeClass() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
        articleService = (ArticleService) applicationContext.getBean("articleService");
    }

    @Test
    @Order(1)
    public void canArticleBeCreated() {
        Assertions.assertNotNull(articleService.createArticle("Shirt", 12.99));
    }

    @Test
    @Order(2)
    public void canArticleBeObtained() {
        Assertions.assertNotNull(articleService.getArticle(1));
    }

    @Test
    @Order(3)
    public void canArticlesBeSearched() {
        Assertions.assertNotNull(articleService.searchArticles("Tshirt"));
    }

    @Test
    @Order(4)
    public void canArticlesBeEdited() {
        articleService.editArticle(1, "Hoodie", 24.99);
        Assertions.assertEquals("Hoodie", articleService.getArticle(1).getName());
    }

    @Test
    @Order(5)
    public void canArticleBeDeleted() {
        articleService.deleteArticle(1);
        Assertions.assertNull(articleService.getArticle(1));
    }
}
