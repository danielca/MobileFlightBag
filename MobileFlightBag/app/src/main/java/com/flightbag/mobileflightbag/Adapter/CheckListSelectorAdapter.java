package com.flightbag.mobileflightbag.Adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.flightbag.mobileflightbag.Activity.Checklist;
import com.flightbag.mobileflightbag.Activity.SoloFlightSelection;
import com.flightbag.mobileflightbag.Model.CheckListSelectionItem;
import com.flightbag.mobileflightbag.R;

import java.util.List;

/**
 * Created by casey on 2016-03-28.
 */
public class CheckListSelectorAdapter extends BaseAdapter {

    private Context context;
    private List<CheckListSelectionItem> checkListSelectionItems;

    public CheckListSelectorAdapter(Context context, List<CheckListSelectionItem> checkListSelectionItems){
        this.context = context;
        this.checkListSelectionItems = checkListSelectionItems;
    }

    @Override
    public int getCount() {
        return this.checkListSelectionItems.size();
    }

    @Override
    public Object getItem(int position) {
        return this.checkListSelectionItems.get(position);
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
            imageView.setImageResource(context.getResources().getIdentifier("mulit","drawable",context.getPackageName()));
            ((BitmapDrawable)imageView.getDrawable()).getBitmap().recycle();
            imageView.setImageResource(R.drawable.multi);
            TextView textView = (TextView) gridItem.findViewById(R.id.grid_text_view);
            textView.setText(this.checkListSelectionItems.get(position).getDisplayName());

        }else {
            gridItem = (View) convertView;
        }
        gridItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Checklist.class);
                context.startActivity(intent);

            }
        });
        return gridItem;
    }
}
