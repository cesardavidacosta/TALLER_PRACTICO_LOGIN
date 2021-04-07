package com.example.taller_practico_formulario;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String surname;
    private int age;
    private int salary;
    private String cargo;
    private String email;

    public Person(String surname, int age, int salary, String cargo, String email, String name) {
        this.surname = surname;
        this.age = age;
        this.salary = salary;
        this.cargo = cargo;
        this.email = email;
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
