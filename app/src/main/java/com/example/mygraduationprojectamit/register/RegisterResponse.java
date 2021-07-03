package com.example.mygraduationprojectamit.register;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("errors")
        @Expose
        private Errors errors;
    @SerializedName("token")
    @Expose
    String token;

    public RegisterResponse(String message, Errors errors, String token) {
        this.message = message;
        this.errors = errors;
        this.token = token;
    }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Errors getErrors() {
            return errors;
        }

        public void setErrors(Errors errors) {
            this.errors = errors;
        }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
