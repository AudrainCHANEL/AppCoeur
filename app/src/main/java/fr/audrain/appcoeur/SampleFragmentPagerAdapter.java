package fr.audrain.appcoeur;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class SampleFragmentPagerAdapter extends FragmentPagerAdapter{
    final int PAGE_COUNT = 3;
    private Integer[] tabTitles = new Integer[] {R.string.my_heart, R.string.my_cardiac_monitoring, R.string.my_nutrition};
    private Context context;
    private AppCompatActivity activity;

    public SampleFragmentPagerAdapter(FragmentManager fm, Context context, AppCompatActivity activity) {
        super(fm);
        this.context = context;
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public Fragment getItem(int position) {
        Person user = activity.getIntent().getParcelableExtra("profil");
        if (position==0)
        {
            return BilanHeartFragment.newInstance(position + 1, user);
        }
        else if (position==1)
        {
            return BilanMonitoringFragment.newInstance(position + 1, user);
        }
        else
        {
            return BilanNutritionFragment.newInstance(position + 1, user);
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return activity.getString(tabTitles[position]);
    }
}
