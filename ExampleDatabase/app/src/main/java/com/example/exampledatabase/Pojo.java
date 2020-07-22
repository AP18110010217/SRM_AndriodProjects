package com.example.exampledatabase;

public class Pojo {
    String name,roll,number;
    public Pojo(String name, String roll, String number) {
        this.name=name;
        this.roll=roll;
        this.number=number;
    }

    public String getName() {
        return name;
    }

    public String getRoll() {
        return roll;
    }

    public String getNumber() {
        return number;
    }
    public Pojo(){

    }
}