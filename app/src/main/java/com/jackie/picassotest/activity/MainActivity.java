package com.jackie.picassotest.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.jackie.picassotest.R;
import com.squareup.picasso.Picasso;

import java.io.File;

/**
 * Created by Administrator on 2016/12/19.
 */
public class MainActivity extends Activity {

    public static final String ANDROID_RESOURCE = "android.resource://";

    private Button button;
    private Button button_res;
    private Button button_file;
    private Button button_next;
    private ImageView imageView;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn1);
        button_res = (Button) findViewById(R.id.btn2);
        button_file = (Button) findViewById(R.id.btn3);
        button_next = (Button) findViewById(R.id.btn4);
        imageView = (ImageView) findViewById(R.id.iv);
        textView = (TextView) findViewById(R.id.tv);


        Uri uri = resourceIdToUri(this, R.mipmap.ic_fire);
        textView.setText(uri.toString());
        Picasso.with(this).load(uri).into(imageView);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });
        button_res.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImageRes();
            }
        });
        button_file.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImageFile();
            }
        });
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }


    private static Uri resourceIdToUri(Context context, int resourceId) {
        return Uri.parse(ANDROID_RESOURCE + context.getPackageName() + "/" + resourceId);
    }


    private void loadImage() {
        Picasso.with(this).load("http://e.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e86bb728c0fd7912397dd8c2b.jpg").into(imageView);
    }

    private void loadImageRes() {
        Picasso.with(this).load(R.drawable.bruce).into(imageView);
    }

    private void loadImageFile() {
        Picasso.with(this).load(new File(Environment.getExternalStorageDirectory(), "110720490449.png")).into(imageView);
    }
}
