package de.leuphana.shop.articlemicroservice.component.behaviour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
import de.leuphana.shop.articlemicroservice.connector.ArticleDatabaseConnector;

@Component
public class ArticleServiceImplementation implements ArticleService {

    private ArticleDatabaseConnector articleDatabaseConnector;

    @Autowired
    public ArticleServiceImplementation(ArticleDatabaseConnector articleDatabaseConnector) {
        this.articleDatabaseConnector = articleDatabaseConnector;
    }

    @Override
    public Article createArticle(String name, Double price) {
        Article article = new Article();
        article.setName(name);
        article.setPrice(price);
        article.setId(articleDatabaseConnector.createArticle(article));
        return article;
    }

    @Override
    public Article getArticle(Integer id) {
        return articleDatabaseConnector.getArticle(id);
    }

    @Override
    public List<Article> searchArticles(String searchQuery) {
        return articleDatabaseConnector.searchArticles(searchQuery);
    }

    @Override
    public void deleteArticle(Integer id) {
        articleDatabaseConnector.deleteArticle(id);
    }

    @Override
    public Article editArticle(Integer id, String name, Double price) {
        return articleDatabaseConnector.editArticle(id, name, price);
    }
}
