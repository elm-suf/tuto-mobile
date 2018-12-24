package com.elmsuf.tuto_final;
import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class PrefConfig {
    private SharedPreferences preferences;
    private Context context;

    public PrefConfig(Context context) {
        this.context = context;
        this.preferences = context.getSharedPreferences(context.getString(R.string.pref_file), Context.MODE_PRIVATE);
    }

    public void writeLoginStatus(boolean status) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putBoolean(context.getString(R.string.pref_login_status), status).apply();
    }

    public boolean readLoginStatus() {
        return preferences.getBoolean(context.getString(R.string.pref_login_status), false);
    }

    public void writeName(String name) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(context.getString(R.string.pref_username), name).apply();
    }

    public String readLoginName() {
        return preferences.getString(context.getString(R.string.pref_username), "none");
    }

    public void displayToast(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}

