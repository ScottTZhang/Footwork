package com.example.footwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class DrillAdapter extends BaseAdapter {

    private final Context mContext;
    private final Drill[] drills; //would change to  drill item object

    DrillAdapter(Context context, Drill[] drills) {
        mContext = context;
        this.drills = drills;
    }

    @Override
    public int getCount() {
        return drills.length;
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
        final Drill drill = drills[position];

        ImageView drillImageView;
        TextView drillTextView;
        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.gridview_layout, parent, false);
        }
        drillTextView = convertView.findViewById(R.id.gridview_text);
        drillImageView = convertView.findViewById(R.id.gridview_image);
        drillTextView.setText(drill.title);
        drillImageView.setImageResource(drill.imageId);

        return convertView;
    }

}
