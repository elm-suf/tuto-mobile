package com.elmsuf.tuto_final.viewmodel.reservation;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.elmsuf.tuto_final.repository.TeacherRepository;
import com.elmsuf.tuto_final.repository.model.Teacher;

import java.util.List;

public class ReservationViewModel extends AndroidViewModel {
    //    private ResultLoginCallbacks callbacks;
    private MutableLiveData<List<Teacher>> liveData;
    private TeacherRepository repository;


    public ReservationViewModel(@NonNull Application application) {
        super(application);
        repository = new TeacherRepository(application);
    }

    public void init(){
        liveData = repository.getAll();
    }
    public MutableLiveData<List<Teacher>> getAll(){
        return liveData;
    }
}
