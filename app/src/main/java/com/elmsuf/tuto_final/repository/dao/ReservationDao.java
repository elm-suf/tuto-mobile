package com.elmsuf.tuto_final.repository.dao;


import com.elmsuf.tuto_final.repository.model.Slot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ReservationDao {
    @GET("teachers/{username}/{date}")
    Call<List<Slot>> getAvailableSlots(@Path("username") String docente, @Path("date") String date);

//    //todo left here
//    @PUT("students/reservation")
//    void makeReservation(@Query("username") String username,
//                         @Query("docente") String teacher,
//                         @Query("slot") int slot,
//                         @Query("stato") String stato,
//    $slot = $request->getParam('slot');
//    $stato = $request->getParam('stato');
//    $corso = $request->getParam('corso');
//    $data = $request->getParam('data');
//    $insegnamento = $request->getParam('insegnamento');

//    @PUT("students/reservation")
}
