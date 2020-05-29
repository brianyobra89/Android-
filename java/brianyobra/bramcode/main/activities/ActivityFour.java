package brianyobra.bramcode.main.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import brianyobra.bramcode.main.DataModel;
import brianyobra.bramcode.main.DrawerItemCustomAdapter;
import brianyobra.bramcode.main.MainActivity;
import brianyobra.bramcode.main.R;
import brianyobra.bramcode.main.fragment.fragment_one.fragment_one;
import brianyobra.bramcode.main.fragment.fragment_two.fragment_two;


public class ActivityFour extends AppCompatActivity {


    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);

        TextView title = (TextView) findViewById(R.id.activityTitle2);
        title.setText("Messages");

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent a = new Intent(ActivityFour.this, MainActivity.class);
                        startActivity(a);

                        break;
                    case R.id.navigation_dashboard:
                        Intent b = new Intent(ActivityFour.this, ActivityOne.class);
                        startActivity(b);

                        break;
                    case R.id.navigation_notifications:
                        Intent c = new Intent(ActivityFour.this, ActivityTwo.class);
                        startActivity(c);
                        break;

                    case R.id.navigation_Disc:
                        Intent d = new Intent(ActivityFour.this,ActivityThree.class);
                        startActivity(d);
                        break;

                    case R.id.navigation_me:
                        break;





                }
                return false;
            }
        });

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[12];

        drawerItem[0] = new DataModel(R.drawable.ic_launcher_round, "PERSONS NAME");
        drawerItem[1] = new DataModel(R.drawable.connect, "Home");
        drawerItem[2] = new DataModel(R.drawable.fixtures, "Profile");
        drawerItem[3] = new DataModel(R.drawable.connect, "Contact Directory");
        drawerItem[4] = new DataModel(R.drawable.fixtures, "Report");
        drawerItem[5] = new DataModel(R.drawable.connect, "Bill");
        drawerItem[6] = new DataModel(R.drawable.fixtures, "TransActions/Payments");
        drawerItem[7] = new DataModel(R.drawable.connect, "Services");
        drawerItem[8] = new DataModel(R.drawable.fixtures, "Sugestion Box");
        drawerItem[9] = new DataModel(R.drawable.fixtures, "Forum Posts");
        drawerItem[10] = new DataModel(R.drawable.connect, "Feed Back");
        drawerItem[11] = new DataModel(R.drawable.fixtures, "Sync");


        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdapter adapter = new DrawerItemCustomAdapter(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();


    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 1:
                fragment = new fragment_one();
                break;
            case 2:
                fragment = new fragment_two();
                break;
            default:

        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }


    }
    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

}