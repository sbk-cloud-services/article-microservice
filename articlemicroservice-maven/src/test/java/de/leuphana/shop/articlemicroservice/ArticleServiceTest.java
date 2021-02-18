package de.leuphana.shop.articlemicroservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleService;
import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleServiceImplementation;

public class ArticleServiceTest {

    private static ArticleService articleService;

@BeforeAll
    public static void setupBeforeClass() {
        articleService = new ArticleServiceImplementation();
    }

@Test
public void canArticleBeCreated() {
    Assertions.assertNotNull(articleService.createArticle("Shirt", 12.99));
}
   
}
