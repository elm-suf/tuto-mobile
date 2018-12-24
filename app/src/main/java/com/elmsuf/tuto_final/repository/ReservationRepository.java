package com.elmsuf.tuto_final.repository;

import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.elmsuf.tuto_final.repository.dao.ApiClient;
import com.elmsuf.tuto_final.repository.dao.ReservationDao;
import com.elmsuf.tuto_final.repository.dao.TeacherDao;
import com.elmsuf.tuto_final.repository.model.Teacher;

import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ReservationRepository {
    private ReservationDao webservice;
    private Application application;

    //todo should i put application in the constructor? why?? - ill figure it out
    public ReservationRepository(Application application) {
        webservice = ApiClient.getInstance().create(ReservationDao.class);
        this.application = application;
    }

    public void getAvailableSlots(String teacher, Date date, String s) {
    }

//    public MutableLiveData<List<Teacher>> getAll() {
//        final MutableLiveData<List<Teacher>> data = new MutableLiveData<>();
//
//        webservice.getAllTeachers().enqueue(new Callback<List<Teacher>>() {
//            @Override
//            public void onResponse(Call<List<Teacher>> call, Response<List<Teacher>> response) {
//                if (response.isSuccessful()) {
//                    data.setValue(response.body());
//                    Toasty.success(application, response.message()).show();
//                } else {
//                    Toasty.error(application, response.message()).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<Teacher>> call, Throwable t) {
//                Log.d("m_TAG", "onFailure() called with: call = [" + call + "], t = [" + t + "]");
//                Toasty.error(application,t.getMessage()).show();
//            }
//        });
//        return data;
//    }

}
