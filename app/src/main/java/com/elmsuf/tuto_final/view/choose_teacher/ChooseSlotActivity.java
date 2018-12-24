package com.elmsuf.tuto_final.view.choose_teacher;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;

import com.elmsuf.tuto_final.R;
import com.elmsuf.tuto_final.repository.ReservationRepository;
import com.elmsuf.tuto_final.repository.dao.ApiClient;
import com.elmsuf.tuto_final.repository.dao.ReservationDao;
import com.elmsuf.tuto_final.repository.model.Reservation;
import com.elmsuf.tuto_final.repository.model.Slot;

import java.util.Date;
import java.util.List;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.elmsuf.tuto_final.view.choose_teacher.adapter.TeacherCustomAdapter.EXTRA_TEACHER;

public class ChooseSlotActivity extends AppCompatActivity {

    ReservationDao dao;

    EditText searchDate;
    TextView txv_teacher;
    TextView txv_response;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_slot);

        Intent intent = getIntent();
        String teacher = intent.getStringExtra(EXTRA_TEACHER);
        searchDate = findViewById(R.id.search_date);
        txv_response = findViewById(R.id.txv_response);

        txv_teacher = findViewById(R.id.txv_slot_teacher);
        txv_teacher.setText(teacher);

        btn_1 = findViewById(R.id.btn_slot_1);
        btn_2 = findViewById(R.id.btn_slot_2);
        btn_3 = findViewById(R.id.btn_slot_3);
        btn_4 = findViewById(R.id.btn_slot_4);

//        ReservationRepository repository = new ReservationRepository(this.getApplication());
        dao = ApiClient.getInstance().create(ReservationDao.class);

        CharSequence date = DateFormat.format("yyyy-MM-dd", new Date());
        txv_response.setText(String.format("Available slots in date :%s", date));

        Call<List<Slot>> callAvailableSlots = dao.getAvailableSlots(teacher, date.toString());
        callAvailableSlots.enqueue(new Callback<List<Slot>>() {
            @Override
            public void onResponse(Call<List<Slot>> call, Response<List<Slot>> response) {
                Log.d("mTAG", "onResponse() called [" + call.request() + "], response = [" + response.body() + "]");
                List<Slot> body = response.body();
                Toasty.info(getApplication(),response.message()).show();
                for (Slot slot : body) {
                    String nSlot = slot.getSlot();
                    switch (nSlot) {
                        case "1":
                            btn_1.setBackgroundColor(Color.RED);
                            btn_1.setClickable(false);
                            break;
                        case "2":
                            btn_2.setBackgroundColor(Color.RED);
                            btn_2.setClickable(false);
                            break;
                        case "3":
                            btn_3.setBackgroundColor(Color.RED);
                            btn_3.setClickable(false);
                            break;
                        case "4":
                            btn_4.setBackgroundColor(Color.RED);
                            btn_4.setClickable(false);
                            break;
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Slot>> call, Throwable t) {
                Toasty.error(getApplication(), t.getMessage()).show();
            }
        });
    }
}
