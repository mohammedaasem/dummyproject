package com.aasem.inspire_info_soft.myschool;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.CustomView.EditText.EditText;
import com.aasem.inspire_info_soft.myschool.DataClasses.UserStudentTop;
import com.aasem.inspire_info_soft.myschool.DataClasses.VolleyResponse;
import com.aasem.inspire_info_soft.myschool.Utill.URL;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fxn.cue.Cue;
import com.fxn.cue.enums.Duration;
import com.fxn.cue.enums.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Login extends AppCompatActivity implements View.OnClickListener {

    EditText etName, etPassword;
    Button btnLogin;
    TextView tvSignup;
    String URL_LOGIN = URL.LOGIN;
    RequestQueue requestQueue;
    StringRequest stringRequest;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etName = (EditText) findViewById(R.id.et_name);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        tvSignup = (TextView) findViewById(R.id.tv_signup);
        progressDialog = new ProgressDialog(Login.this);
        btnLogin.setOnClickListener(this);
        tvSignup.setOnClickListener(this);
        if (SharedPrefManager.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                if (isNetworkAvailable()) {
                    if (validation())
                        login();
                } else {
                    Cue.init()
                            .with(Login.this)
                            .setGravity(Gravity.BOTTOM)
                            .setDuration(Duration.LONG)
                            .setMessage("Please check your internet connection and try again !")
                            .setType(Type.DANGER)
                            .show();
                }
                break;

            case R.id.tv_signup:
                openSignupActivity();
                break;
        }
    }

    public boolean validation() {
        String roll_number = etName.getText().toString();
        String password = etPassword.getText().toString();
        if (roll_number.length() > 0 && password.length() > 0) {
            return true;
        } else {
            Cue.init()
                    .with(Login.this)
                    .setGravity(Gravity.BOTTOM)
                    .setMessage("Please Fill All Details")
                    .setType(Type.DANGER)
                    .show();
        }
        return false;
    }

    private void openSignupActivity() {
        startActivity(new Intent(this, UserType.class));
    }

    private void login() {
        final String contactNumber = etName.getText().toString();
        final String password = etPassword.getText().toString();
        requestQueue = Volley.newRequestQueue(this);
        progressDialog.setMessage("Please Wait... ");
        progressDialog.show();
        stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        progressDialog.dismiss();
                        // Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        try {
                            if (response.contains("Password is wrong!")) {
                                Cue.init()
                                        .with(Login.this)
                                        .setGravity(Gravity.BOTTOM)
                                        .setDuration(Duration.LONG)
                                        .setMessage("Roll No. / Password is wrong!")
                                        .setType(Type.DANGER)
                                        .show();
                            } else {

                                GsonBuilder gsonBuilder = new GsonBuilder();
                                Gson gson = gsonBuilder.create();

                                JSONObject jsonObject = new JSONObject(response);
                                UserStudentTop response1 = gson.fromJson(jsonObject.getJSONObject("info").toString(), UserStudentTop.class);


                                SharedPrefManager sharedPrefManager = new SharedPrefManager(Login.this);

                                sharedPrefManager.userLogin(response1);

                                Intent intent = new Intent(Login.this, MainActivity.class);

                                intent.putExtra("user_data", response1);
                                startActivity(intent);
                                Cue.init()
                                        .with(Login.this)
                                        .setGravity(Gravity.BOTTOM)
                                        .setDuration(Duration.LONG)
                                        .setMessage("Welcome " + response1.getName())
                                        .setType(Type.PRIMARY)
                                        .show();
                                finish();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        progressDialog.dismiss();
                        Cue.init()
                                .with(Login.this)
                                .setGravity(Gravity.BOTTOM)
                                .setMessage("LOGIN Failed Please Try again")
                                .setType(Type.DANGER)
                                .show();
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("contact_no", contactNumber);
                params.put("password", password);
                return params;
            }
        };
        VolleySingleton.getInstance(this).addToRequestQueue(stringRequest);
    }

    public boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}

