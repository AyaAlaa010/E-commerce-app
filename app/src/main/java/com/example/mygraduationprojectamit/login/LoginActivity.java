package com.example.mygraduationprojectamit.login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.databinding.ActivityLoginBinding;
import com.example.mygraduationprojectamit.main.MainActivity;
import com.example.mygraduationprojectamit.network.RetrofitClient;
import com.example.mygraduationprojectamit.register.RegisterActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.adapter.rxjava.HttpException;
import rx.Observer;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.internal.util.ActionSubscriber;
import rx.internal.util.ObserverSubscriber;
import rx.schedulers.Schedulers;
import rx.subjects.Subject;


public class LoginActivity extends AppCompatActivity {
    ActivityLoginBinding binding;
    static String myToken;
    private static final String TAG = "LoginActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);
        getSupportActionBar().hide();

    }

    public void login(View view) {

        String email = binding.etLoginEmail.getText().toString().trim();
        String password = binding.etLoginPassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(LoginActivity.this, "please fill all data", Toast.LENGTH_LONG).show();
            return;

        }
       //#########################################################################

                        //#################################################################################################

                        LoginRequest loginRequest = new LoginRequest(email, password);
        RetrofitClient.getApi().login(loginRequest).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<LoginResponse>() {
                    @Override
                    public void onSuccess(LoginResponse value) {
                        myToken = value.getToken();
                        SharedPreferences preferences = getSharedPreferences("products", Context.MODE_PRIVATE);
                        preferences.edit().putString("accessToken", myToken).apply();
                        myToken = getSharedPreferences("products", MODE_PRIVATE).getString("accessToken", "");
                        String token = "Bearer " + myToken;
                        Log.i(TAG, "onCreate:my token =  " + token);
                        Log.i(TAG, "onResponse: xxxxxxxxxxxxx" + myToken);
                        if (myToken.isEmpty()) {

                            Toast.makeText(LoginActivity.this, "token empty", Toast.LENGTH_LONG).show();
                        }
                        Toast.makeText(LoginActivity.this, "sucess", Toast.LENGTH_LONG).show();

                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onError(Throwable error) {

                        Log.i(TAG, "onError: " + error.getLocalizedMessage());
                        Toast.makeText(LoginActivity.this,error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
                    }
                });
    }

//   ######################################################################


    //        RetrofitClient.getApi().login(loginRequest).enqueue(new Callback<LoginResponse>() {
//            @Override
//            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
//                if (response.code() == 200) {
//                    myToken=response.body().getToken();
//                    SharedPreferences preferences=getSharedPreferences("products", Context.MODE_PRIVATE);
//                    preferences.edit().putString("accessToken",myToken).apply();
//                    myToken = getSharedPreferences("products", MODE_PRIVATE).getString("accessToken", "");
//                    String token = "Bearer " + myToken;
//                    Log.i(TAG, "onCreate:my token =  "+token);
//                    Log.i(TAG, "onResponse: xxxxxxxxxxxxx"+myToken);
//                        if(myToken.isEmpty()){
//
//                            Toast.makeText(LoginActivity.this,"token empty",Toast.LENGTH_LONG).show();
//
//                        }
//
//                    Toast.makeText(LoginActivity.this, "sucess", Toast.LENGTH_LONG).show();
//
//                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                    finish();
//                }
//            }
//            @Override
//            public void onFailure(Call<LoginResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(LoginActivity.this, errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });}


    public void signUp(View view) {
        startActivity(new Intent(LoginActivity.this, RegisterActivity.class));

    }
}