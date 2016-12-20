package com.jackie.picassotest.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;

import com.jackie.picassotest.R;
import com.jackie.picassotest.util.ImageListAdapter;

public class SecondActivity extends AppCompatActivity {

    public static String[] imageUrls = {
            "http://i.imgur.com/rFLNqWI.jpg",
            "http://i.imgur.com/C9pBVt7.jpg",
            "http://i.imgur.com/rT5vXE1.jpg",
            "http://i.imgur.com/aIy5R2k.jpg",
            "http://i.imgur.com/MoJs9pT.jpg",
            "http://i.imgur.com/S963yEM.jpg",
            "http://i.imgur.com/rLR2cyc.jpg",
            "http://i.imgur.com/SEPdUIx.jpg",
            "http://i.imgur.com/aC9OjaM.jpg",
            "",
            "http://i.imgur.com/76Jfv9b.jpg",
            "http://i.imgur.com/fUX7EIB.jpg",
            "http://i.imgur.com/syELajx.jpg",
            "http://i.imgur.com/COzBnru.jpg",
            "http://i.imgur.com/Z3QjilA.jpg",
    };

    private ListView lv;
    private GridView gridView;
    private Button switchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        lv = (ListView) findViewById(R.id.lv);
        gridView = (GridView) findViewById(R.id.grid);
        switchButton = (Button) findViewById(R.id.bt);
        //切换 ListView 与 GridView 的显示模式
        switchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (lv.getVisibility() == View.VISIBLE) {
                    lv.setVisibility(View.INVISIBLE);
                    gridView.setVisibility(View.VISIBLE);
                } else {
                    lv.setVisibility(View.VISIBLE);
                    gridView.setVisibility(View.INVISIBLE);
                }
            }
        });

        lv.setAdapter(new ImageListAdapter(this, imageUrls));
        gridView.setAdapter(new ImageListAdapter(this, imageUrls));
    }
}
