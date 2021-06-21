package com.elmsuf.tuto_final.repository.model;

import android.databinding.BaseObservable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Reservation extends BaseObservable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("studente")
    @Expose
    private String student;
    @SerializedName("stato")
    @Expose
    private String status;
    @SerializedName("docente")
    @Expose
    private String teacher;
    @SerializedName("corso")
    @Expose
    private String course;
    @SerializedName("slot")
    @Expose
    private String slot;
    @SerializedName("data")
    @Expose
    private String date;

    public Reservation() {
    }

    public Reservation(String id, String student, String status, String teacher, String course, String slot, String date) {
        this.id = id;
        this.student = student;
        this.status = status;
        this.teacher = teacher;
        this.course = course;
        this.slot = slot;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("studente", student).append("stato", status).append("docente", teacher).append("corso", course).append("slot", slot).append("data", date).toString();
    }

}
