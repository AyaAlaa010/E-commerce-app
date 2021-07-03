package com.example.mygraduationprojectamit.cart;

import android.content.Context;
import android.content.SharedPreferences;
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


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.cart.database.ProductUser;
import com.example.mygraduationprojectamit.cart.database.ProductUserResponse;
import com.example.mygraduationprojectamit.databinding.FragmentCartBinding;
import com.example.mygraduationprojectamit.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observer;
import rx.Scheduler;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

import static android.content.Context.MODE_PRIVATE;

public class cartFragment extends Fragment {
FragmentCartBinding binding;
    private cartViewModel cartViewModel;
    List<ProductUser> cartList=new ArrayList<>();
    CartAdapter cartAdapter;
    private static final String TAG = "cartFragment";
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        binding= DataBindingUtil.inflate(inflater, R.layout.fragment_cart,container,false);
//
        cartViewModel =
                new ViewModelProvider(this).get(cartViewModel.class);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        String  myToken=requireActivity().getSharedPreferences("products",MODE_PRIVATE).getString("accessToken","");
        String token = "Bearer " + myToken;
        RetrofitClient.getApi().Userproduct(token).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<ProductUserResponse>() {
                    @Override
                    public void onSuccess(ProductUserResponse value) {

                        Toast.makeText(requireContext(), "product Added", Toast.LENGTH_LONG).show();
                        cartList = value.getProducts();
                        cartAdapter = new CartAdapter(cartList);
                        binding.recyclerCart.setAdapter(cartAdapter);

                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "onError: "+ error.getLocalizedMessage());
                    }
                });
//                    Toast.makeText(requireContext(), "product Added", Toast.LENGTH_LONG).show();
//                    cartList=response.body().getProducts();
//                    cartAdapter=new CartAdapter(cartList);
//                    binding.recyclerCart.setAdapter(cartAdapter);             }
//
//                else{
//
//                    Toast.makeText(requireContext(), response.body().getMessage(), Toast.LENGTH_LONG).show();
//
//
//                }


//
//            @Override
//            public void onFailure(Call<ProductUserResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });
//


                }}