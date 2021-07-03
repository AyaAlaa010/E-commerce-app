package com.example.mygraduationprojectamit.login;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("token")
    @Expose
    String token;
    @SerializedName("error")
    @Expose
    String error;
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public LoginResponse(String token, String error) {
        this.token = token;
        this.error = error;
    }
}
