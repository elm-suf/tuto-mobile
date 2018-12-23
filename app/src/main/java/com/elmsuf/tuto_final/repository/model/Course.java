package com.elmsuf.tuto_final.repository.model;
import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Course extends BaseObservable {
    @SerializedName("titolo")
    @Expose
    private String title;
    @SerializedName("id")
    @Expose
    private int id;

    public Course(){}

    public Course(String title, int id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("title", title).toString();
    }
}