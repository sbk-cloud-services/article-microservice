package de.leuphana.shop.articlemicroservice.connector;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.transaction.annotation.Transactional;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
import de.leuphana.shop.articlemicroservice.connector.entity.ArticleEntity;
import de.leuphana.shop.articlemicroservice.connector.mapper.ArticleMapper;

public class ArticleDatabaseConnector {
    private EntityManager entityManager;

    @PersistenceContext(type = PersistenceContextType.TRANSACTION)
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public Integer createArticle(Article article) {
        ArticleEntity articleEntity = ArticleMapper.mapArticleToArticleEntity(article);
        entityManager.persist(articleEntity);
        return articleEntity.getId();
    }

    @Transactional
    public Article getArticle(Integer id) {
        ArticleEntity articleEntity = entityManager.find(ArticleEntity.class, id);
        if (articleEntity != null) {
            return ArticleMapper.mapArticleEntityToArticle(articleEntity);
        } else {
            return null;
        }
    }

    @Transactional
    public List<Article> searchArticles(String searchQuery) {
        List<ArticleEntity> articleEntities = entityManager.createQuery("FROM Article WHERE name LIKE :searchQuery")
                .setParameter("searchQuery", "%" + searchQuery + "%").getResultList();
        List<Article> articles = new LinkedList<>();
        for (ArticleEntity articleEntity : articleEntities) {
            articles.add(ArticleMapper.mapArticleEntityToArticle(articleEntity));
        }
        return articles;
    }
    
    @Transactional
    public Article editArticle(Integer id, String name, Double price) {
        ArticleEntity articleEntity = entityManager.find(ArticleEntity.class, id);
        Article article = ArticleMapper.mapArticleEntityToArticle(articleEntity);
        article.setName(name);
        article.setPrice(price);
        articleEntity = ArticleMapper.mapArticleToArticleEntity(article);
        entityManager.merge(articleEntity);
        return article;
    }
}
