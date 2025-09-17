package com.CodeWithTrevy.documentManagement.model;


import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;

import java.time.LocalDateTime;

public class Users {
    @CsvBindByName(column = "ID")
    private long id;

    @CsvBindByName(column = "firstname")
    private String firstName;

    @CsvBindByName(column = "lastname")
    private String lastName;

    @CsvBindByName(column = "password")
    private String password;

    @CsvBindByName(column = "username")
    private String username;

    @CsvBindByName(column ="createdAt")
    @CsvDate("yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;

    public Users() {

    }



    public Users(long id, String firstName, String lastName, String password, String username, LocalDateTime createdAt) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.username = username;
        this.createdAt = createdAt;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }








}
