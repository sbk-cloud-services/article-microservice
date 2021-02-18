package de.leuphana.shop.articlemicroservice.component.behaviour;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
import de.leuphana.shop.articlemicroservice.component.structure.ArticleImplementation;

public class ArticleServiceImplementation implements ArticleService {

    public Article createArticle(String name, double price) {
        
        Article article = new ArticleImplementation();
        article.setName(name);
        article.setPrice(price);

        return article;
    }
    
}
