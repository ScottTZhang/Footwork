package com.example.footwork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DrillAdapter extends BaseAdapter {

    private Context mContext;
    private final String[] gridViewString; //would change to  drill item object
    private final Integer[] gridViewImageId;


    DrillAdapter(Context context, String[] gridViewString, Integer[] gridViewImageId) {
        mContext = context;
        this.gridViewImageId = gridViewImageId;
        this.gridViewString = gridViewString;
    }

    @Override
    public int getCount() {
        return gridViewString.length;
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
        View gridViewDrill;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ImageView drillImageView;
        TextView drillTextView;
        if (convertView == null) {
            gridViewDrill = inflater.inflate(R.layout.drill_gridview_layout, parent, false);
            drillTextView = gridViewDrill.findViewById(R.id.drill_gridview_text);
            drillImageView = gridViewDrill.findViewById(R.id.drill_gridview_image);
            drillTextView.setText(gridViewString[position]);
            drillImageView.setImageResource(gridViewImageId[position]);

//            gridViewDrill.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    View textView = v.findViewById(R.id.drill_gridview_text);
//                    textView.setVisibility(View.VISIBLE);
//                    View imageView = v.findViewById(R.id.drill_gridview_image);
//                    imageView.setVisibility(View.INVISIBLE);
//                }
//            });

        } else {
            gridViewDrill = convertView;
        }

        return gridViewDrill;
    }

}
