 package com.example.mygraduationprojectamit.register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.databinding.ActivityRegisterBinding;
import com.example.mygraduationprojectamit.login.LoginActivity;
import com.example.mygraduationprojectamit.network.RetrofitClient;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


 public class RegisterActivity extends AppCompatActivity {
 ActivityRegisterBinding binding;
     private static final String TAG = "RegisterActivity";
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         binding= DataBindingUtil.setContentView(this, R.layout.activity_register);
         getSupportActionBar().hide();
 }
 
     public void signUp(View view) {
 
 
         String name=binding.etSignupName.getText().toString().trim();
         String email=binding.signupEmail.getText().toString().trim();
         String password=binding.etSignupPassword.getText().toString().trim();
         if (name.isEmpty() || email.isEmpty() || password.isEmpty() ) {
             Toast.makeText(RegisterActivity.this, "please fill all data", Toast.LENGTH_LONG).show();
             return;
         }
 
 
 
             RegisterRequest registerRequest = new RegisterRequest(name, email, password);
         RetrofitClient.getApi().register(registerRequest).subscribeOn(Schedulers.io())
                 .observeOn(AndroidSchedulers.mainThread())
                 .subscribe(new SingleSubscriber<RegisterResponse>() {
                     @Override
                     public void onSuccess(RegisterResponse value) {
                         Toast.makeText(RegisterActivity.this, "Acount Created", Toast.LENGTH_LONG).show();
                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                          finish();
                     }
 
                     @Override
                     public void onError(Throwable error) {
                         Log.i(TAG, "onError: "+ error.getLocalizedMessage());
                        // Toast.makeText(RegisterActivity.this, error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
 
                     }
                 });
 
 
 //            RetrofitClient.getApi().register(registerRequest).enqueue(new Callback<RegisterResponse>() {
 //                @Override
 //                public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
 //                    if (response.code() == 200) {
 //                            Toast.makeText(RegisterActivity.this, "Acount Created", Toast.LENGTH_LONG).show();
 //                            startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
 //                         finish();
 //                        }
 //                    else if(response.code() == 401){
 //
 //                        Toast.makeText(RegisterActivity.this, response.body().getMessage(), Toast.LENGTH_LONG).show();
 //
 //
 //                    }
 //
 //
 //                }
 //
 //                @Override
 //                public void onFailure(Call<RegisterResponse> call, Throwable t) {
 //                    String errorMessage = t.getLocalizedMessage();
 //                    Toast.makeText(RegisterActivity.this, errorMessage, Toast.LENGTH_LONG).show();
 //
 //                }
 //            });
 
     }
 
     public void goLogin(View view) {
         startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
 
     }
 }