package com.elmsuf.tuto_final.view.reservations.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elmsuf.tuto_final.databinding.ReservationBinding;
import com.elmsuf.tuto_final.repository.model.Reservation;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class ReservationCustomAdapter extends RecyclerView.Adapter<ReservationCustomAdapter.CustomView> {

    List<Reservation> list;
    private LayoutInflater inflater;
    private Context context;

    public ReservationCustomAdapter(Context context, List<Reservation> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }

        ReservationBinding binding = ReservationBinding.inflate(inflater, viewGroup, false);
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_list_item, viewGroup, false);
        return new CustomView(binding);
//        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int i) {
//        holder.txv_course_name_list_item.setText(course.getTitle());
        final Reservation item = list.get(i);
        holder.bind(item);

        final ReservationBinding binding = holder.getBinding();
        binding.setHandler(() -> {
            Log.d("mTAG", "onCourseItemClicked: ");
            Toasty.success(context,"List item clicked").show();
        });
//            @Override
//            public void onCourseItemClicked() {
//                Intent intent = new Intent(context, ChooseTeacherActivity.class);
//                intent.putExtra(EXTRA_COURSE, course.getTitle());
//                context.startActivity(intent);
//            }
//        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CustomView extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ReservationBinding binding;
        TextView txv_course_name_list_item;

        public CustomView(@NonNull ReservationBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Reservation model) {
            this.binding.setModel(model);
        }

        public ReservationBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            Reservation item = list.get(this.getAdapterPosition());
            Log.d("mTAG", "onItemClicked() called with: id = [" + item.getId() + "]");
//            Intent intent = new Intent(v.getContext(), ChooseTeacherActivity.class);
//            intent.putExtra(EXTRA_COURSE, course.getTitle());
//            context.startActivity(intent);
        }
    }
}

