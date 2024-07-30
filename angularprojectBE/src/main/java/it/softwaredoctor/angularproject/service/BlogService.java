/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-24 12:40:27
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-30 10:55:26
 * @FilePath: angularprojectBE/src/main/java/it/softwaredoctor/angularproject/service/BlogService.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.angularproject.service;

import it.softwaredoctor.angularproject.model.Blog;
import it.softwaredoctor.angularproject.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Service
public class BlogService {
    
    private final BlogRepository blogRepository;

    public void createArticle(Blog blog) {
        String tag = blog.getTag();
        if (tag != null && tag.contains(" ")) {
            tag = tag.replaceAll(" ", "-");
            blog.setTag(tag);
        }
        blogRepository.save(blog);
    }


    public void updateArticle(Long id, Blog blog) {
        Blog blog1 = blogRepository.findById(id).get();
        blog1.setTitleArticle(blog.getTitleArticle());
        blog1.setTag(blog.getTag());
        blog1.setTextArticle(blog.getTextArticle());
        blogRepository.save(blog1);
    }

    public void deleteArticle(Long id) {
        blogRepository.deleteById(id);
    }
    
    public List<Blog> getArticles() {
        return blogRepository.findAll();
    }
    

public List<Blog> getArticlesByTag(String tag) {
    String normalizedTag = tag.toLowerCase().trim()
            .replace("-", " ")
            .replace(",", " "); 
    
    String[] terms = normalizedTag.split("\\s+");
    System.out.println("terms___" + Arrays.toString(terms));
    Set<Blog> resultSet = new HashSet<>();
    
    for (String term : terms) {
        System.out.println("term___" + term);
        if (!term.isEmpty()) {
            resultSet.addAll(blogRepository.findByTagContainingIgnoreCase(term));
        }
    }
    return new ArrayList<>(resultSet);
}
    
    public Blog getArticleById(String titleArticle) {
        return blogRepository.findByTitleArticle(titleArticle);
    }
    
    public Blog getArticleByTitle(String titleArticle) {
        return blogRepository.findByTitleArticle(titleArticle);
    }
}
