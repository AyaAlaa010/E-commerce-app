package com.example.mygraduationprojectamit.categories;

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
import com.example.mygraduationprojectamit.categories.categoryApis.CategoriesInterface;
import com.example.mygraduationprojectamit.categories.categoryApis.CategoriesResponse;
import com.example.mygraduationprojectamit.categories.categoryApis.Category;
import com.example.mygraduationprojectamit.databinding.FragmentCategoriesBinding;
import com.example.mygraduationprojectamit.network.RetrofitClient;
import com.example.mygraduationprojectamit.seperatedCategory.CategoryContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class CategoriesFragment extends Fragment {
    FragmentCategoriesBinding binding;
    private CategoriesViewModel categoriesViewModel;
    CategoriesAdapter categoriesAdapter;
    List<Category> categoryList;
    private static final String TAG = "CategoriesFragment";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_categories, container, false);
//
        categoriesViewModel = new ViewModelProvider(this).get(CategoriesViewModel.class);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {


        binding.recyclerCategories.setLayoutManager(new GridLayoutManager(requireContext(), 2));
        RetrofitClient.getApi().categories().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleSubscriber<CategoriesResponse>() {
                    @Override
                    public void onSuccess(CategoriesResponse value) {

                        Toast.makeText(requireContext(), "product Added", Toast.LENGTH_LONG).show();
                        categoryList = value.getCategories();
                        categoriesAdapter = new CategoriesAdapter(categoryList, categoriesInterface);
                        binding.recyclerCategories.setAdapter(categoriesAdapter);

                    }

                    @Override
                    public void onError(Throwable error) {
                        Log.i(TAG, "onError: " + error.getLocalizedMessage());
                    }
                });
//        RetrofitClient.getApi().categories().enqueue(new Callback<CategoriesResponse>() {
//            @Override
//            public void onResponse(Call<CategoriesResponse> call, Response<CategoriesResponse> response) {
//                if (response.isSuccessful() && response.body() != null) {
//                    categoryList = response.body().getCategories();
//                    categoriesAdapter=new CategoriesAdapter(categoryList,categoriesInterface);
//                    binding.recyclerCategories.setAdapter(categoriesAdapter);
//                }  //  n
//            }
//
//            @Override
//            public void onFailure(Call<CategoriesResponse> call, Throwable t) {
//                String errorMessage = t.getLocalizedMessage();
//                Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show();
//            }
//        });


    }

    CategoriesInterface categoriesInterface = new CategoriesInterface() {

        @Override
        public void getContentOfCategory(Category category, int categoryId) {
            Intent intent = new Intent(requireContext(), CategoryContent.class);
            intent.putExtra("categoryId", categoryId);
            startActivity(intent);


        }
    };

}