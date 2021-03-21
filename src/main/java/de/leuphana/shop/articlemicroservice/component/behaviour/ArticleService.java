package de.leuphana.shop.articlemicroservice.component.behaviour;

import java.util.List;

import de.leuphana.shop.articlemicroservice.component.structure.Article;

public interface ArticleService {
    public Article createArticle(String name, Double price);

    public Article getArticle(Integer id);

    public List<Article> searchArticles(String query);

    public Article editArticle(Integer id, String name, Double price);
}