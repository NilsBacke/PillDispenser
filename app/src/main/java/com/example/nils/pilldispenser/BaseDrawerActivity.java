package com.example.nils.pilldispenser;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.nils.pilldispenser.Activities.CustomizeActivity;
import com.example.nils.pilldispenser.Fragments.Friday.FridayActivity;
import com.example.nils.pilldispenser.Fragments.Monday.MondayActivity;
import com.example.nils.pilldispenser.Fragments.Saturday.SaturdayActivity;
import com.example.nils.pilldispenser.Fragments.Sunday.SundayActivity;
import com.example.nils.pilldispenser.Fragments.Thursday.ThursdayActivity;
import com.example.nils.pilldispenser.Fragments.Tuesday.TuesdayActivity;
import com.example.nils.pilldispenser.Fragments.Wednesday.WednesdayActivity;

public class BaseDrawerActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    Toolbar toolbar;
    public FrameLayout frameLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base_drawer);;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        frameLayout = (FrameLayout) findViewById(R.id.content_frame);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();

        //to prevent current item select over and over
        if (item.isChecked()){
            drawerLayout.closeDrawer(GravityCompat.START);
            return false;
        }

        if (id == R.id.nav_sunday) {
            startActivity(new Intent(getApplicationContext(), SundayActivity.class));
        } else if (id == R.id.nav_monday) {
            startActivity(new Intent(getApplicationContext(), MondayActivity.class));
        } else if (id == R.id.nav_tuesday) {
            startActivity(new Intent(getApplicationContext(), TuesdayActivity.class));
        } else if (id == R.id.nav_wednesday) {
            startActivity(new Intent(getApplicationContext(), WednesdayActivity.class));
        } else if (id == R.id.nav_thursday) {
            startActivity(new Intent(getApplicationContext(), ThursdayActivity.class));
        } else if (id == R.id.nav_friday) {
            startActivity(new Intent(getApplicationContext(), FridayActivity.class));
        } else if (id == R.id.nav_saturday) {
            startActivity(new Intent(getApplicationContext(), SaturdayActivity.class));
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    /**
     * This method is called upon startup to create the options menu.
     * Gets the menu object from the xml.
     * @param menu The options menu.
     * @return Always true.
     */
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_config_day_drawer, menu);
        getMenuInflater().inflate(R.menu.backarrowmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }

        switch (item.getItemId()) {
            case R.id.backarrow:
                startActivity(new Intent(BaseDrawerActivity.this, CustomizeActivity.class));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
