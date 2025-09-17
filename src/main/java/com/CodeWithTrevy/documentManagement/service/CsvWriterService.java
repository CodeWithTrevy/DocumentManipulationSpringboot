package com.CodeWithTrevy.documentManagement.service;

import com.CodeWithTrevy.documentManagement.model.Users;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Service
public class CsvWriterService {
    private static final String PATH = "./users.csv";

    public void writeUsersToCsv() throws IOException,
            CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {

        List<Users> users = Arrays.asList(
                new Users(1L, "Alice", "Akello", "alice123", "alyax", LocalDateTime.now()),
                new Users(2L, "Alex", "Odong", "blice123", "blyax", LocalDateTime.now()),
                new Users(3L, "Nancy", "Lanna", "clice123", "clyax", LocalDateTime.now()),
                new Users(4L, "Abel", "Fima", "dlice123", "dlyax", LocalDateTime.now()),
                new Users(5L, "Anabel", "Afama", "elice123", "elyax", LocalDateTime.now()),
                new Users(6L, "Zana", "Akna", "flice123", "flyax", LocalDateTime.now()),
                new Users(7L, "Aoum", "Akulo", "glice123", "glyax", LocalDateTime.now()),
                new Users(8L, "Alcer", "Akallo", "hlice123", "hlyax", LocalDateTime.now()),
                new Users(9L, "Alaner", "Akelle", "ilice123", "ilyax", LocalDateTime.now())
        );

        try (Writer writer = new FileWriter(PATH)) {
            StatefulBeanToCsv<Users> beanToCsv = new StatefulBeanToCsvBuilder<Users>(writer).build();
            beanToCsv.write(users);
        }
    }
}
