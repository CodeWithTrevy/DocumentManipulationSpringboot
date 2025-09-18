package com.CodeWithTrevy.documentManagement.controller;

import com.CodeWithTrevy.documentManagement.dao.UserModelRepository;
import com.CodeWithTrevy.documentManagement.model.UserModel;
import com.CodeWithTrevy.documentManagement.service.CsvService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@RestController
@RequestMapping("/api/userModel")
public class UserModelController {

    @Autowired
    private CsvService csvService;

    @Autowired
    private UserModelRepository userModelRepository;

    @PostMapping("/upload-csv")
    public ResponseEntity<String> uploadCsv(@RequestParam("file") MultipartFile file) {
        try {
            Path tempFile = Paths.get(System.getProperty("java.io.tmpdir"))
                    .resolve(file.getOriginalFilename());
            Files.copy(file.getInputStream(), tempFile);

            csvService.importUsersFromCsv(tempFile.toString());
            Files.delete(tempFile);

            return ResponseEntity.ok("CSV data imported into database successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to import CSV: " + e.getMessage());
        }
    }


    @GetMapping("/users")
    public List<UserModel> getAllProducts() {
        return userModelRepository.findAll();
    }
}