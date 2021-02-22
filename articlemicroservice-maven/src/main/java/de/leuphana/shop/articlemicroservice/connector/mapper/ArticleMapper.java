package de.leuphana.shop.articlemicroservice.connector.mapper;

import org.dozer.DozerBeanMapperSingletonWrapper;
import org.dozer.Mapper;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
import de.leuphana.shop.articlemicroservice.connector.entity.ArticleEntity;

public class ArticleMapper {

    private static Mapper mapper;

    static {
        mapper = DozerBeanMapperSingletonWrapper.getInstance();
    }
    
    public static ArticleEntity mapArticleToArticleEntity(Article article) {
        return mapper.map(article, ArticleEntity.class);
    }

    public static Article mapArticleEntityToArticle(ArticleEntity articleEntity) {
        return mapper.map(articleEntity, Article.class);
    }
}
