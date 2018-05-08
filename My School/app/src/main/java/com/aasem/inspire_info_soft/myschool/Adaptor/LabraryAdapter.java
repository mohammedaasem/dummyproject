package com.aasem.inspire_info_soft.myschool.Adaptor;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.HomeLabrory;
import com.aasem.inspire_info_soft.myschool.Fragments.HomeLabrarory;
import com.aasem.inspire_info_soft.myschool.Interfaces.ItemClickListener;
import com.aasem.inspire_info_soft.myschool.R;

import java.util.ArrayList;

/**
 * Created by inspire_info_soft on 2/14/2018.
 */

public class LabraryAdapter extends RecyclerView.Adapter<LabraryAdapter.MyViewHolder> {
    Context context;
    ArrayList<HomeLabrory> homeLabrories;
    private ItemClickListener mClickListener;

    public LabraryAdapter(Context context, ArrayList<HomeLabrory> homeLabrories) {
        this.context = context;
        this.homeLabrories = homeLabrories;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvBookName, tvBookAuthorName, tvBookPublication, tvBookRelease, tvBookAvailable;


        public MyViewHolder(View itemView) {
            super(itemView);
            tvBookName = (TextView) itemView.findViewById(R.id.tv_book_name);
            tvBookAuthorName = (TextView) itemView.findViewById(R.id.tv_book_author);
            tvBookPublication = (TextView) itemView.findViewById(R.id.tv_publication);
            tvBookRelease = (TextView) itemView.findViewById(R.id.tv_release_year);
            tvBookAvailable = (TextView) itemView.findViewById(R.id.tv_available_book);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    @Override
    public LabraryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.custom_design_labrary, parent, false);
        return new LabraryAdapter.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(LabraryAdapter.MyViewHolder holder, int position) {
        HomeLabrory homeLabrory = homeLabrories.get(position);
        holder.tvBookName.setText(homeLabrory.getBookName());
        holder.tvBookAuthorName.setText(homeLabrory.getBookAuthorName());
        holder.tvBookRelease.setText("" + homeLabrory.getBookPublicationName());
        holder.tvBookPublication.setText(homeLabrory.getBookReleaseYear() + "");
        holder.tvBookAvailable.setText(homeLabrory.getBookAvailable() + "");
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }


    @Override
    public int getItemCount() {
        return homeLabrories.size();
    }
}
