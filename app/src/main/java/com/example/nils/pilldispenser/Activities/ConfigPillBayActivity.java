package com.example.nils.pilldispenser.Activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.nils.pilldispenser.ConfigPillBayCustomAdapter;
import com.example.nils.pilldispenser.ListElement;
import com.example.nils.pilldispenser.PillBayDatabaseHelper;
import com.example.nils.pilldispenser.R;

import java.util.ArrayList;

//************FIX COMMENTS**************//
public class ConfigPillBayActivity extends AppCompatActivity {

    ListView listView;
    ArrayList<ListElement> itemlist;
    int counter;
    PillBayDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_pill_bay);
        listView = (ListView) findViewById(R.id.list);
        itemlist = new ArrayList<>();
        counter = 0;
        db = new PillBayDatabaseHelper(this);

        itemlist.addAll(db.getAllElements("pillbay"));

        setTitle("Configure a Pill Bay");
        updateList();
    }

    /**
     * This method is necessary to allow successful operation of the app when the device orientation is switched.
     * The list is updated, which also updates the total price text view.
     */
    @Override
    protected void onStart() {
        super.onStart();
        updateList();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateList();
    }

    @Override
    protected void onPause() {
        super.onPause();
        db.clearDatabase("pillbay");
        db.clearDatabase("sundaymorning");
        db.clearDatabase("sundayafternoon");
        db.clearDatabase("sundayevening");
        db.clearDatabase("sundaynight");
        db.clearDatabase("mondaymorning");
        db.clearDatabase("mondayafternoon");
        db.clearDatabase("mondayevening");
        db.clearDatabase("mondaynight");
        db.clearDatabase("tuesdaymorning");
        db.clearDatabase("tuesdayafternoon");
        db.clearDatabase("tuesdayevening");
        db.clearDatabase("tuesdaynight");
        db.clearDatabase("wednesdaymorning");
        db.clearDatabase("wednesdayafternoon");
        db.clearDatabase("wednesdayevening");
        db.clearDatabase("wednesdaynight");
        db.clearDatabase("thursdaymorning");
        db.clearDatabase("thursdayafternoon");
        db.clearDatabase("thursdayevening");
        db.clearDatabase("thursdaynight");
        db.clearDatabase("fridaymorning");
        db.clearDatabase("fridayafternoon");
        db.clearDatabase("fridayevening");
        db.clearDatabase("fridaynight");
        db.clearDatabase("saturdaymorning");
        db.clearDatabase("saturdayafternoon");
        db.clearDatabase("saturdayevening");
        db.clearDatabase("saturdaynight");

        for (ListElement listele : itemlist) {
            db.addElement("pillbay", listele);
            db.addElement("sundaymorning", listele);
            db.addElement("sundayafternoon", listele);
            db.addElement("sundayevening", listele);
            db.addElement("sundaynight", listele);
            db.addElement("mondaymorning", listele);
            db.addElement("mondayafternoon", listele);
            db.addElement("mondayevening", listele);
            db.addElement("mondaynight", listele);
            db.addElement("tuesdaymorning", listele);
            db.addElement("tuesdayafternoon", listele);
            db.addElement("tuesdayevening", listele);
            db.addElement("tuesdaynight", listele);
            db.addElement("wednesdaymorning", listele);
            db.addElement("wednesdayafternoon", listele);
            db.addElement("wednesdayevening", listele);
            db.addElement("wednesdaynight", listele);
            db.addElement("thursdaymorning", listele);
            db.addElement("thursdayafternoon", listele);
            db.addElement("thursdayevening", listele);
            db.addElement("thursdaynight", listele);
            db.addElement("fridaymorning", listele);
            db.addElement("fridayafternoon", listele);
            db.addElement("fridayevening", listele);
            db.addElement("fridaynight", listele);
            db.addElement("saturdaymorning", listele);
            db.addElement("saturdayafternoon", listele);
            db.addElement("saturdayevening", listele);
            db.addElement("saturdaynight", listele);
        }
        itemlist.clear();
        itemlist.addAll(db.getAllElements("pillbay"));
        updateList();
        Toast.makeText(ConfigPillBayActivity.this,  "The configuration has been saved.",
                Toast.LENGTH_SHORT).show();
        Toast.makeText(ConfigPillBayActivity.this,  "All of the day's regiments have been reset.",
                Toast.LENGTH_SHORT).show();

    }

    /**
     * This method is automatically called when a new intent is passed to this activity.
     * @param intent The passed intent.
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        updateList();
    }

    /**
     * This method is called upon startup to create the options menu.
     * Gets the menu object from the xml.
     * @param menu The options menu.
     * @return Always true.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.configpillbaymenu, menu);
        return true;
    }

    /**
     * This method is called when a button on the options menu is pressed.
     * If the search button is pressed, it passes the intent to the SearchActivity activity.
     * If the deleteAll button is pressed, the list is cleared.
     * @param item The menu item.
     * @return Always true.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.deleteAllbutton:
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);

                // set dialog message
                alertDialogBuilder.setMessage("Are you sure you want to delete all bays in your current configuration?")
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                // Make toast
                                Toast.makeText(ConfigPillBayActivity.this,  "The list has been cleared.",
                                        Toast.LENGTH_SHORT).show();
                                // Remove all items
                                itemlist.clear();
                                updateList();
                                counter = 0;
                            }
                        })
                        .setNegativeButton("Cancel", null);
                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                // show the alert dialog
                alertDialog.show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    /**
     * This method updates the CustomAdapter with the items array list.
     */
    private void updateList() {
        ConfigPillBayCustomAdapter adapter = new ConfigPillBayCustomAdapter(this, itemlist);
        listView.setAdapter(adapter);
    }

    public void addAPillBayButton(View view) {
        if (itemlist.isEmpty()) {
            counter = 1;
        } else {
            counter = itemlist.size() + 1;
        }

        itemlist.add(new ListElement(counter, ""));
        updateList();
    }

}
