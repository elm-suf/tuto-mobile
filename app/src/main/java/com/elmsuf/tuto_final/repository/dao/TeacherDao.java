package com.elmsuf.tuto_final.repository.dao;


import com.elmsuf.tuto_final.repository.model.Slot;
import com.elmsuf.tuto_final.repository.model.Teacher;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TeacherDao {
        @GET("teachers")
    Call<List<Teacher>> getAllTeachers();

    @GET("teachers/teaching/{course}")
    Call<List<Teacher>> getTeachingSubject(@Path("course") String subject);

    ///api/teachers/{username}/{date}
    @GET("teachers/{username}/{date}")
    Call<List<Slot>> getNOTAvailableSlots(@Path("username") String username, @Path("date") String dateString);
}
