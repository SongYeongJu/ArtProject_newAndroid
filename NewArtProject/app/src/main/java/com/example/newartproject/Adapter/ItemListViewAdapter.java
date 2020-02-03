package com.example.newartproject.Adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.newartproject.Activities.BuyActivity;
import com.example.newartproject.Client.ClientInfoManager;
import com.example.newartproject.R;

public class ItemListViewAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private LayoutInflater inf;
    private ClientInfoManager clientInfoManager=ClientInfoManager.getInstance();
    private int type;
    static public int PICTURE = 1111;
    static public int RECPICTURE = 2222;

    public ItemListViewAdapter(Context context, int layout, int type) {
        this.context = context;
        this.layout = layout;
        inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.type=type;
    }
    @Override
    public int getCount() {
        if(type==PICTURE && clientInfoManager.getPictures()!=null) return clientInfoManager.getPictures().size();
        if(type==RECPICTURE && clientInfoManager.getRecommendPictures()!=null) return clientInfoManager.getRecommendPictures().size();
        return 0;
    }
    @Override
    public Object getItem(int position) { return clientInfoManager.getPictures().get(position); }
    @Override
    public long getItemId(int position) { return position; }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null) convertView = inf.inflate(layout, null);
        final int pos=position;

        final ImageButton heartButton = (ImageButton)convertView.findViewById(R.id.heartButton);
        final ImageButton shareButton = (ImageButton)convertView.findViewById(R.id.shareButton);

        heartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clientInfoManager.getPictures().get(pos).getLike())  {
                    clientInfoManager.getPictures().get(pos).setLike(false);
                    heartButton.setImageResource(R.drawable.heart);
                } else {
                    clientInfoManager.getPictures().get(pos).setLike(true);
                    heartButton.setImageResource(R.drawable.full_heart);
                }

            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final ImageView imageView =(ImageView)convertView.findViewById(R.id.itemImageView);

        imageView.setImageResource(clientInfoManager.getPictures().get(pos).getSrc());

        final TextView itemNameTextView=(TextView)convertView.findViewById(R.id.itemNameTextView);
        final TextView artistTextView=(TextView)convertView.findViewById(R.id.artistTextView);
        final TextView costTextView=(TextView)convertView.findViewById(R.id.costTextView);

        itemNameTextView.setText(clientInfoManager.getPictures().get(pos).getName());
        artistTextView.setText(clientInfoManager.getPictures().get(pos).getArtist());
        costTextView.setText(clientInfoManager.getPictures().get(pos).getCost()+"원");

        final Button cartButton=(Button)convertView.findViewById(R.id.cartButton);
        final Button buyButton=(Button)convertView.findViewById(R.id.buyButton);

        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"카트에 상품이 담겼습니다.", Toast.LENGTH_SHORT).show();
            }
        });
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(view.getContext(), BuyActivity.class);
                intent.putExtra("picture",clientInfoManager.getPictures().get(pos));
                view.getContext().startActivity(intent);
            }
        });




        return convertView;
    }
}
