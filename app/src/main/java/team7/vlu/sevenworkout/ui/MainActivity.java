package team7.vlu.sevenworkout.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.os.Bundle;


import com.google.android.material.tabs.TabLayout;

import team7.vlu.sevenworkout.AdvanceFragement;
import team7.vlu.sevenworkout.HomeFragement;
import team7.vlu.sevenworkout.StatisticFragement;
import team7.vlu.sevenworkout.R;
import team7.vlu.sevenworkout.ViewPaperAdapter;
import team7.vlu.sevenworkout.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ViewPager mViewpaper;
    private ViewPaperAdapter mVadapter;
    private TabLayout tabLayout;

    //toolbarDraw

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mViewpaper = (ViewPager) findViewById(R.id.view_paper);
        mVadapter = new ViewPaperAdapter(getSupportFragmentManager());
        tabLayout = (TabLayout) findViewById(R.id.tablayout_id);

        mVadapter.AddFragment(new HomeFragement(), "Home");
        mVadapter.AddFragment(new StatisticFragement(), "Statistics");
        mVadapter.AddFragment(new AdvanceFragement(), "Reminder");
        mViewpaper.setAdapter(mVadapter);
        tabLayout.setupWithViewPager(mViewpaper);

        //bar


    }


}