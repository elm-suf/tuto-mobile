package com.elmsuf.tuto_final.viewmodel.login;

import android.arch.lifecycle.ViewModel;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.elmsuf.tuto_final.repository.dao.ApiClient;
import com.elmsuf.tuto_final.repository.dao.StudentDao;
import com.elmsuf.tuto_final.repository.model.Student;
import com.elmsuf.tuto_final.view.login.ResultLoginCallbacks;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.elmsuf.tuto_final.view.login.LoginActivity.TAG;


public class LoginViewModel extends ViewModel {
    private ResultLoginCallbacks callbacks;
    private Student student;

    public LoginViewModel(ResultLoginCallbacks callbacks) {
        this.callbacks = callbacks;
        this.student = new Student();
    }

    /**
     * This method is used observe changes on the EditText
     * @return TextWatcher
     */
    public TextWatcher getUsernameTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                student.setUsername(s.toString());
            }
        };
    }
    public TextWatcher getPasswordTextWatcher(){
        return new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                student.setPassword(s.toString());
            }
        };
    }

    public void onLoginClicked(View view){
        StudentDao dao = ApiClient.getInstance().create(StudentDao.class);

        Call<Student> call = dao.submitLogin(student.username, student.password);
        Log.d(TAG, "submitLogin() called with: [" + student.username +"; " + student.password+"]");
        System.out.println(call.request());
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                Log.d(TAG, "onResponse() called with: call = \n[" + call.request().toString() + "],\n" +
                        "response = [" + response.body() + "]");
                if (response.isSuccessful()){
                    callbacks.onSuccess(response.body().username);
                }else{
                    callbacks.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.d(TAG, "onFailure() called with: call = [" + call.request() + "], t = [" + t.getMessage() + "]");
                callbacks.onError(t.getMessage());
            }
        });

    }
}
