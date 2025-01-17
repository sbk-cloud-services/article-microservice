package de.leuphana.shop.articlemicroservice.connector;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import de.leuphana.shop.articlemicroservice.component.behaviour.ArticleService;
import de.leuphana.shop.articlemicroservice.component.structure.Article;

@RestController
public class ArticleRestController {

    @GetMapping("/articles")
    @ResponseBody
    public List<Article> searchArticle(@RequestParam Optional<String> searchQuery) {
        ArticleService articleService = (ArticleService) ArticleServiceApplication.getApplicationContext()
                .getBean("articleService");
        return articleService.searchArticles(!searchQuery.isPresent() ? "" : searchQuery.get());
    }

    @PostMapping("/articles")
    @ResponseBody
    public Article createArticle(@RequestBody Article article) {
        ArticleService articleService = (ArticleService) ArticleServiceApplication.getApplicationContext()
                .getBean("articleService");
        return articleService.createArticle(article.getName(), article.getPrice());
    }

    @GetMapping("/articles/{id}")
    @ResponseBody
    public Article getArticle(@PathVariable Integer id) {
        ArticleService articleService = (ArticleService) ArticleServiceApplication.getApplicationContext()
                .getBean("articleService");
        return articleService.getArticle(id);
    }

    @PostMapping("/articles/{id}")
    @ResponseBody
    public Article editArticle(@PathVariable Integer id, @RequestBody Article article) {
        ArticleService articleService = (ArticleService) ArticleServiceApplication.getApplicationContext()
                .getBean("articleService");
        return articleService.editArticle(id, article.getName(), article.getPrice());
    }
}
