package com.jackie.picassotest.util;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.jackie.picassotest.R;
import com.squareup.picasso.Picasso;

/**
 * 适配器
 */
public class ImageListAdapter extends ArrayAdapter {
    private Context context;

    private String[] imageUrls;

    public ImageListAdapter(Context context, String[] imageUrls) {
        super(context, R.layout.item_picasso, imageUrls);

        this.context = context;
        this.imageUrls = imageUrls;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = View.inflate(context, R.layout.item_picasso, null);
        }
        ImageView imageView = (ImageView) convertView;
        if (TextUtils.isEmpty(imageUrls[position])) {
            Picasso
                    .with(context)
                    .cancelRequest(imageView);
            imageView.setImageDrawable(null);
        } else {
            //加载图片
            Picasso
                    .with(context)
                    .load(imageUrls[position])
                    .placeholder(R.drawable.no_hot_food)
                    .error(R.drawable.ic_share_close)
                    .noFade()
                    .into((ImageView) convertView);
        }
        return convertView;
    }
}
