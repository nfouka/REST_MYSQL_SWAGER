package com.concretepage;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import com.concretepage.config.HelloWorldConfig;
import com.concretepage.entity.Article;
import com.concretepage.service.IArticleService;
@SpringBootApplication
@Component
public class MyApplication {  
	
	@Autowired
	private IArticleService articleService;
	
	@Autowired
	private HelloWorldConfig helloWorldConfig ; 
	
	
	public static void main(String[] args) {
		SpringApplication.run(MyApplication.class, args);
    } 
	
	
	 @PostConstruct
	 public void init(){
		 	for(int i = 0 ; i< 10  ; i++ ) {
		    Article article = new Article() ;  article.setTitle("title100 " + Math.random()); article.setCategory("Categ" + Math.random() ) ; 
		 	articleService.addArticle(article) ; 
		 	}
	        System.out.println("hello world");
	        System.err.println( helloWorldConfig.helloWorld() );
	    }
	 
	 
	 
}            