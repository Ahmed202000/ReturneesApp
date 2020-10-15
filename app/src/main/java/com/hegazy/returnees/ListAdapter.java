package com.hegazy.returnees;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    private List<Data> Datalist = null;
    private ArrayList<Data> arraylist;
    Context context;

    public ListAdapter(Activity context, List<Data> openSite) {
        this.context=context;
        this.Datalist = openSite;
        inflater = LayoutInflater.from(context);
        this.arraylist = new ArrayList<>();
        this.arraylist.addAll(openSite);

    }

    @Override
    public int getCount() {
        return Datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return Datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        View Item =inflater.inflate(R.layout.item_listview, null,true);

        TextView txtTitle = (TextView) Item.findViewById(R.id.titleid);

        txtTitle.setText(Datalist.get(position).getSubject1());

        return Item;

    };

    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        Datalist.clear();
        if (charText.length() == 0) {
            Datalist.addAll(arraylist);
        }
        else
        {
            for (Data wp : arraylist)
            {
                if (wp.getSubject1().toLowerCase(Locale.getDefault()).contains(charText))
                {
                    Datalist.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }
}
