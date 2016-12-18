package com.jackie.picassotest.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.jackie.picassotest.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Administrator on 2016/12/19.
 */
public class MainActivity extends Activity {


    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.btn1);
        imageView = (ImageView)findViewById(R.id.iv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadImage();
            }
        });
    }

    private void loadImage (){
        Picasso.with(this).load("http://e.hiphotos.baidu.com/image/pic/item/faf2b2119313b07e86bb728c0fd7912397dd8c2b.jpg").into(imageView);
    }
}
