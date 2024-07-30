/**
 * @Author: SoftwareDoctor andrea_italiano87@yahoo.com
 * @Date: 2024-07-25 09:01:51
 * @LastEditors: SoftwareDoctor andrea_italiano87@yahoo.com
 * @LastEditTime: 2024-07-26 06:54:22
 * @FilePath: angularprojectBE/src/main/java/it/softwaredoctor/angularproject/controller/ResumeController.java
 * @Description: 这是默认设置, 可以在设置》工具》File Description中进行配置
 */
package it.softwaredoctor.angularproject.controller;

import it.softwaredoctor.angularproject.model.Resume;
import it.softwaredoctor.angularproject.service.ResumeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.SQLException;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class ResumeController {
    
    private final ResumeService resumeService;


    @GetMapping("/resume/")
    public ResponseEntity<byte[]> getCV(@RequestParam("title") String title) throws SQLException {
        byte[] fileBytes = resumeService.getCV(title);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData(title, title + ".pdf");
        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }


    @PostMapping("/resume/cv/")
    public ResponseEntity<Void> updateCV(@RequestParam ("title") String title, @RequestPart("file") MultipartFile cv) throws IOException {
        resumeService.updateCV(title, cv);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/resumenew/")
    public ResponseEntity<Void> createResume(
            @RequestParam ("title") String title,
            @RequestPart("file") MultipartFile cvFile) throws IOException {

        Resume resume = new Resume();
        resume.setTitle(title);
        resume.setCv(cvFile.getBytes());

        resumeService.createResume(resume);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
