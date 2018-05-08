package com.aasem.inspire_info_soft.myschool;

import android.support.v4.app.Fragment;

/**
 * Created by inspire_info_soft on 1/31/2018.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.aasem.inspire_info_soft.myschool.Adaptor.CategoryAdapter;
import com.aasem.inspire_info_soft.myschool.DataClasses.Category;
import com.aasem.inspire_info_soft.myschool.Fragments.AnnouncementFragment;
import com.aasem.inspire_info_soft.myschool.Fragments.HomeContactUs;
import com.aasem.inspire_info_soft.myschool.Fragments.HomeLabrarory;
import com.aasem.inspire_info_soft.myschool.Fragments.HomeLabs;
import com.aasem.inspire_info_soft.myschool.Fragments.HomeReport;
import com.aasem.inspire_info_soft.myschool.Fragments.HomeStaff;
import com.aasem.inspire_info_soft.myschool.Fragments.Profile;
import com.aasem.inspire_info_soft.myschool.Fragments.UnderConstruction;
import com.aasem.inspire_info_soft.myschool.Interfaces.ItemClickListener;

import java.util.ArrayList;
import static com.aasem.inspire_info_soft.myschool.MainActivity.OpenFrgment;
import static com.aasem.inspire_info_soft.myschool.Utill.Navigations.Category_id_Key;

public class Dashboard extends Fragment implements ItemClickListener {

    Context context;
    RecyclerView rv_category;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;
    int numberOfColumns = 3;
    LinearLayout ll_container;
    public static boolean isOpen=true;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_dashboard, container, false);
        init(view);
        return view;
    }

    void init(View view)
    {
        context=getActivity();
        categories=new ArrayList<>();
        rv_category=(RecyclerView)view.findViewById(R.id.rv_category);
        ll_container=(LinearLayout)view.findViewById(R.id.ll_container);
        rv_category.setLayoutManager(new GridLayoutManager(context, numberOfColumns));
        categoryAdapter = new CategoryAdapter(context, categories);
        categoryAdapter.setClickListener(this);
        rv_category.setAdapter(categoryAdapter);

    }

    void loadCategory()
    {
        categories.clear();
        categories.add(new Category(1,"My Profile",R.drawable.ic_man));
        categories.add(new Category(2,"Announcements",R.drawable.ic_megaphone));
        categories.add(new Category(3,"Message",R.drawable.ic_email));
        categories.add(new Category(4,"Attendance",R.drawable.ic_attendence));
        categories.add(new Category(5,"Performance",R.drawable.ic_analytics));
        categories.add(new Category(6,"Result",R.drawable.ic_result));
        categories.add(new Category(7,"Account",R.drawable.ic_account));
        categories.add(new Category(8,"Staff",R.drawable.ic_teacher));
        categories.add(new Category(9,"Library",R.drawable.ic_bookshelf));
        categories.add(new Category(10,"Laboratory",R.drawable.ic_chemistry));
        categories.add(new Category(11,"Contact Us",R.drawable.ic_phone_book));
        categories.add(new Category(12,"Calender",R.drawable.ic_calendar));
        categories.add(new Category(14,"Notes",R.drawable.ic_notepad));
        categories.add(new Category(13,"About Developer",R.drawable.ic_deve));
        categories.add(new Category(15,"Logout",R.drawable.ic_button_on_off));

        categoryAdapter.notifyDataSetChanged();
    }


    @Override
    public void onResume() {
        super.onResume();
        isOpen=true;
        loadCategory();
    }

    @Override
    public void onPause() {
        super.onPause();
        isOpen=false;
    }

    @Override
    public void onItemClick(View view, int position) {
        Category category=categoryAdapter.getItem(position);

        Bundle bundle=new Bundle();

        bundle.putInt(Category_id_Key,category.getCategory_id());

        Fragment fragment=null;

        switch (position) {
            case 0:
                fragment = new Profile();
                break;

            case 1:
                fragment=new AnnouncementFragment();
                break;

            case 7:
                fragment=new HomeStaff();
                break;

            case 8:
                fragment=new HomeLabrarory();
                break;

            case 9:
                fragment=new HomeLabs();
                break;

            case 10:
                fragment=new HomeContactUs();
                break;

            default:
                fragment = new UnderConstruction();
                break;
        }
        fragment.setArguments(bundle);

        OpenFrgment(fragment);
        //   fragmentManager.beginTransaction().setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right).replace(R.id.ll_container,fragment).addToBackStack(null).commit();
    }
}
