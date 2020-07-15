package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class Pojo {
    private String name;
    @SerializedName("full_name")
    private String fullname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
}
