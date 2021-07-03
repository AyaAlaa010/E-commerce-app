package com.example.mygraduationprojectamit.productDetails;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.cart.database.ProductRequest;
import com.example.mygraduationprojectamit.cart.database.ProductUserResponse;
import com.example.mygraduationprojectamit.databinding.ActivityProductDetailsBinding;
import com.example.mygraduationprojectamit.home.products.Product;
import com.example.mygraduationprojectamit.network.RetrofitClient;
import com.example.mygraduationprojectamit.seperatedCategory.CategoryIProductdResponse;

import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


public class ProductDetails extends AppCompatActivity {
ActivityProductDetailsBinding binding;
Product product;
    int productId;
    private static final String TAG = "ProductDetails";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_product_details);
        getSupportActionBar().hide();
        binding.btProductIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity= Integer.parseInt(binding.etProductnum.getText().toString());
                quantity= quantity + 1;
                binding.etProductnum.setText("" + quantity);
            }
        });
        binding.btProductDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity= Integer.parseInt(binding.etProductnum.getText().toString());
                if(quantity>0){
                    quantity= quantity - 1;
                    binding.etProductnum.setText("" + quantity);}

            }
        });



        Intent intent = getIntent();
         productId = intent.getIntExtra("productId", 0);


        RetrofitClient.getApi().productById(productId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
               .subscribe(new SingleSubscriber<ProductIdResponse>() {
                              @Override
                              public void onSuccess(ProductIdResponse value) {
                                  product = value.getProduct();
                                binding.setData(product);
//
                              }

                              @Override
                              public void onError(Throwable error) {
                        Log.i(TAG, "onError: "+ error.getLocalizedMessage());

                              }}
                   );

//        RetrofitClient.getApi().productById(productId).enqueue(new Callback<ProductIdResponse>() {
//            @Override
//            public void onResponse(Call<ProductIdResponse> call, Response<ProductIdResponse> response) {
//                if (response.code() == 200) {
//                      product= response.body().getProduct();
//                    binding.setData(product);
//
//            }}
//
//            @Override
//            public void onFailure(Call<ProductIdResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(ProductDetails.this, errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });
    }

    public void addToCart(View view) {

        String  myToken=getSharedPreferences("products",MODE_PRIVATE).getString("accessToken","");
        String token = "Bearer " + myToken;
        Log.i(TAG, "addToCart: "+token);
        Log.i(TAG, "addToCart: xxxxxxxxxxxxxxxxxxxxxxxxxxxxx"+productId);
        int amount= Integer.parseInt(binding.etProductnum.getText().toString().trim());
        ProductRequest productRequest= new ProductRequest(amount);
        RetrofitClient.getApi().UserAddproduct(productRequest,productId,token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ProductUserResponse>() {
                    @Override
                    public void onSuccess(ProductUserResponse value) {
                  Toast.makeText(ProductDetails.this,"product added",Toast.LENGTH_LONG).show();


                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "onError: "+ error.getLocalizedMessage());
                    }
                });


//        RetrofitClient.getApi().UserAddproduct(productRequest,productId,token).enqueue(new Callback<ProductUserResponse>() {
//            @Override
//            public void onResponse(Call<ProductUserResponse> call, Response<ProductUserResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    Toast.makeText(ProductDetails.this,"product added",Toast.LENGTH_LONG).show();
//

//
//                }
//            else{
//                    Toast.makeText(ProductDetails.this,response.body().getMessage(),Toast.LENGTH_LONG).show();
//
//
//
//                }}
//            @Override
//            public void onFailure(Call<ProductUserResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(ProductDetails.this, errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });
    }






}