package com.example.mygraduationprojectamit.seperatedCategory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.databinding.ActivityCategoryContentBinding;
import com.example.mygraduationprojectamit.home.products.Product;
import com.example.mygraduationprojectamit.interfaces.ProductInterface;
import com.example.mygraduationprojectamit.network.RetrofitClient;
import com.example.mygraduationprojectamit.productDetails.ProductDetails;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CategoryContent extends AppCompatActivity {
    List<Product> productList= new ArrayList<>();
    SeperatedCategoryAdapter adapter;
    private static final String TAG = "CategoryContent";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCategoryContentBinding binding;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_category_content);
        getSupportActionBar().hide();
        Intent intent = getIntent();
        int categoryId = intent.getIntExtra("categoryId", 0);
        RetrofitClient.getApi().CategorySearchById(categoryId).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<CategoryIdResponse>() {
                    @Override
                    public void onSuccess(CategoryIdResponse value) {

                        productList = value.getProducts();
                   adapter = new SeperatedCategoryAdapter(productList,homeInterface);
                   binding.recCategoryContent.setAdapter(adapter);
                   binding.recCategoryContent.setLayoutManager(new GridLayoutManager(CategoryContent.this, 2));

                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "onError: "+ error.getLocalizedMessage());
                    }
                });

//        RetrofitClient.getApi().CategorySearchById(categoryId).enqueue(new Callback<CategoryIdResponse>() {
//            @Override
//            public void onResponse(Call<CategoryIdResponse> call, Response<CategoryIdResponse> response) {
//                if (response.code() == 200) {
//                    productList = response.body().getProducts();
//                    adapter = new SeperatedCategoryAdapter(productList,homeInterface);
//                    binding.recCategoryContent.setAdapter(adapter);
//                    binding.recCategoryContent.setLayoutManager(new GridLayoutManager(CategoryContent.this, 2));
//                } else {
//
//                    Toast.makeText(CategoryContent.this, "error", Toast.LENGTH_LONG).show();
//
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<CategoryIdResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(CategoryContent.this, errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });
    }

        ProductInterface homeInterface= new ProductInterface() {
            @Override
            public void onItemViewClick(Product product,int productId) {
                Intent intent = new Intent(CategoryContent.this, ProductDetails.class);
                intent.putExtra("productId", productId);
                startActivity(intent);
            }
    };}