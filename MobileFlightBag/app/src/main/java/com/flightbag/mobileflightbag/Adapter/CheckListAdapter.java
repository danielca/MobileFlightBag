package com.flightbag.mobileflightbag.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.flightbag.mobileflightbag.Model.CheckListItem;
import com.flightbag.mobileflightbag.R;

import java.util.List;

/**
 * Created by casey on 2016-03-29.
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
    public CheckListItem getItem(int position) {
        return this.checkListItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItem;

        if (convertView == null){
            listItem = (View) LayoutInflater.from(context).inflate(R.layout.checklist_item, parent, false);
            CheckListItem checkListItem = this.getItem(position);

            TextView item = (TextView) listItem.findViewById(R.id.check_item);
            item.setText(checkListItem.getItem());

            TextView action = (TextView) listItem.findViewById(R.id.check_action);
            action.setText(checkListItem.getChecked());

        } else {
            listItem = convertView;
        }

        return listItem;
    }
}
