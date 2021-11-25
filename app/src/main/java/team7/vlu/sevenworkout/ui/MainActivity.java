package team7.vlu.sevenworkout.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlarmManager;
import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import team7.vlu.sevenworkout.ReminderFragement;
import team7.vlu.sevenworkout.HomeFragement;
import team7.vlu.sevenworkout.WeeklyFragement;
import team7.vlu.sevenworkout.R;
import team7.vlu.sevenworkout.ViewPaperAdapter;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewpaper;
    private ViewPaperAdapter mVadapter;
    private TabLayout tabLayout;
    private AlarmManager alarmManager;

    //toolbarDraw

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


    }


}