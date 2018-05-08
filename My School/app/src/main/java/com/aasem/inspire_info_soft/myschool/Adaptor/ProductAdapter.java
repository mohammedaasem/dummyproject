package com.aasem.inspire_info_soft.myschool.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.Product;
import com.aasem.inspire_info_soft.myschool.Interfaces.ItemClickListener;
import com.aasem.inspire_info_soft.myschool.R;
import com.aasem.inspire_info_soft.myschool.Utill.Validation;

import java.util.ArrayList;

/**
 * Created by inspire_info_soft on 1/20/2018.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    Context context;
    ArrayList<Product> dataProducts;
    private ItemClickListener mClickListener;

    public ProductAdapter(Context context, ArrayList<Product> dataProducts) {
        this.context = context;
        this.dataProducts = dataProducts;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tv_title, tv_location, tv_selling_price, tv_rating, tv_post_creation_time;
        ImageView iv_logo, iv_verified;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_title = (TextView) itemView.findViewById(R.id.tv_title);
            iv_logo = (ImageView) itemView.findViewById(R.id.iv_logo);
            iv_verified = (ImageView) itemView.findViewById(R.id.iv_verified);
            tv_location = (TextView) itemView.findViewById(R.id.tv_location);
            tv_selling_price = (TextView) itemView.findViewById(R.id.tv_selling_price);
            tv_rating = (TextView) itemView.findViewById(R.id.tv_rating);
            tv_post_creation_time = (TextView) itemView.findViewById(R.id.tv_post_creation_time);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_product_row, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Product product = dataProducts.get(position);
        holder.tv_title.setText(product.getName());
        holder.tv_location.setText(product.getLocation());
        holder.tv_rating.setText("" + product.getRating());
        holder.tv_selling_price.setText(product.getSelling_price() + "");
        holder.tv_post_creation_time.setText(product.getDisplayableTime() + "");
        holder.iv_logo.setImageResource(R.drawable.ic_pets);

        if (!Validation.isEmptyorNull(product.getVerified()) && product.getVerified().equalsIgnoreCase("Verified")) {
            holder.iv_verified.setImageResource(R.drawable.ic_verified);
        }

    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // convenience method for getting data at click position
    public Product getItem(int id) {
        return dataProducts.get(id);
    }

    @Override
    public int getItemCount() {
        return dataProducts.size();
    }
}
