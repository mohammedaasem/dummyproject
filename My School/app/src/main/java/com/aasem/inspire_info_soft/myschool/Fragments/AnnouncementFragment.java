package com.aasem.inspire_info_soft.myschool.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aasem.inspire_info_soft.myschool.Adaptor.Announcement_Adapter;
import com.aasem.inspire_info_soft.myschool.CustomView.EditText.EditText;
import com.aasem.inspire_info_soft.myschool.DataClasses.Announcement;
import com.aasem.inspire_info_soft.myschool.R;
import com.aasem.inspire_info_soft.myschool.SharedPrefManager;
import com.aasem.inspire_info_soft.myschool.Utill.URL;
import com.aasem.inspire_info_soft.myschool.VolleySingleton;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.fxn.cue.Cue;
import com.fxn.cue.enums.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AnnouncementFragment extends Fragment implements TextWatcher {
    Context context;
    View view;
    SharedPrefManager sharedPrefManager;
    RecyclerView recyclerView;
    EditText et_search;
    String search_string;
    ArrayList<Announcement> announcements;
    Announcement_Adapter announcement_adapter;

    RequestQueue requestQueue;
    StringRequest stringRequest;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_announcement, container, false);
        init(view);
        return view;
    }

    private void init(View view) {
        context=getActivity();
        getActivity().setTitle("Announcement");
        sharedPrefManager=new SharedPrefManager(context);
        recyclerView=(RecyclerView)view.findViewById(R.id.rv_announcement);
        et_search=(EditText)view.findViewById(R.id.et_search);
        search_string="";
        announcements=new ArrayList<Announcement>();
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        announcement_adapter=new Announcement_Adapter(context,announcements,search_string);
        recyclerView.setAdapter(announcement_adapter);

        et_search.addTextChangedListener(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        getAnnouncements();
    }

    private void getAnnouncements()
    {
        requestQueue = Volley.newRequestQueue(context);
//        stringRequest = new StringRequest(Request.Method.GET, URL.ANNOUNCEMENT,
        stringRequest = new StringRequest(Request.Method.GET, URL.ANNOUNCEMENT +"?user_type="+sharedPrefManager.getLoginUserType(),
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Toast.makeText(getApplicationContext(), response, Toast.LENGTH_SHORT).show();
                        announcements.clear();
                        try {
                                JSONObject jsonObject=new JSONObject(response);
                                GsonBuilder gsonBuilder = new GsonBuilder();

                            Gson gson = new Gson();
                            java.lang.reflect.Type type = new TypeToken<List<Announcement>>(){}.getType();
                            announcements = gson.fromJson(jsonObject.getJSONArray("info").toString(), type);

                            //    Gson gson = gsonBuilder.create();
                            //    java.lang.reflect.Type type = new TypeToken<List<Announcement>>(){}.getType();
                            //    announcements = gson.fromJson(jsonObject.getJSONArray("info").toString(), type);
                                announcement_adapter.updateAnnouncement(announcements);
                        }
                        catch (JSONException e)
                        {
                            e.printStackTrace();
                        }
                        catch (Exception e)
                        {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Cue.init()
                                .with(context)
                                .setGravity(Gravity.BOTTOM)
                                .setMessage(error.getMessage())
                                .setType(Type.DANGER)
                                .show();
//                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String, String> params = new HashMap<>();
                params.put("user_type",sharedPrefManager.getLoginUserType());
                return params;
            }
            /*@Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> headers = new HashMap<String, String>();
                headers.put("Content-Type","application/x-www-form-urlencoded");
                headers.put("user_type",sharedPrefManager.getLoginUserType());
                return headers;
            }*/
        };
        VolleySingleton.getInstance(context).addToRequestQueue(stringRequest);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        search_string=et_search.getText().toString();
        announcement_adapter.search(search_string);
    }
}
