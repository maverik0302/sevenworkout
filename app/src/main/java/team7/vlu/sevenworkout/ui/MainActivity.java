package team7.vlu.sevenworkout.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import android.app.AlarmManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;


import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import team7.vlu.sevenworkout.ReminderFragement;
import team7.vlu.sevenworkout.HomeFragement;
import team7.vlu.sevenworkout.ReportActivity;
import team7.vlu.sevenworkout.WeeklyFragement;
import team7.vlu.sevenworkout.R;
import team7.vlu.sevenworkout.ViewPaperAdapter;
import team7.vlu.sevenworkout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewpaper;
    private ViewPaperAdapter mVadapter;
    private TabLayout tabLayout;
    private AlarmManager alarmManager;



    //toolbarDraw
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mViewpaper = (ViewPager) findViewById(R.id.view_paper);
        mVadapter = new ViewPaperAdapter(getSupportFragmentManager());

        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);

        mVadapter.AddFragment(new HomeFragement(), "Home");
        mVadapter.AddFragment(new WeeklyFragement(), "Weekly");
        mVadapter.AddFragment(new ReminderFragement(), "Reminder");
        mViewpaper.setAdapter(mVadapter);

        tabLayout.setupWithViewPager(mViewpaper);

        //bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        //Click Optionmenu
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.item_plan:
                        onBackPressed();
                        return true;
                    case R.id.item_discover:
                    case R.id.item_report:
                        Intent intent = new Intent(MainActivity.this, ReportActivity.class);
                        startActivity(intent);
                        return true;

                }
                return false;
            }
        });



    }

    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

    }


}