package com.example.a16004118.p12_mydatabook;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawerAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<String> itemList;

    public DrawerAdapter(Context context,
                         int resource,
                         ArrayList<String> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        itemList = objects;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View rowView = convertView;

        if (rowView == null) {
            LayoutInflater inflater = (LayoutInflater) parent_context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(layout_id, parent, false);
        } else {
            rowView = convertView;
        }

        TextView tvTitle = rowView.findViewById(R.id.tv);
        ImageView ivIcon = rowView.findViewById(R.id.ivIcon);

        String currentItem = itemList.get(position);
        tvTitle.setText(currentItem);

        switch(position)
        {
            case 0:
                ivIcon.setImageResource(android.R.drawable.ic_dialog_info);
                break;
            case 1:
                ivIcon.setImageResource(android.R.drawable.ic_menu_preferences);
                break;
            case 2:
                ivIcon.setImageResource(android.R.drawable.ic_menu_agenda);
                break;
            case 3:
                ivIcon.setImageResource(android.R.drawable.star_big_on);
                break;
        }

        return rowView;
    }

}
