package com.elmsuf.tuto_final.repository.dao;


import com.elmsuf.tuto_final.repository.model.Slot;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReservationDao {
    @GET("teachers/{username}/{date}")
    Call<List<Slot>> getAvailableSlots(@Path("username") String docente, @Path("date") String date);


    /**
     *     $studente = $request->getParam('studente');
     *     $docente = $request->getParam('docente');
     *     $slot = $request->getParam('slot');
     *     $stato = $request->getParam('stato');
     *     $corso = $request->getParam('corso');
     *     $data = $request->getParam('data');
     * @param username $request->getParam('studente');
     * @param teacher $request->getParam('docente');
     * @param slot $request->getParam('slot');
     * @param status $request->getParam('stato');
     * @param course $request->getParam('corso');
     * @param data $request->getParam('data');
     */
    @PUT("students/reservation")
    Call<Void> makeReservation(@Query("studente") String username,
                         @Query("docente") String teacher,
                         @Query("slot") int slot,
                         @Query("stato") String status,
                         @Query("corso") String course,
                         @Query("data") String data);
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
