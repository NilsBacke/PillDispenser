package com.example.nils.pilldispenser.Fragments;

        import android.content.Intent;
        import android.os.Bundle;
        import android.support.design.widget.TabLayout;
        import android.support.v4.app.Fragment;
        import android.support.v4.app.FragmentManager;
        import android.support.v4.app.FragmentPagerAdapter;
        import android.support.v4.view.ViewPager;
        import android.support.v7.app.AppCompatActivity;

        import com.example.nils.pilldispenser.ListElement;
        import com.example.nils.pilldispenser.PillBayDatabaseHelper;
        import com.example.nils.pilldispenser.R;
        import java.util.ArrayList;
        import java.util.List;

public class ConfigADayActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private PillBayDatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_day);

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        // not the same database because diff context?
        db = PillBayDatabaseHelper.getInstance(this);
    }

    /**
     * This method is automatically called when a new intent is passed to this activity.
     * @param intent The passed intent.
     */
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new OneFragment(), "Sunday");
        adapter.addFragment(new TwoFragment(), "Monday");
        adapter.addFragment(new ThreeFragment(), "Tuesday");
        adapter.addFragment(new FourFragment(), "Wednesday");
        adapter.addFragment(new FiveFragment(), "Thursday");
        adapter.addFragment(new SixFragment(), "Friday");
        adapter.addFragment(new SevenFragment(), "Saturday");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

    public ArrayList<ListElement> getList(String tableName) {
        return db.getAllElements(tableName);
    }
}
