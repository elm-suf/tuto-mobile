package com.elmsuf.tuto_final.view.login;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.elmsuf.tuto_final.R;
import com.elmsuf.tuto_final.databinding.ActivityLoginBinding;
import com.elmsuf.tuto_final.view.home.MainActivity;
import com.elmsuf.tuto_final.view.search.SearchFragment;
import com.elmsuf.tuto_final.viewmodel.login.LoginViewModel;
import com.elmsuf.tuto_final.viewmodel.login.LoginViewModelFactory;

import es.dmoral.toasty.Toasty;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements ResultLoginCallbacks {
    public static final String TAG = "mTAG";

    private AutoCompleteTextView mEmailView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        binding.setViewModel(ViewModelProviders
                .of(this, new LoginViewModelFactory(this))
                .get(LoginViewModel.class));
    }

    @Override
    public void onSuccess(String username) {
        Toasty.success(this, String.format("Welcome %s", username)).show();
        //todo add shared preferences
//        MainActivity.prefConfig.displayToast("Login Success");
//        MainActivity.prefConfig.writeLoginStatus(true);
//        MainActivity.prefConfig.writeName(username);

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Intent.EXTRA_USER, username);
        startActivity(intent);
    }

    @Override
    public void onError(String cause) {
        Toasty.error(this, cause).show();
    }
}