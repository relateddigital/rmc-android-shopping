package com.melikeey.shoppingdemo.adapters;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.melikeey.shoppingdemo.model.Product;
import com.melikeey.shoppingdemo.fragments.ProductDetailFragment;
import com.melikeey.shoppingdemo.R;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private List<Product> productList;
    AppCompatActivity activity;

    public class ViewHolder extends RecyclerView.ViewHolder{
        //each data item is just a string in this case
        public TextView tvRank, tvName, tvContent;
        Button btnBasket;
        public ImageView ivProduct;
        CardView cardView;

        public ViewHolder(View v) {
            super(v);
            tvRank = v.findViewById(R.id.tv_rank);
            tvName = v.findViewById(R.id.tv_product_name);
            tvContent = v.findViewById(R.id.tv_product_content);
            btnBasket = v.findViewById(R.id.tv_add_basket);
            ivProduct = v.findViewById(R.id.iv_home_product);
            cardView = v.findViewById(R.id.card_view);
            activity = (AppCompatActivity) v.getContext();
        }
    }

    public HomeAdapter(List<Product> productList){
        this.productList = productList;
    }

    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final HomeAdapter.ViewHolder holder, int position) {

        final Product product = productList.get(position);
        holder.tvRank.setText("DEMO");
        holder.tvName.setText(product.getName());
        holder.tvContent.setText(product.getContent());
        holder.ivProduct.setImageResource(product.getPic());

        holder.btnBasket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Sepete Eklendi", Toast.LENGTH_LONG).show();
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment productDetailFragment = new ProductDetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("product",  product);
                productDetailFragment.setArguments(bundle);

                activity.getSupportFragmentManager().beginTransaction()
                        .replace(R.id.container, productDetailFragment, "home")
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}