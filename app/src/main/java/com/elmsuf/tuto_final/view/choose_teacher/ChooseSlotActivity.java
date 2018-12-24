package com.elmsuf.tuto_final.view.choose_teacher;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.icu.util.Calendar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
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
    String teacher;
    String date;
    private DatePickerDialog.OnDateSetListener mDateSetListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_slot);

        Intent intent = getIntent();
        teacher = intent.getStringExtra(EXTRA_TEACHER);
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

        date = DateFormat.format("yyyy-MM-dd", new Date()).toString();
        showSlots(teacher, date);

        searchDate.setOnClickListener(this::displayDateModal);
        mDateSetListener = this::onDateSet;

        btn_1.setOnClickListener(v -> effettuaPrenotazione(1));
        btn_2.setOnClickListener(v -> effettuaPrenotazione(2));
        btn_3.setOnClickListener(v -> effettuaPrenotazione(3));
        btn_4.setOnClickListener(v -> effettuaPrenotazione(4));
    }

    private void effettuaPrenotazione(int i) {
        //todo hardcoded USERNAME(get from Shared pref) & COURSE(get from intent)
        Call<Void> voidCall = dao.makeReservation("username", teacher, i, "attiva", "corso", date);

        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if (response.isSuccessful()) {
                    Toasty.success(getApplicationContext(), response.message()).show();
                    showSlots(teacher, date);
                } else {
                    Toasty.info(getApplication(), response.message()).show();
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                Toasty.error(getApplication(), t.getMessage()).show();
            }
        });


    }

    private void showSlots(String teacher, String date) {
        final String data = date;
        Call<List<Slot>> callAvailableSlots = dao.getAvailableSlots(teacher, date);
        callAvailableSlots.enqueue(new Callback<List<Slot>>() {
            @Override
            public void onResponse(Call<List<Slot>> call, Response<List<Slot>> response) {
                Log.d("mTAG", "onResponse() called [" + call.request() + "], response = [" + response.body() + "]");
                txv_response.setText(String.format("Available slots in date :%s", data));

                List<Slot> body = response.body();
                Toasty.info(getApplication(), response.message()).show();
                btn_1.setBackgroundColor(Color.GREEN);
                btn_2.setBackgroundColor(Color.GREEN);
                btn_3.setBackgroundColor(Color.GREEN);
                btn_4.setBackgroundColor(Color.GREEN);
                btn_1.setClickable(true);
                btn_2.setClickable(true);
                btn_3.setClickable(true);
                btn_4.setClickable(true);
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

    private void displayDateModal(View v) {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog dialog = new DatePickerDialog(
                v.getContext(),
                mDateSetListener,
                year, month, day);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.show();
    }

    private void onDateSet(DatePicker view1, int year, int month, int day) {
        month = month + 1;
        Log.d("mTAG", "onDateSet: mm/dd/yyy: " + month + "/" + day + "/" + year);

        date = year + "-" + month + "-" + day;
        searchDate.setText(date);
        showSlots(teacher, date);
    }
}
