package com.example.laboration2;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

public class LabbAdapter extends BaseExpandableListAdapter {
   private Context context;
   private List<String> listTitles;
   private HashMap<String, List<String>> listDetail;

   public LabbAdapter(Context c, List<String> titles, HashMap<String, List<String>> data){
       this.context= c;
       this.listTitles= titles;
       this.listDetail = data;
   }

    @Override
    public int getGroupCount() {
        return listTitles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
         return listDetail.get(getGroup(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listTitles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return listDetail.get(getGroup(groupPosition)).get(childPosition);

    }

    @Override
    public long getGroupId(int groupPosition) {
        return  groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String name = (String) getGroup(groupPosition);
        if (convertView == null){
            LayoutInflater layoutInflater = (LayoutInflater)
                    this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_parents,null);
        }
        TextView titleView = (TextView) convertView.findViewById(R.id.textView);
        titleView.setText(name);
        titleView.setTypeface(null, Typeface.BOLD);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
       String  country = (String) getChild(groupPosition,childPosition);
       if(convertView == null){
           LayoutInflater layoutInflater = (LayoutInflater)
                   this.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
           convertView = layoutInflater.inflate(R.layout.list_children,null);
       }
        TextView titleView = (TextView) convertView.findViewById(R.id.textView2);
        titleView.setText(country);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
