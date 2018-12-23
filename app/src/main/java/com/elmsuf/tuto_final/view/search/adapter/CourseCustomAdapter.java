package com.elmsuf.tuto_final.view.search.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.elmsuf.tuto_final.databinding.CourseBinding;
import com.elmsuf.tuto_final.repository.model.Course;
import com.elmsuf.tuto_final.view.ChooseTeacherActivity;
import com.elmsuf.tuto_final.view.search.SearchFragment;

import java.util.List;

import static com.elmsuf.tuto_final.view.search.SearchFragment.EXTRA_COURSE;

public class CourseCustomAdapter extends RecyclerView.Adapter<CourseCustomAdapter.CustomView> {

    List<Course> listOfCourses;
    private LayoutInflater inflater;
    private Context context;

    public CourseCustomAdapter(Context context, List<Course> listOfCourses) {
        this.listOfCourses = listOfCourses;
        this.context = context;
    }

    @NonNull
    @Override
    public CustomView onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (inflater == null) {
            inflater = LayoutInflater.from(viewGroup.getContext());
        }
        CourseBinding courseBinding = CourseBinding.inflate(inflater, viewGroup, false);
//        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.course_list_item, viewGroup, false);
        return new CustomView(courseBinding);
//        return new CustomView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomView holder, int i) {
//        holder.txv_course_name_list_item.setText(course.getTitle());
        Course course = listOfCourses.get(i);
        holder.bind(course);
    }

    @Override
    public int getItemCount() {
        return listOfCourses.size();
    }

    public class CustomView extends RecyclerView.ViewHolder implements View.OnClickListener {

        private CourseBinding binding;
        TextView txv_course_name_list_item;

        public CustomView(@NonNull CourseBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Course model) {
            this.binding.setModel(model);
        }

        public CourseBinding getBinding() {
            return binding;
        }

        @Override
        public void onClick(View v) {
            Course course = listOfCourses.get(this.getAdapterPosition());
            Log.d("mTAG", "onItemClicked() called with: course = [" + course.getTitle() + "]");
            Intent intent = new Intent(v.getContext(), ChooseTeacherActivity.class);
            intent.putExtra(EXTRA_COURSE, course.getTitle());
            context.startActivity(intent);
        }
    }
}

