package com.elmsuf.tuto_final.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.elmsuf.tuto_final.repository.dao.ApiClient;
import com.elmsuf.tuto_final.repository.dao.TeacherDao;
import com.elmsuf.tuto_final.repository.model.Teacher;

import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TeacherRepository {
    private TeacherDao webservice;
    private Application application;

    //todo should i put application in the constructor? why?? - ill figure it out
    public TeacherRepository(Application application) {
        webservice = ApiClient.getInstance().create(TeacherDao.class);
        this.application = application;
    }

    public MutableLiveData<List<Teacher>> getAll() {
        final MutableLiveData<List<Teacher>> data = new MutableLiveData<>();

        webservice.getAllTeachers().enqueue(new Callback<List<Teacher>>() {
            @Override
            public void onResponse(Call<List<Teacher>> call, Response<List<Teacher>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                    Toasty.success(application, response.message()).show();
                } else {
                    Toasty.info(application, response.message()).show();
                }
            }

            @Override
            public void onFailure(Call<List<Teacher>> call, Throwable t) {
                Log.d("m_TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
                Toasty.error(application,t.getMessage()).show();
            }
        });
        return data;
    }
}
