package com.elmsuf.tuto_final.repository.dao;


import com.elmsuf.tuto_final.repository.model.Course;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CourseDao {

    @GET("courses")
    Call<List<Course>> getAllCourses();
}
