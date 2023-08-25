package com.aloysius.BeginnerBackendJava.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "UserList")
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String email;


    public Employee(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Employee() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }



}
