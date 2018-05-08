package com.aasem.inspire_info_soft.myschool;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aasem.inspire_info_soft.myschool.Adaptor.ProductAdapter;
import com.aasem.inspire_info_soft.myschool.DataClasses.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static com.aasem.inspire_info_soft.myschool.Utill.Navigations.Category_id_Key;

public class CategoryFragment extends Fragment {

    Context context;
    RecyclerView rv_product;
    ArrayList<Product> products;
    ProductAdapter productAdapter;
    int category_id;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_category, container, false);
        getActivity().setTitle("New Metro Bazar");
        init(view);
        try {
            Bundle bundle=getArguments();
            if(bundle!=null)
            {
                category_id=bundle.getInt(Category_id_Key);
                getCategory(category_id);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return view;
    }

    void init(View view)
    {
        context=getActivity();
        rv_product=(RecyclerView)view.findViewById(R.id.rv_product);
        products=new ArrayList<>();
        productAdapter=new ProductAdapter(context,products);
        rv_product.setLayoutManager(new LinearLayoutManager(context));
        rv_product.setAdapter(productAdapter);
        getCategory(0);
    }

    public void getCategory(int product_id) {
        products.clear();

        /*int product_id, String name, float selling_price, String location, Date date_creation, float rating, String verified*/

        Date date1= null;
        try {
            date1 = new SimpleDateFormat("dd/MM/yyyy").parse("23/1/2018");
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,1.3f,""));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,3.0f,""));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,""));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.0f,""));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Pune",date1,4.5f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,""));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,""));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
            products.add(new Product(1,"4 Month Used Red Mi 4A",3000,"Dange Chowk",date1,4.3f,"Verified"));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        productAdapter.notifyDataSetChanged();
    }

}
