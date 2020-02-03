package com.example.newartproject.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.newartproject.Activities.ChattingActivity;
import com.example.newartproject.R;


public class Tab3Fragment extends Fragment {
    static public Tab3Fragment tab3Fragment= new Tab3Fragment();
    static public Tab3Fragment getInstance(){ return tab3Fragment; }
    private LinearLayout linearLayout;
    public Tab3Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_tab3, container, false);
        linearLayout=view.findViewById(R.id.chattingLayout);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), ChattingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
