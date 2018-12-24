package com.elmsuf.tuto_final.view.reservations;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elmsuf.tuto_final.PrefConfig;
import com.elmsuf.tuto_final.R;
import com.elmsuf.tuto_final.repository.model.Reservation;
import com.elmsuf.tuto_final.view.reservations.viewmodel.ReservationListViewModel;
import com.elmsuf.tuto_final.view.reservations.adapter.ReservationCustomAdapter;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class ReservationsFragment extends Fragment {
    public static ReservationListViewModel viewModel;
    private ReservationCustomAdapter customAdapter;
    Context context;

    RecyclerView recyclerView;
    PrefConfig prefConfig;
    public ReservationsFragment() {
        // Required empty public constructor
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        context = getContext();
        Toasty.info(context,"onActivityCreated()").show();
        prefConfig = new PrefConfig(context);
        recyclerView = getView().findViewById(R.id.recycler_reservations);
        viewModel = ViewModelProviders.of(this)
                .get(ReservationListViewModel.class);

        viewModel.init(prefConfig.readLoginName());

        viewModel.getAll().observe(
                this, new Observer<List<Reservation>>(){
                    @Override
                    public void onChanged(@Nullable List<Reservation> reservations) {
                        customAdapter = new ReservationCustomAdapter(getActivity(), reservations);
                        recyclerView.setLayoutManager(new LinearLayoutManager(context));
                        recyclerView.setAdapter(customAdapter);
                    }
                }
        );
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_reservations, container, false);
    }


    private OnFragmentInteractionListener mListener;

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
