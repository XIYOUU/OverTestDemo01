package com.example.overtestdemo01.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.overtestdemo01.R;
public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        ImageView user_head = (ImageView) findViewById(R.id.user_head);


        /*头像圆角*/
        Glide.with(UserInfoActivity.this)
                .load(R.drawable.user_head).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(user_head);
    }
}