package com.elmsuf.tuto_final.view.choose_teacher.adapter;


import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.elmsuf.tuto_final.databinding.TeacherBinding;
import com.elmsuf.tuto_final.repository.model.Teacher;
import com.elmsuf.tuto_final.view.choose_teacher.ChoiceHandler;
import com.elmsuf.tuto_final.view.choose_teacher.ChooseSlotActivity;

import java.util.List;

import es.dmoral.toasty.Toasty;

public class TeacherCustomAdapter extends RecyclerView.Adapter<TeacherCustomAdapter.CustomView> {

    public static final String EXTRA_TEACHER = "EXTRA_TEACHER";
    List<Teacher> list;
    private LayoutInflater inflater;
    private Context context;

    public TeacherCustomAdapter(Context context, List<Teacher> list) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }

        TeacherBinding binding = TeacherBinding.inflate(inflater, viewGroup, false);
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_list_item, viewGroup, false);
        return new CustomView(binding);
//        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int i) {
//        holder.txv_course_name_list_item.setText(course.getTitle());
        final Teacher item = list.get(i);
        holder.bind(item);

        final TeacherBinding binding = holder.getBinding();
        binding.setHandler(new ChoiceHandler() {
            @Override
            public void onItemSelected() {
                Log.d("mTAG", "onCourseItemClicked: ");
                Toasty.success(context,"List item clicked").show();
                Intent intent = new Intent(context, ChooseSlotActivity.class);
                intent.putExtra(EXTRA_TEACHER, item.getUsername());
                context.startActivity(intent);
            }
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

        private TeacherBinding binding;
        TextView txv_course_name_list_item;

        public CustomView(@NonNull TeacherBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Teacher model) {
            this.binding.setModel(model);
        }

        public TeacherBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            Teacher item = list.get(this.getAdapterPosition());
            Log.d("mTAG", "onItemClicked() called with: teacher = [" + item.getUsername() + "]");
//            Intent intent = new Intent(v.getContext(), ChooseTeacherActivity.class);
//            intent.putExtra(EXTRA_COURSE, course.getTitle());
//            context.startActivity(intent);
        }
    }
}

