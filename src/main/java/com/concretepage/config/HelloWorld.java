package com.concretepage.config;

import org.springframework.beans.factory.annotation.Autowired;

import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;

public class HelloWorld {
	
	
	@Autowired
	private IArticleService articleService;

	@Override
	public String toString() {
		
		
	 	for(int i = 0 ; i< 10 ; i++ ) {
		    Article article = new Article() ;  article.setTitle("title100 " + Math.random()); article.setCategory("Categ" + Math.random() ) ; 
		 	articleService.addArticle(article) ; 
		 	System.err.println(article.toString());
		 	}
		
		return "HelloWorld [getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}
