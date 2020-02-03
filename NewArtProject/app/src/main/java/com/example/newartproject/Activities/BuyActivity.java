package com.example.newartproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.newartproject.Data.mPicture;
import com.example.newartproject.R;

public class BuyActivity extends AppCompatActivity {
    private mPicture picture;
    private ImageView imageView;
    private TextView nameTextView;
    private TextView costTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        imageView=findViewById(R.id.buyImageView);
        nameTextView=findViewById(R.id.buyNameTextView);
        costTextView=findViewById(R.id.buyCostTextView);

        try {
            Intent intent = getIntent();
            picture = (mPicture) intent.getExtras().get("picture");
            imageView.setImageResource(picture.getSrc());
            nameTextView.setText(picture.getArtist()+" ["+picture.getName()+"]");
            costTextView.setText(picture.getCost() + "원");
        }catch (Exception e) {

        }
    }
}
