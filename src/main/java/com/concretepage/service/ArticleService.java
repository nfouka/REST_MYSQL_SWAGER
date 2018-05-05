package com.concretepage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.concretepage.dao.IArticleDAO;
import com.concretepage.entity.Article;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
@Service
public class ArticleService implements IArticleService {
	@Autowired
	private IArticleDAO articleDAO;
	@Override
	public Article getArticleById(int articleId) {
		Article obj = articleDAO.getArticleById(articleId);
		return obj;
	}	
	@Override
	public List<Article> getAllArticles(){
		return articleDAO.getAllArticles();
	}
	@Override
	public synchronized boolean addArticle(Article article){
       if (articleDAO.articleExists(article.getTitle(), article.getCategory())) {
    	   return false;
       } else {
    	   articleDAO.addArticle(article);
    	   return true;
       }
	}
	@Override
	public void updateArticle(Article article) {
		articleDAO.updateArticle(article);
	}
	@Override
	public void deleteArticle(int articleId) {
		articleDAO.deleteArticle(articleId);
	}
	
    private ApiInfo metadata2() {
        return new ApiInfoBuilder()
                .title( "My awesome ACS API" )
                .description( "All the requests that the server will respond to." )
                .version( "1.0.0" )
                .build();
    }
}
