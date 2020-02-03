package com.example.newartproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newartproject.Adapter.GridViewAdapter;
import com.example.newartproject.Client.ClientInfoManager;
import com.example.newartproject.Data.mPicture;
import com.example.newartproject.R;

public class ItemInfoActivity extends AppCompatActivity {
    private mPicture item;
    private ClientInfoManager clientInfoManager=ClientInfoManager.getInstance();

    private TextView itemNameTextView;
    private TextView ArtistTextView;
    private TextView CostTextView;
    private Button BuyButton;
    private Button CartButton;
    private ImageView itemImageView;
    private GridView recommendGridView;
    private ScrollView scrollView;

    private GridViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_info);
        itemImageView=(ImageView)findViewById(R.id.itemImageView);

        itemNameTextView=(TextView)findViewById(R.id.itemNameTextView);
        ArtistTextView=(TextView)findViewById(R.id.artistTextView);
        CostTextView=(TextView)findViewById(R.id.costTextView);

        BuyButton=(Button)findViewById(R.id.buyButton);
        CartButton=(Button)findViewById(R.id.cartButton);

        recommendGridView=(GridView)findViewById(R.id.recommendGridView);
        scrollView=(ScrollView)findViewById(R.id.scrollView);

        try {
                Intent intent=getIntent();
                item=(mPicture)intent.getExtras().get("picture");

            itemImageView.setImageResource(item.getSrc());

            itemNameTextView.setText(item.getName());
            ArtistTextView.setText(item.getArtist());
            CostTextView.setText(item.getCost()+"원");

            BuyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent= new Intent(ItemInfoActivity.this,BuyActivity.class);
                    intent.putExtra("picture",item);
                    startActivity(intent);
                }
            });
            CartButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(ItemInfoActivity.this,"카트에 상품이 담겼습니다.", Toast.LENGTH_SHORT).show();
                }
            });

            adapter = new GridViewAdapter(ItemInfoActivity.this, R.layout.row, clientInfoManager.getRecommendPictures());    // 데이터
            recommendGridView.setAdapter(adapter);
            recommendGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(ItemInfoActivity.this, ItemInfoActivity.class);
                    intent.putExtra("picture",clientInfoManager.getRecommendPictures().get(position));
                    startActivity(intent);
                }
            });

            int expandSpec = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
            recommendGridView.measure(0, expandSpec);
            recommendGridView.getLayoutParams().height = recommendGridView.getMeasuredHeight();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
