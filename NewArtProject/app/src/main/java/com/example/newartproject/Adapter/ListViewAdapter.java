package com.example.newartproject.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;

import com.example.newartproject.Data.Taste;
import com.example.newartproject.R;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private ArrayList<Taste> tastes;
    private LayoutInflater inf;

    public ListViewAdapter(Context context, int layout, ArrayList<Taste> tastes) {
        this.context = context;
        this.layout = layout;
        this.tastes=tastes;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        if(tastes!=null) return tastes.size();
        return 0;
    }
    @Override
    public Object getItem(int position) { return tastes.get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) convertView = inf.inflate(layout, null);

        final CheckBox checkBox = (CheckBox)convertView.findViewById(R.id.tasteCheckBox);
        final int pos=position;

        checkBox.setText(tastes.get(pos).getTasteName());

        return convertView;
    }
}
