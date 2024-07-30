/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-25 08:43:48
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-25 15:10:41
 * @FilePath: angularprojectBE/src/main/java/it/softwaredoctor/angularproject/service/ResumeService.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.angularproject.service;

import it.softwaredoctor.angularproject.model.Resume;
import it.softwaredoctor.angularproject.repository.ResumeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;

@RequiredArgsConstructor
@Service
public class ResumeService {
    
    private final ResumeRepository resumeRepository;
    
//    public byte[] getCV(String title) {
//        return resumeRepository.getCV(title);
//    }

    public byte[] getCV(String title) throws SQLException {
        Resume resume = resumeRepository.findByTitle(title);
        if (resume != null) {
//            Blob blob = resume.getCv()[0]; // Assume che ci sia solo un file
//            return blob.getBytes(1, (int) blob.length()); 
            return resume.getCv();
        }
        throw new RuntimeException("File not found");
    }
    
//    public void createResume(Resume resume, MultipartFile cvFile) throws IOException {
//        byte[] cv = convertFileToByteArray(cvFile);
//        resume.setCv(cv);
//        resumeRepository.save(resume);
//    }

    public void createResume(Resume resume) {
        resumeRepository.save(resume);
    }
    
    public byte[] convertFileToByteArray(MultipartFile cvFile) throws IOException {
        return cvFile.getBytes();
    }
    
    public void updateCV(String title, MultipartFile cvFile) throws IOException {
        Resume resume = resumeRepository.findByTitle(title);
        byte[] cv = convertFileToByteArray(cvFile);
        resume.setCv(cv);
        resumeRepository.save(resume);
    }
}
