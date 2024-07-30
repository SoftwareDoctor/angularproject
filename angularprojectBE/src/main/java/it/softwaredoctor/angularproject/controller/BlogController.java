/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-24 12:43:06
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-29 09:50:17
 * @FilePath: angularprojectBE/src/main/java/it/softwaredoctor/angularproject/controller/BlogController.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.angularproject.controller;

import it.softwaredoctor.angularproject.model.Blog;
import it.softwaredoctor.angularproject.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("api/v1/blog")
@RequiredArgsConstructor
@RestController
public class BlogController {
    
    private final BlogService blogService;

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/all")
    public ResponseEntity<List<Blog>> getArticles() {
        List<Blog> articles = blogService.getArticles(); 
        if(articles.isEmpty()) 
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
     
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/all/bytag/{tag}")
    public ResponseEntity<List<Blog>> getArticlesByTag(@PathVariable("tag") String tag) {
        List<Blog> articles = blogService.getArticlesByTag(tag);
        return ResponseEntity.ok().body(articles);
    }

    @CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
    @GetMapping("/{title}")
    public ResponseEntity<Blog> getArticleByTitle(@PathVariable("title") String title) {
        Blog article = blogService.getArticleByTitle(title);
        if (article == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return new ResponseEntity<>(article, HttpStatus.OK);
    }

   
    @PostMapping("/new")
    public ResponseEntity<Void> createArticle(@RequestBody Blog blog) {
        blogService.createArticle(blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

  
    @PostMapping("/{id}")
    public ResponseEntity<Void> updateArticle(@PathVariable Long id, @RequestBody Blog blog) {
        blogService.updateArticle(id, blog);
        return new ResponseEntity<>(HttpStatus.OK);
    }

   
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        blogService.deleteArticle(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
    
    
    


    