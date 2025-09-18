package com.CodeWithTrevy.documentManagement.model;


import com.opencsv.bean.CsvBindByName;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity(name ="users")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @CsvBindByName(column = "ID")
    private Long id;

    @CsvBindByName(column = "FIRSTNAME")
    private String firstname;
    @CsvBindByName(column = "LASTNAME")
    private String lastname;
    @CsvBindByName(column = "PASSWORD")
    private String password;
    @CsvBindByName(column = "USERNAME")
    private String username;
    @CsvBindByName(column = "CREATEDAT")
    private LocalDateTime createdat;

 public UserModel(){

 }




    public UserModel(Long id, String firstname, String lastname, String password, String username, LocalDateTime createdat) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.username = username;
        this.createdat = createdat;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", fisrtname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", createdat=" + createdat +
                '}';
    }



}
