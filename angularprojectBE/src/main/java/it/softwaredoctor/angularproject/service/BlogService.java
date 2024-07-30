/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-24 12:40:27
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-29 13:49:56
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
    
//    public List<Blog> getArticlesByTag(String tag) {
//        return blogRepository.findByTagContainingIgnoreCase(tag);
//    }
public List<Blog> getArticlesByTag(String tag) {
    // Normalizza il tag di ricerca
    String normalizedTag = tag.toLowerCase().trim()
            .replace("-", " ")
            .replace(",", " "); // Sostituisci virgole con spazi

    // Dividi il tag in termini, considerando anche spazi multipli
    String[] terms = normalizedTag.split("\\s+");
    System.out.println("terms___" + Arrays.toString(terms));
    // Usa un Set per evitare duplicati
    Set<Blog> resultSet = new HashSet<>();

    // Trova articoli per ciascun termine e aggiungi al Set
    for (String term : terms) {
        System.out.println("term___" + term);
        if (!term.isEmpty()) {
            resultSet.addAll(blogRepository.findByTagContainingIgnoreCase(term));
        }
    }

    // Converte il Set in una lista
    return new ArrayList<>(resultSet);
}
    
    public Blog getArticleById(String titleArticle) {
        return blogRepository.findByTitleArticle(titleArticle);
    }
    
    public Blog getArticleByTitle(String titleArticle) {
        return blogRepository.findByTitleArticle(titleArticle);
    }
    
}
