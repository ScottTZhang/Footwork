package com.example.footwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class DifficultyAdapter extends BaseAdapter {

    private Context mContext;
    private final Difficulty[] difficulties; //would change to  drill item object

    DifficultyAdapter(Context context, Difficulty[] difficulties) {
        mContext = context;
        this.difficulties = difficulties;
    }

    @Override
    public int getCount() {
        return difficulties.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final Difficulty diff = difficulties[position];

        ImageView difficultyImageView;
        TextView difficultyTextView;
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.gridview_layout, parent, false);
        }
        difficultyTextView = convertView.findViewById(R.id.gridview_text);
        difficultyImageView = convertView.findViewById(R.id.gridview_image);
        difficultyTextView.setText(diff.level);
        difficultyImageView.setImageResource(diff.imageId);

        return convertView;
    }

}
