package com.aasem.inspire_info_soft.myschool.Adaptor;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.Spannable;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.aasem.inspire_info_soft.myschool.DataClasses.Announcement;
import com.aasem.inspire_info_soft.myschool.R;
import com.aasem.inspire_info_soft.myschool.SharedPrefManager;
import com.aasem.inspire_info_soft.myschool.Utill.Validation;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

import java.util.ArrayList;
import java.util.Locale;

import static com.aasem.inspire_info_soft.myschool.Utill.Utility.getDateFromStringyyyy_mm_dd;
import static com.aasem.inspire_info_soft.myschool.Utill.Utility.getDisplayableTime;


/**
 * Created by DELL-PC$ on 08/12/2017.
 */

public class Announcement_Adapter extends RecyclerView.Adapter<Announcement_Adapter.Myholder>  {
    Context context;
    ArrayList<Announcement> announcements,temp_annAnnouncements;
    String searchString;
    ProgressDialog progressDialog;
    SharedPrefManager sharedPrefManager;
    public Announcement_Adapter(Context context, ArrayList<Announcement> announcements, String searchString){
        this.context=context;
        this.announcements = announcements;
        this.temp_annAnnouncements = new ArrayList<Announcement>(announcements);
        this.searchString=searchString;
        sharedPrefManager=new SharedPrefManager(context);
    }
    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflate= LayoutInflater.from(context);
        View view=inflate.inflate(R.layout.custom_design_announcement,parent,false);
        Myholder holder=new Myholder(view);
        return holder;
    }
    public void updateAnnouncement(ArrayList<Announcement> announcements)
    {
        this.announcements = announcements;
        this.temp_annAnnouncements = new ArrayList<Announcement>(announcements);
        notifyDataSetChanged();
    }
    public void search(String searchString)
    {
        this.searchString=searchString.toLowerCase();
        if(!Validation.isEmptyorNull(searchString))
        {
            temp_annAnnouncements.clear();
            for(int i=0;i<announcements.size();i++)
            {
                if(announcements.get(i).getTitle().toLowerCase().contains(searchString)||announcements.get(i).getMessage().toLowerCase().contains(searchString))
                {
                    temp_annAnnouncements.add(announcements.get(i));
                }
            }
        }
        else
        {
            this.temp_annAnnouncements = new ArrayList<Announcement>(announcements);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final Myholder holder, final int position) {

        holder.tv_title.setText(""+ temp_annAnnouncements.get(position).getTitle());

        Glide
                .with(context)
                .load(temp_annAnnouncements.get(position).getImage())
                .centerCrop()
                .into(new SimpleTarget<GlideDrawable>() {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> glideAnimation) {
                        holder.announcement_image.setVisibility(View.VISIBLE);
                        holder.announcement_image.setImageDrawable(resource);
                    }
                });

        holder.tv_message.setText(""+ temp_annAnnouncements.get(position).getMessage());
        holder.tv_time.setText(""+ getDisplayableTime(getDateFromStringyyyy_mm_dd(temp_annAnnouncements.get(position).getTime())));

        if(!Validation.isEmptyorNull(searchString))
        {
            // Find charText in wp
            searchString=searchString.toLowerCase(Locale.getDefault());
            String title = temp_annAnnouncements.get(position).getTitle().toLowerCase(Locale.getDefault());
            if (title.toLowerCase().contains(searchString)) {
                int startPos = title.indexOf(searchString);
                int endPos = startPos + searchString.length();

                Spannable spanText = Spannable.Factory.getInstance().newSpannable(holder.tv_title.getText());
                spanText.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.highlight)), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.tv_title.setText(spanText, TextView.BufferType.SPANNABLE);
            }

            String message = temp_annAnnouncements.get(position).getMessage().toLowerCase(Locale.getDefault());
            if (message.toLowerCase().contains(searchString)) {
                int startPos = message.indexOf(searchString);
                int endPos = startPos + searchString.length();

                Spannable spanText = Spannable.Factory.getInstance().newSpannable(holder.tv_message.getText());
                spanText.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.highlight)), startPos, endPos, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                holder.tv_message.setText(spanText, TextView.BufferType.SPANNABLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return temp_annAnnouncements.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {
        ImageView iv_delete;
        TextView tv_title,tv_time,tv_message;
        ImageView announcement_image;
        public Myholder(View itemView) {
            super(itemView);
            tv_title=(TextView)itemView.findViewById(R.id.tv_title);
            tv_time=(TextView)itemView.findViewById(R.id.tv_time);
            tv_message=(TextView)itemView.findViewById(R.id.tv_message);
            announcement_image=(ImageView)itemView.findViewById(R.id.iv_image);
        }
    }
}
