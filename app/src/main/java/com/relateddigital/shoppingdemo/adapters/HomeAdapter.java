package com.relateddigital.shoppingdemo.adapters;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.relateddigital.shoppingdem.R;
import com.relateddigital.shoppingdemo.OnItemClickListener;
import com.relateddigital.shoppingdemo.Utils;
import com.relateddigital.shoppingdemo.model.Product;
import com.relateddigital.shoppingdemo.fragments.ProductDetailFragment;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Product> productList;
    AppCompatActivity activity;
    Product product;

    public class ViewHolder extends RecyclerView.ViewHolder {
        //each data item is just a string in this case
        public TextView tvRank, tvName, tvContent, tvPrice;
        Button btnBasket;
        public ImageView ivProduct;
        CardView cardView;

        public ViewHolder(View v) {
            super(v);
            tvRank = v.findViewById(R.id.tv_rank);
            tvName = v.findViewById(R.id.tv_product_name);
            tvPrice = v.findViewById(R.id.tv_price);
            tvContent = v.findViewById(R.id.tv_product_brand);
            btnBasket = v.findViewById(R.id.btn_add_basket);
            ivProduct = v.findViewById(R.id.iv_home_product);
            cardView = v.findViewById(R.id.card_view);

            activity = (AppCompatActivity) v.getContext();
        }
    }

    public HomeAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home, parent, false);

        return new ViewHolder(v);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(final HomeAdapter.ViewHolder holder, int position) {

        product = productList.get(position);
        holder.tvRank.setText("DEMO");
        holder.tvName.setText(product.getName());
        holder.tvContent.setText(product.getBrand());
        Picasso.get().load(product.getImage()).into(holder.ivProduct);
        holder.tvPrice.setText(product.getPrice() + "TL");

        holder.btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utils.showMessage("Sepete Eklendi", v.getContext());
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mOnItemClickListener != null) {
                    mOnItemClickListener.onItemClick(product);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}