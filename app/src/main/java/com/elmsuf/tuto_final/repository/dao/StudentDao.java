package com.elmsuf.tuto_final.repository.dao;


import com.elmsuf.tuto_final.repository.model.Student;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface StudentDao {
    @GET("students")
    Call<List<Student>> getAllStudents();

    @GET("login")
    Call<Student> submitLogin(@Query("username") String username,
                              @Query("password") String password);
}
