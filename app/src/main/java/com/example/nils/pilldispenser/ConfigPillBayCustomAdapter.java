package com.example.nils.pilldispenser;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Created by Nils on 6/15/17.
 */

//************FIX COMMENTS**************//
public class ConfigPillBayCustomAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<ListElement> items;
    private Context context;

    /**
     * Constructs a new CustomAdapter class from context.
     *
     * @param context The context of the class that constructs the object.
     */
    public ConfigPillBayCustomAdapter(Context context, ArrayList<ListElement> items) {
        this.items = items;
        this.context = context;
    }

    /**
     * This method returns the number of items in the list.
     *
     * @return The size of the array list.
     */
    @Override
    public int getCount() {
        return items.size();
    }

    /**
     * This method returns an object at a given position.
     *
     * @param pos The position of the item in the arraylist.
     * @return The item at the given position.
     */
    @Override
    public ListElement getItem(int pos) {
        return items.get(pos);
    }

    /**
     * This method returns the id of the item at a given position.
     *
     * @param pos The position of the item in the arraylist.
     * @return The item's id at the given position.
     */
    @Override
    public long getItemId(int pos) {
        return 0;
        //just return 0 if your list items do not have an Id variable.
    }

    /**
     * This method adds an item to the arraylist.
     *
     * @param item The item that will be added.
     */
    public void addItem(ListElement item) {
        items.add(item);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.configpillbay_iteminfo, null);

            holder.baynumber = (TextView) view.findViewById(R.id.baynumber);
            holder.bayname = (EditText) view.findViewById(R.id.bayname);

            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.baynumber.setTag(position);
        holder.bayname.setTag(position);

        holder.baynumber.setText("Bay " + items.get(position).number + ":");

        if (!items.get(position).name.isEmpty()) {
            holder.bayname.setText(items.get(position).name);
        }

        holder.bayname.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                int pos = (Integer) holder.bayname.getTag();
                items.get(pos).name = s.toString();

            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }

        });

        if (items.get(position).name.length() > 0) {
            items.get(position).name = items.get(position).name.substring(0, 1).toUpperCase() + items.get(position).name.substring(1);
        }
        return view;
    }

    private class ViewHolder {
        TextView baynumber;
        EditText bayname;
    }
}
