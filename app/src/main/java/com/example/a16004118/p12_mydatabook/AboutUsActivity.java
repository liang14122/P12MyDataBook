package com.example.a16004118.p12_mydatabook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.felipecsl.gifimageview.library.GifImageView;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class AboutUsActivity extends AppCompatActivity {

    private ActionBar ab;
    private ImageView iv;

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        iv = findViewById(R.id.iv);

        Picasso.get()
                .load("https://upload.wikimedia.org/wikipedia/commons/8/80/Republic_Polytechnic_Logo.jpg")
                .placeholder(R.drawable.loading)
                .error(R.drawable.error)
                .into(iv);

        ab = getSupportActionBar();
        assert ab != null;
        ab.setDisplayHomeAsUpEnabled(true);
//        Picasso.get()
//                .load()
//                .error()
//                .into(iv);
    }
}
