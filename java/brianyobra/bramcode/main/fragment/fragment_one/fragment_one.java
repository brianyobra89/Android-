package brianyobra.bramcode.main.fragment.fragment_one;


import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import brianyobra.bramcode.main.R;


import brianyobra.bramcode.main.activities.ActivityThree;


import brianyobra.bramcode.main.fragment.fragment_two.fragment_two;



public class fragment_one extends Fragment {




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);



        ViewPager vp_pages= (ViewPager) rootView.findViewById(R.id.vp_pages);



        BottomNavigationView navigation = (BottomNavigationView) rootView.findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        Intent a = new Intent(fragment_one.this.getContext(), fragment_one.class);
                        startActivity(a);
                        break;
                    case R.id.navigation_dashboard:
                        Intent b = new Intent(fragment_one.this.getContext(), fragment_two.class);
                        startActivity(b);
                        break;
                 //   case R.id.navigation_notifications:
                       // Intent c = new Intent(fragment_one.this,  ProfileActivity.class);
                       // startActivity(c);
                      //  break;

                    case R.id.navigation_me:
                        Intent d = new Intent(fragment_one.this.getContext(), ActivityThree.class);
                        startActivity(d);
                        break;
                }
                return false;
            }
        });

        return rootView;





       // Toolbar toolbar = findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);


    }





}


