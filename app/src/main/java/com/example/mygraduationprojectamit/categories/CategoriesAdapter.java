package com.example.mygraduationprojectamit.categories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.categories.categoryApis.CategoriesInterface;
import com.example.mygraduationprojectamit.categories.categoryApis.Category;
import com.example.mygraduationprojectamit.databinding.ItemCategoriesBinding;

import java.util.List;


public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.CategoriesHolder> {
    List<Category> categoriesModelList;
    CategoriesInterface categoriesInterface;
    public CategoriesAdapter(List<Category> categoriesModelList,CategoriesInterface categoriesInterface) {
        this.categoriesModelList = categoriesModelList;
        this.categoriesInterface=categoriesInterface;
    }

    @NonNull
    @Override
    public CategoriesHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CategoriesHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_categories,parent
                ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CategoriesHolder holder, int position) {
        Category category=categoriesModelList.get(position);
        holder.itemBinding.setCategoriesModel(category);
        int categoryId=category.getId();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoriesInterface.getContentOfCategory(category,categoryId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return categoriesModelList.size();
    }

    class CategoriesHolder extends RecyclerView.ViewHolder{
        ItemCategoriesBinding itemBinding;

        public CategoriesHolder(@NonNull ItemCategoriesBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
            //كده مش هعرف ال فيو اللي عندي
        }
    }


}


