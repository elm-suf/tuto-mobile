package com.elmsuf.tuto_final.view.reservations.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.support.annotation.NonNull;
import android.util.Log;

import com.elmsuf.tuto_final.repository.ReservationRepository;
import com.elmsuf.tuto_final.repository.model.Reservation;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class ReservationListViewModel extends AndroidViewModel {
    private final ReservationRepository repository;
    private MutableLiveData<List<Reservation>> liveData;


    public ReservationListViewModel(@NonNull Application application) {
        super(application);
        repository = new ReservationRepository(application);
    }

    public void init(String username){
        Log.d("mTAG", "init() called with: username = [" + username + "]");
        liveData = repository.getAll(username);
    }

    public MutableLiveData<List<Reservation>> getAll() {
        Log.d("mTAG", "getAll() called");
        return liveData;
    }

}
