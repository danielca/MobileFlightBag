package com.flightbag.mobileflightbag.Adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flightbag.mobileflightbag.Model.CheckListItem;
import com.flightbag.mobileflightbag.R;

import java.util.List;

/**
 * Created by casey on 2016-03-28.
 */
public class CheckListAdapter extends BaseAdapter {

    private Context context;
    private List<CheckListItem> checkListItems;

    public CheckListAdapter(Context context, List<CheckListItem> checkListItems){
        this.context = context;
        this.checkListItems = checkListItems;
    }

    @Override
    public int getCount() {
        return this.checkListItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.checkListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem;
        if (convertView == null){
            gridItem = LayoutInflater.from(context).inflate(R.layout.checklist_selector, parent, false);

            ImageView imageView = (ImageView) gridItem.findViewById(R.id.checklist_image);
            Resources resources = Resources.getSystem();
//            imageView.setImageResource(context.getResources().getIdentifier("mulit","drawable",context.getPackageName()));
//            ((BitmapDrawable)imageView.getDrawable()).getBitmap().recycle();
            imageView.setImageResource(R.drawable.multi);
            TextView textView = (TextView) gridItem.findViewById(R.id.grid_text_view);
            textView.setText(this.checkListItems.get(position).getDisplayName());

        }else {
            gridItem = (View) convertView;
        }
        return gridItem;
    }
}
