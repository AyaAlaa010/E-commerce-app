package com.example.mygraduationprojectamit.home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.databinding.FragmentHomeBinding;
import com.example.mygraduationprojectamit.home.products.Product;
import com.example.mygraduationprojectamit.home.products.ProductResponse;
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

public class HomeFragment extends Fragment {
    FragmentHomeBinding binding;
    private HomeViewModel homeViewModel;
    List<Product> productList = new ArrayList<>();
    private static final String TAG = "HomeFragment";

    HomeAdapter homeAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        RetrofitClient.getApi().product().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ProductResponse>() {
                    @Override
                    public void onSuccess(ProductResponse value) {

                        Toast.makeText(requireContext(), "product Added", Toast.LENGTH_LONG).show();
                        productList = value.getProducts();
                        homeAdapter = new HomeAdapter(productList, requireContext(), homeInterface);
                        binding.recyclerHome.setAdapter(homeAdapter);
                        binding.recyclerHome.setLayoutManager(new GridLayoutManager(requireContext(), 2));
                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "onError: " + error.getLocalizedMessage());
                    }
                });

//        // at last set adapter to recycler view.
//        RetrofitClient.getApi().product().enqueue(new Callback<ProductResponse>() {
//            @Override
//            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    productList = response.body().getProducts();
//                    homeAdapter=new HomeAdapter(productList,requireContext(),homeInterface);
//                    binding.recyclerHome.setAdapter(homeAdapter);
//                    binding.recyclerHome.setLayoutManager(new GridLayoutManager(requireContext(),2));
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ProductResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });

    }

    ProductInterface homeInterface = new ProductInterface() {
        @Override
        public void onItemViewClick(Product product, int productId) {
            Intent intent = new Intent(requireContext(), ProductDetails.class);
            intent.putExtra("productId", productId);
            startActivity(intent);
        }
    };


}