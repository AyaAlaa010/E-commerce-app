package com.example.mygraduationprojectamit.cart;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;


import com.example.mygraduationprojectamit.R;
import com.example.mygraduationprojectamit.cart.database.ProductUser;
import com.example.mygraduationprojectamit.databinding.ItemCartBinding;

import java.util.List;


public class CartAdapter extends RecyclerView.Adapter<CartAdapter.cartHolder> {
    List<ProductUser> cartModelList;
    public CartAdapter(List<ProductUser> cartModelList) {
        this.cartModelList = cartModelList;

    }

    @NonNull
    @Override
    public cartHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new cartHolder(DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_cart,parent
                ,false));
    }

    @Override
    public void onBindViewHolder(@NonNull cartHolder holder, int position) {
        ProductUser cartModel=cartModelList.get(position);
        holder.itemBinding.setData(cartModel);


        holder.itemBinding.btProductIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               int quantity= Integer.parseInt(holder.itemBinding.etCartProductnum.getText().toString());
                quantity= quantity + 1;
                holder.itemBinding.etCartProductnum.setText("" + quantity);

            }
        });
        holder.itemBinding.btCartDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int quantity= Integer.parseInt(holder.itemBinding.etCartProductnum.getText().toString());
                if(quantity>0){
                quantity= quantity - 1;
                holder.itemBinding.etCartProductnum.setText("" + quantity);


                  holder.itemBinding.btProductIncrement.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int quantity= Integer.parseInt( holder.itemBinding.etCartProductnum.getText().toString());
                            quantity= quantity + 1;
                            holder.itemBinding.etCartProductnum.setText("" + quantity);
                        }
                    });
                    holder.itemBinding.btCartDecrement.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int quantity= Integer.parseInt(holder.itemBinding.etCartProductnum.getText().toString());
                            if(quantity>0){
                                quantity= quantity - 1;
                                holder.itemBinding.etCartProductnum.setText("" + quantity);}

                        }
                    });


                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return cartModelList.size();
    }

    class cartHolder extends RecyclerView.ViewHolder{
      ItemCartBinding itemBinding;

        public cartHolder(@NonNull ItemCartBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding=itemBinding;
            //كده مش هعرف ال فيو اللي عندي
        }
    }


}


