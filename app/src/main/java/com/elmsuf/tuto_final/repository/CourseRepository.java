package com.elmsuf.tuto_final.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.elmsuf.tuto_final.repository.dao.ApiClient;
import com.elmsuf.tuto_final.repository.dao.CourseDao;
import com.elmsuf.tuto_final.repository.model.Course;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CourseRepository {
    private CourseDao webservice;
    private Application application;

    //todo should i put application in the constructor? why?? - ill figure it out
    public CourseRepository(Application application) {
        webservice = ApiClient.getInstance().create(CourseDao.class);
        this.application = application;
    }

    public MutableLiveData<List<Course>> getAll() {
        final MutableLiveData<List<Course>> data = new MutableLiveData<>();

        webservice.getAllCourses().enqueue(new Callback<List<Course>>() {
            @Override
            public void onResponse(Call<List<Course>> call, Response<List<Course>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Toasty.success(application, response.message()).show();
                } else {
                    Toasty.error(application, response.message()).show();
                }
            }

            @Override
            public void onFailure(Call<List<Course>> call, Throwable t) {
                Log.d("m_TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                Toasty.error(application,t.getMessage()).show();
            }
        });
        return data;
    }
}