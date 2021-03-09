package de.leuphana.shop.articlemicroservice.connector;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleService;
import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleServiceImplementation;
import de.leuphana.shop.articlemicroservice.component.structure.Article;

public class ArticleRestController {

    @PostMapping("/articles")
    @ResponseBody
    public Article createArticle(@RequestBody Article article) {
        ArticleService articleService = ArticleServiceImplementation.getInstance();
        return articleService.createArticle(article.getName(), article.getPrice());
    }

    @GetMapping("/articles/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable("id") Integer id) {
        return ArticleServiceImplementation.getInstance().getArticle(id);
    }
}
