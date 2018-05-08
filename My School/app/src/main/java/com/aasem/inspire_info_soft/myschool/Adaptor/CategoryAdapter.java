package com.aasem.inspire_info_soft.myschool.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.Category;
import com.aasem.inspire_info_soft.myschool.Interfaces.ItemClickListener;
import com.aasem.inspire_info_soft.myschool.R;

import java.util.ArrayList;

/**
 * Created by inspire_info_soft on 1/26/2018.
 */

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private ArrayList<Category> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    // data is passed into the constructor
    public CategoryAdapter(Context context, ArrayList<Category> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the cell layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.custom_category_row, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the textview in each cell
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Category category=mData.get(position);
        holder.tv_cat_name.setText(category.getName());
        holder.iv_cat_icon.setImageResource(category.getImage());
    }

    // total number of cells
    @Override
    public int getItemCount() {
        return mData.size();
    }

    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView iv_cat_icon;
        TextView tv_cat_name;

        ViewHolder(View itemView) {
            super(itemView);
            tv_cat_name = (TextView) itemView.findViewById(R.id.tv_cat_name);
            iv_cat_icon = (ImageView) itemView.findViewById(R.id.iv_cat_icon);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public Category getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events

}
