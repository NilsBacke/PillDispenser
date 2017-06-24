package com.example.nils.pilldispenser;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nils on 6/18/17.
 */

public class ConfigDayFragmentCustomAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<DayRegiment> items;
    private Context context;
    private PillBayDatabaseHelper db;
    private String day;

    /**
     * Constructs a new CustomAdapter class from context.
     *
     * @param context The context of the class that constructs the object.
     */
    public ConfigDayFragmentCustomAdapter(Context context, ArrayList<ListElement> listitems, int daynumber, int timeofday) {
        this.context = context;
        db = PillBayDatabaseHelper.getInstance(context);

        items = new ArrayList<>();

        for (int i = 0; i < listitems.size(); i++) {
            DayRegiment dayreg = new DayRegiment(listitems.get(i).number, listitems.get(i).name, listitems.get(i).quantity, daynumber);
            Log.d("DAYREG", dayreg.toString());
            items.add(dayreg);
        }

        switch (daynumber) {
            case 1:
                day = "sunday";
                break;
            case 2:
                day = "monday";
                break;
            case 3:
                day = "tuesday";
                break;
            case 4:
                day = "wednesday";
                break;
            case 5:
                day = "thursday";
                break;
            case 6:
                day = "friday";
                break;
            case 7:
                day = "saturday";
                break;
            default:
                day = "";
        }

        switch (timeofday) {
            case 1:
                day += "morning";
                break;
            case 2:
                day += "afternoon";
                break;
            case 3:
                day += "evening";
                break;
            case 4:
                day += "night";
                break;
        }
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
    public DayRegiment getItem(int pos) {
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
    public void addItem(DayRegiment item) {
        items.add(item);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View view = convertView;
        final ConfigDayFragmentCustomAdapter.DayViewHolder holder;
        if (view == null) {
            holder = new ConfigDayFragmentCustomAdapter.DayViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.fragment_one_item, null);

            holder.label = (TextView) view.findViewById(R.id.label);
            holder.q = (TextView) view.findViewById(R.id.quantitytext);
            holder.changeq = (Button) view.findViewById(R.id.changeqbutton);

            view.setTag(holder);
        } else {
            holder = (ConfigDayFragmentCustomAdapter.DayViewHolder) view.getTag();
        }
        holder.label.setText(items.get(position).name + " (Bay " + items.get(position).number + ")");
        holder.q.setText("Quantity: " + items.get(position).quantity);

        holder.changeq.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder d = new AlertDialog.Builder(context);
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogView = inflater.inflate(R.layout.number_picker_dialog, null);
                d.setTitle("Set Quantity");
                d.setMessage("Set Quantity of " + items.get(position).name);
                d.setView(dialogView);
                final NumberPicker numberPicker = (NumberPicker) dialogView.findViewById(R.id.dialog_number_picker);
                numberPicker.setMaxValue(20);
                numberPicker.setMinValue(0);
                numberPicker.setWrapSelectorWheel(false);
                numberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
                    @Override
                    public void onValueChange(NumberPicker numberPicker, int i, int i1) {

                    }
                });
                d.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        items.get(position).quantity = numberPicker.getValue();

                        if (!db.getAllElements(day).isEmpty()) {
                            db.clearDatabase(day);
                        }

                        for (DayRegiment dayreg: items) {
                            db.addElement(day, dayreg);
                        }

                        notifyDataSetChanged();
                        String daystr = day.substring(0,1).toUpperCase() + day.substring(1);
                        Toast.makeText(context, "Quantity of " + items.get(position).name + " on " + daystr + " set to " + items.get(position).quantity, Toast.LENGTH_SHORT).show();

                    }
                });
                d.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                    }
                });
                AlertDialog alertDialog = d.create();
                alertDialog.show();

            }
        });

        return view;
    }

    private class DayViewHolder {
        TextView label;
        TextView q;
        Button changeq;
    }
}
