package de.leuphana.shop.articlemicroservice.component.behaviour;

import de.leuphana.shop.articlemicroservice.component.structure.Article;

public interface ArticleService {
    public Article createArticle(String name, double price);    
}
