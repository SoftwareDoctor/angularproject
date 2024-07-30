/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-24 17:10:16
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-30 10:55:26
 * @FilePath: angularprojectBE/src/main/java/it/softwaredoctor/angularproject/repository/ResumeRepository.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.angularproject.repository;

import it.softwaredoctor.angularproject.model.Resume;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResumeRepository extends JpaRepository<Resume, Long> {
    
    Resume findByTitle(String title);

}
