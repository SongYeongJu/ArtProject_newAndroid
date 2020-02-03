package com.example.newartproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.newartproject.Activities.ItemInfoActivity;
import com.example.newartproject.Adapter.GridViewAdapter;
import com.example.newartproject.Client.ClientInfoManager;
import com.example.newartproject.R;


public class Tab1Fragment extends Fragment {
    static public Tab1Fragment tab1Fragment= new Tab1Fragment();
    static public Tab1Fragment getInstance(){ return tab1Fragment; }
    private ClientInfoManager clientInfoManager=ClientInfoManager.getInstance();
    private GridView gv;
    private GridViewAdapter adapter;
    private TextView category1TextView;
    private TextView category2TextView;
    private TextView category3TextView;
    private TextView category4TextView;


    public Tab1Fragment() { }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab1, container, false);

        gv = (GridView)view.findViewById(R.id.gridView1);
        adapter = new GridViewAdapter (getActivity(), R.layout.row, clientInfoManager.getPictures());    // 데이터
        gv.setAdapter(adapter);
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), ItemInfoActivity.class);
                intent.putExtra("picture",clientInfoManager.getPictures().get(position));
                startActivity(intent);
            }
        });

        category1TextView=view.findViewById(R.id.category1TextView);
        category1TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new GridViewAdapter (getActivity(), R.layout.row, clientInfoManager.getPictures());    // 데이터
                gv.setAdapter(adapter);
            }
        });
        category2TextView=view.findViewById(R.id.category2TextView);
        category2TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new GridViewAdapter (getActivity(), R.layout.row, clientInfoManager.getRecommendPictures());    // 데이터
                gv.setAdapter(adapter);
            }
        });
        category3TextView=view.findViewById(R.id.category3TextView);
        category3TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new GridViewAdapter (getActivity(), R.layout.row, clientInfoManager.getPictures());    // 데이터
                gv.setAdapter(adapter);
            }
        });

        category4TextView=view.findViewById(R.id.category4TextView);
        category4TextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter = new GridViewAdapter (getActivity(), R.layout.row, clientInfoManager.getRecommendPictures());    // 데이터
                gv.setAdapter(adapter);
            }
        });

        return view;
    }
}
