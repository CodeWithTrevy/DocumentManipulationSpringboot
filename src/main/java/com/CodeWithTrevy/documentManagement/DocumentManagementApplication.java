package com.CodeWithTrevy.documentManagement;

import com.CodeWithTrevy.documentManagement.service.CsvWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DocumentManagementApplication implements CommandLineRunner {

    @Autowired
    private final CsvWriterService csvWriterService;

    public DocumentManagementApplication(CsvWriterService csvWriterService) {
        this.csvWriterService = csvWriterService;
    }

    public static void main(String[] args) {
        SpringApplication.run(DocumentManagementApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        csvWriterService.writeUsersToCsv();
        System.out.println("✅ CSV file written successfully!");
    }
}
