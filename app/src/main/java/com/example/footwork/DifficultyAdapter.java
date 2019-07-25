package com.example.footwork;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class DifficultyAdapter extends BaseAdapter {
    private Context mContext;

    DifficultyAdapter(Context c) {
        mContext = c;
    }

    @Override
    public int getCount() {
        return questionImages.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(mContext);
        imageView.setLayoutParams(new GridView.LayoutParams(200, 200));
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setPadding(8, 8, 8, 8);
        imageView.setImageResource(questionImages[position]);
        return imageView;
    }

    //Hard coded as 4. Needs to pass the value to values folder, and use
    private Integer[] questionImages = {
            R.drawable.question, R.drawable.question,
            R.drawable.question, R.drawable.question};
}
