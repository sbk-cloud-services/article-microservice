package de.leuphana.shop.articlemicroservice.component.behaviour;

import de.leuphana.shop.articlemicroservice.component.structure.Article;
import de.leuphana.shop.articlemicroservice.connector.ArticleDatabaseConnector;

public class ArticleServiceImplementation implements ArticleService {

    private static ArticleServiceImplementation articleServiceImplementation;
    private ArticleDatabaseConnector articleDatabaseConnector;
    
    public static ArticleServiceImplementation getInstance() {
        if(articleServiceImplementation == null) 
        articleServiceImplementation = new ArticleServiceImplementation();
        return articleServiceImplementation;
    }
    
    public void setArticleDatabaseConnector(ArticleDatabaseConnector articleDatabaseConnector) {
        this.articleDatabaseConnector = articleDatabaseConnector;
    }    

    @Override
    public Article createArticle(String name, Double price) {
        Article article = new Article();
        article.setName(name);
        article.setPrice(price);
        return article;
    }

	public Article getArticle(Integer id) {
		return articleDatabaseConnector.getArticle(id);
	}

}
