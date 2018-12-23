package com.elmsuf.tuto_final.repository.model;

import android.databinding.BaseObservable;
import com.google.gson.annotations.SerializedName;

public class Student extends BaseObservable {

    @SerializedName("id")
    public int id;
    @SerializedName("nome")
    public String firstName;
    @SerializedName("cognome")
    public String lastName;
    @SerializedName("username")
    public String username;
    @SerializedName("password")
    public String password;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student(String firstName, String lastName, String username, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
    }

    public Student() {
    }
}
