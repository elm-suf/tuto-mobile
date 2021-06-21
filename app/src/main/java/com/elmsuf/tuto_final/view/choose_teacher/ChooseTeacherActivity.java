package com.elmsuf.tuto_final.view.choose_teacher;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.elmsuf.tuto_final.R;
import com.elmsuf.tuto_final.repository.model.Teacher;
import com.elmsuf.tuto_final.view.choose_teacher.adapter.TeacherCustomAdapter;
import com.elmsuf.tuto_final.viewmodel.reservation.ReservationViewModel;

import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ChooseTeacherActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ReservationViewModel viewModel;
    TeacherCustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_make_reservation);
        ViewDataBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_make_reservation);

        recyclerView = findViewById(R.id.recycler_teachers);
        this.viewModel = ViewModelProviders.of(this).get(ReservationViewModel.class);
        viewModel.init();
        viewModel.getAll().observe(
                this, new Observer<List<Teacher>>() {
                    @Override
                    public void onChanged(@Nullable List<Teacher> courses) {
                        customAdapter = new TeacherCustomAdapter(getApplication(), courses);
                        recyclerView.setLayoutManager(new LinearLayoutManager(getApplication()));
                        recyclerView.setAdapter(customAdapter);
                    }
                }
        );
    }
}
