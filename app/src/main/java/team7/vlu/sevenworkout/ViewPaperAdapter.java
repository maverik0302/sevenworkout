package team7.vlu.sevenworkout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPaperAdapter extends FragmentPagerAdapter {
    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> listTiles = new ArrayList<>();
    public ViewPaperAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }



    @Override
    public int getCount() {
        return listTiles.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return listTiles.get(position);
    }

    public void AddFragment (Fragment fragment, String title){
        fragmentList.add(fragment);
        listTiles.add(title);
    }
}
