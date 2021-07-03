package com.example.mygraduationprojectamit.seperatedCategory;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.databinding.ItemProductContentBinding;
import com.example.mygraduationprojectamit.home.products.Product;
import com.example.mygraduationprojectamit.interfaces.ProductInterface;

import java.util.ArrayList;
import java.util.List;

public class SeperatedCategoryAdapter extends RecyclerView.Adapter<SeperatedCategoryAdapter.productHolder> {
    List<Product> productList= new ArrayList<>();
    ProductInterface homeInterface;
    public SeperatedCategoryAdapter(List<Product> productList, ProductInterface homeInterface)
    {
        this.productList = productList;
        this.homeInterface=homeInterface;
    }
    @NonNull
    @Override
    public productHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new productHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_product_content,parent
                ,false));}

    @Override
    public void onBindViewHolder(@NonNull productHolder holder, int position) {
        Product product=  productList.get(position);
        holder.itemBinding.setData(product);
        int productId=product.getId();
        holder.itemBinding.btCategorycontentAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeInterface.onItemViewClick(product,productId);

            }
        });


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeInterface.onItemViewClick(product,productId);

            }
        });
        // Picasso.get().load(homeModel.getUrlToImage()).placeholder(R.mipmap.ic_launcher_round).into((holder.imgNews))
    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }

    class productHolder extends RecyclerView.ViewHolder{
        ItemProductContentBinding itemBinding;
        public productHolder(@NonNull ItemProductContentBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
        }
    }}
