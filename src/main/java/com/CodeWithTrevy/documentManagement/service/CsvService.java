package com.CodeWithTrevy.documentManagement.service;

import com.CodeWithTrevy.documentManagement.dao.UserModelRepository;
import com.CodeWithTrevy.documentManagement.model.UserModel;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CsvService {

    @Autowired
    private UserModelRepository userModelRepository;

    @Transactional
    public void importUsersFromCsv(String filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVReader csvReader = new CSVReaderBuilder(reader)
                     .withSkipLines(1)
                     .build()) { // Skip header row

            String[] nextRecord;
            List<UserModel> userModels = new ArrayList<>();
            while ((nextRecord = csvReader.readNext()) != null) {
                UserModel userModel = new UserModel();
                userModel.setFirstname(nextRecord[1]);
                userModel.setLastname(nextRecord[3]);
                userModel.setPassword(nextRecord[4]);
                userModel.setUsername(nextRecord[5]);
                userModel.setCreatedat(LocalDateTime.now());

                userModels.add(userModel);
            }
            userModelRepository.saveAll(userModels);
        }
    }
}