/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.voting.models;

/**
 *
 * @author USER
 */
import java.io.Serializable;

public class Voter implements Serializable {

    private int id;
    private String name;
    private String surName;
    private String email;
    private String studentNumber;
    private String phoneNumber;
    private String password;

    public Voter() {}

    public Voter(String name, String surName, String email, String studentNumber, String phoneNumber, String password) {
        this.name = name;
        this.surName = surName;
        this.email = email;
        this.studentNumber = studentNumber;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getSurName() { return surName; }
    public void setSurName(String surName) { this.surName = surName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getStudentNumber() { return studentNumber; }
    public void setStudentNumber(String studentNumber) { this.studentNumber = studentNumber; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}