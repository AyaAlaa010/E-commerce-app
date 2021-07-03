package com.example.mygraduationprojectamit.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.databinding.ItemHomeBinding;
import com.example.mygraduationprojectamit.home.products.Product;
import com.example.mygraduationprojectamit.interfaces.ProductInterface;

import java.util.ArrayList;
import java.util.List;

public class HomeAdapter  extends RecyclerView.Adapter<HomeAdapter.HomeHolder> {
    ProductInterface homeInterface;
    List<Product> homeList=new ArrayList<>();

    Context context;

    public HomeAdapter(List<Product> homeList, Context context,  ProductInterface homeInterface)
    {
this.context=context;
        this.homeList = homeList;
        this.homeInterface=homeInterface;
    }
    @NonNull
    @Override
    public HomeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_home,parent
                ,false));}

    @Override
    public void onBindViewHolder(@NonNull HomeHolder holder, int position) {
        Product product=  homeList.get(position);
        holder.itemHomeBinding.setHomeModel(product);
        int productId= product.getId();
        holder.itemHomeBinding.btProductAdd.setOnClickListener(new View.OnClickListener() {
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
        // Picasso.get().load(homeModel.getUrlToImage()).placeholder(R.mipmap.ic_launcher_round).into((holder.imgNews));





    }

    @Override
    public int getItemCount()
    {
        return homeList.size();
    }

    class HomeHolder extends RecyclerView.ViewHolder{
        ItemHomeBinding itemHomeBinding;



        public HomeHolder(@NonNull ItemHomeBinding itemHomeBinding) {
            super(itemHomeBinding.getRoot());
            this.itemHomeBinding=itemHomeBinding;
        }
    }}
