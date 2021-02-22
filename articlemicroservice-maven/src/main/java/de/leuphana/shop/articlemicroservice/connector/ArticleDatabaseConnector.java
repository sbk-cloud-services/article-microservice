package de.leuphana.shop.articlemicroservice.connector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.transaction.Transactional;

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
        ArticleEntity articleEntity = entityManager.getReference(ArticleEntity.class, id);
        return ArticleMapper.mapArticleEntityToArticle(articleEntity);
    }

}