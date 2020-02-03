package com.example.newartproject.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.newartproject.Data.mPicture;
import com.example.newartproject.R;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private int img[];
    private String imgUrl[];
    private ArrayList<mPicture> pictures;
    private LayoutInflater inf;

    public GridViewAdapter(Context context, int layout, ArrayList<mPicture> pictures) {
        this.context = context;
        this.layout = layout;
        this.pictures=pictures;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public GridViewAdapter(Context context, int layout, int[] img) {
        this.context = context;
        this.layout = layout;
        this.img = img;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    public GridViewAdapter(Context context, int layout, String[] img) {
        this.context = context;
        this.layout = layout;
        imgUrl = img;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        if(pictures!=null) return pictures.size();
        if(img!=null) return img.length;
        if(imgUrl!=null) return imgUrl.length;
        return 0;
    }
    @Override
    public Object getItem(int position) { return img[position]; }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) convertView = inf.inflate(layout, null);
        final ImageView iv = (ImageView)convertView.findViewById(R.id.rowImageView);
        final int pos=position;
        if(pictures!=null) {
            if(pictures.get(pos).getUrl()!=null) {
                //Glide.with(convertView.getContext()).load(pictures.get(pos).getUrl()).into(iv);
            }
            else {
                iv.setImageResource(pictures.get(pos).getSrc());
            }
        } else {
            if(imgUrl!=null) {
//                Glide.with(convertView.getContext()).load(imgUrl[pos]).into(iv);
            }
            else {
                iv.setImageResource(img[position]);
            }
        }
        return convertView;
    }
}
