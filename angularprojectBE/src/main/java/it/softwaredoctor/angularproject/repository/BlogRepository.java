/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-15 14:03:40
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-30 10:48:46
 * @FilePath: angularprojectBE/src/main/java/it/softwaredoctor/angularproject/repository/BlogRepository.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.angularproject.repository;

import it.softwaredoctor.angularproject.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Long> { 
     
     List<Blog> findByTagContainingIgnoreCase(String tag);
     
     Blog findByTitleArticle(String title);
}
