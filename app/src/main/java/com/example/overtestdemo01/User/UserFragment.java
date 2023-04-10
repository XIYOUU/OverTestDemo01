package com.example.overtestdemo01.User;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.overtestdemo01.R;

import java.io.File;


public class UserFragment extends Fragment {


    private ImageView user_head_;
    private RelativeLayout rl_home_page;
    private View v;
    private RelativeLayout rl_id_query;
    private RelativeLayout rl_apply;
    private RelativeLayout rl_know;
    private RelativeLayout rl_achievements;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_user, container, false);
        initWidget();
        /*头像圆角*/
        Glide.with(getActivity())
                .load(R.drawable.user_head).apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(user_head_);
//        /*跳转到主页*/
//        rl_home_page.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(getActivity(),UserInfoActivity.class));
//            }
//        });
        /*跳转到证件成绩查询*/
        rl_id_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("https://query.ruankao.org.cn/certificate/main/");//此处填链接
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        /*跳转到官网报名*/
        rl_apply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("https://bm.ruankao.org.cn/sign/welcome/");//此处填链接
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        /*跳转到证书了解*/
        rl_know.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                Uri content_url = Uri.parse("https://www.ruankao.org.cn/introduction");//此处填链接
                intent.setData(content_url);
                startActivity(intent);
            }
        });
        /*跳转到我的成就*/
        rl_achievements.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),UserInfoActivity.class));
            }
        });
        return v;
    }
    public void initWidget(){
        user_head_ = (ImageView) v.findViewById(R.id.user_head_);
        rl_home_page = (RelativeLayout) v.findViewById(R.id.rl_home_page);
        rl_id_query = (RelativeLayout) v.findViewById(R.id.rl_id_query);
        rl_apply = (RelativeLayout) v.findViewById(R.id.rl_apply);
        rl_know = (RelativeLayout) v.findViewById(R.id.rl_know);
        rl_achievements = (RelativeLayout) v.findViewById(R.id.rl_achievements);
    }
}