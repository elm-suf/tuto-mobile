package com.elmsuf.tuto_final.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.arch.lifecycle.ViewModelProviders;
import android.content.pm.PackageManager;
import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.elmsuf.tuto_final.R;
import com.elmsuf.tuto_final.databinding.ActivityLoginBinding;
import com.elmsuf.tuto_final.viewmodel.LoginViewModel;
import com.elmsuf.tuto_final.viewmodel.LoginViewModelFactory;

import java.util.ArrayList;
import java.util.List;

import es.dmoral.toasty.Toasty;

import static android.Manifest.permission.READ_CONTACTS;

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
    public void onSuccess(String message) {
        Toasty.success(this, message).show();
    }

    @Override
    public void onError(String cause) {
        Toasty.error(this, cause).show();
    }
}