package com.elmsuf.tuto_final.viewmodel.searchVM;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;

import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;

import com.elmsuf.tuto_final.repository.CourseRepository;
import com.elmsuf.tuto_final.repository.model.Course;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {
//    private ResultLoginCallbacks callbacks;
    private MutableLiveData<List<Course>> liveData;
    private CourseRepository repository;


    public SearchViewModel(@NonNull Application application) {
        super(application);
        repository = new CourseRepository(application);
    }

    public void init(){
        liveData = repository.getAll();
    }
    public MutableLiveData<List<Course>> getAll(){
        return liveData;
    }
}
