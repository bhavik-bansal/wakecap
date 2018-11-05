package com.booko.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.booko.R;
import com.booko.fragments.HomeFragment;
import com.booko.fragments.MoreFragment;
import com.booko.utils.AppLog;
import com.booko.utils.Constants;
import com.booko.viewmodel.HomeViewModel;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    AHBottomNavigation ahBottomNavigation;
    private Fragment mCurrentFragment;
    private ArrayList<Fragment> mFragments = new ArrayList<>();

    public static final int VENDOR_FRAGMENT = 0;
    public static final int PLAN_FRAGMENT = 1;
    public static final int HIRE_FRAGMENT = 2;
    public static final int USER_PROFILE_FRAGMENT = 3;
    public static final int MORE_FRAGMENT = 4;


    private int CURRENT_TAB = VENDOR_FRAGMENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setToolbar(getString(R.string.city_name),false);
        ahBottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        setBottomNavigations();
        new HomeViewModel().checkApi();
    }

    private void setBottomNavigations() {
        try {
            HomeFragment homeFragment = new HomeFragment();
            MoreFragment planFragment = new MoreFragment();
            MoreFragment hireFragment = new MoreFragment();
            MoreFragment userFragment = new MoreFragment();
            MoreFragment moreFragment = new MoreFragment();


            mFragments.add(VENDOR_FRAGMENT, homeFragment);
            mFragments.add(PLAN_FRAGMENT, planFragment);
            mFragments.add(HIRE_FRAGMENT, hireFragment);
            mFragments.add(USER_PROFILE_FRAGMENT, userFragment);
            mFragments.add(MORE_FRAGMENT, moreFragment);

            for (int position = 0; position < getResources().getStringArray(R.array.bottom_navigation_titles).length; position++) {
                String title = getResources().getStringArray(R.array.bottom_navigation_titles)[position];
                int icon = getResources().obtainTypedArray(R.array.bottom_navigation_icons_inactive).getResourceId(position, 0);
                AHBottomNavigationItem item = new AHBottomNavigationItem(title, ContextCompat.getDrawable(this, icon), ContextCompat.getColor(this, R.color.white));
                ahBottomNavigation.addItem(item);
            }

            loadConfigurations();

            // Remove fragments
            for (Fragment fragment : getSupportFragmentManager().getFragments()) {
                if (fragment != null)
                    getSupportFragmentManager().beginTransaction().remove(fragment).commitAllowingStateLoss();
            }
            //add fragments
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_fragment, mFragments.get(VENDOR_FRAGMENT), String.valueOf(VENDOR_FRAGMENT)).hide(mFragments.get(VENDOR_FRAGMENT)).commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_fragment, mFragments.get(PLAN_FRAGMENT), String.valueOf(PLAN_FRAGMENT)).hide(mFragments.get(PLAN_FRAGMENT)).commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_fragment, mFragments.get(HIRE_FRAGMENT), String.valueOf(HIRE_FRAGMENT)).hide(mFragments.get(HIRE_FRAGMENT)).commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_fragment, mFragments.get(USER_PROFILE_FRAGMENT), String.valueOf(USER_PROFILE_FRAGMENT)).hide(mFragments.get(USER_PROFILE_FRAGMENT)).commitAllowingStateLoss();
            getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_fragment, mFragments.get(MORE_FRAGMENT), String.valueOf(MORE_FRAGMENT)).hide(mFragments.get(MORE_FRAGMENT)).commitAllowingStateLoss();

            CURRENT_TAB = getIntent().getIntExtra(Constants.INTENT_FRAGMENT_INDEX, VENDOR_FRAGMENT);
            mCurrentFragment = mFragments.get(CURRENT_TAB);
            selectTab(CURRENT_TAB);
            ahBottomNavigation.setCurrentItem(CURRENT_TAB);


            ahBottomNavigation.setOnTabSelectedListener((position, wasSelected) -> {
                selectTab(position);
                return true;
            });
        } catch (IllegalArgumentException e) {
            AppLog.d(TAG,e.getMessage());
        }
    }
    public void loadConfigurations() {
        ahBottomNavigation.setAccentColor(getResources().getColor(R.color.black_70));
        ahBottomNavigation.setInactiveColor(getResources().getColor(R.color.black_70));
        ahBottomNavigation.setBehaviorTranslationEnabled(false);
        ahBottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.toolbar));
        ahBottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW);
    }

    void selectTab(int position) {
        getSupportFragmentManager().beginTransaction().hide(mCurrentFragment).show(mFragments.get(position)).commitAllowingStateLoss();
        AHBottomNavigationItem currentItem = ahBottomNavigation.getItem(CURRENT_TAB);
        int icon = getResources().obtainTypedArray(R.array.bottom_navigation_icons_inactive).getResourceId(CURRENT_TAB, 0);
        currentItem.setDrawable(icon);

        AHBottomNavigationItem selectedItem = ahBottomNavigation.getItem(position);
        icon = getResources().obtainTypedArray(R.array.bottom_navigation_icons_active).getResourceId(position, 0);
        selectedItem.setDrawable(icon);

        String title = getResources().getStringArray(R.array.toolbar_titles)[position];
        getToolbar().setTitle(title);
        CURRENT_TAB = position;
        mCurrentFragment = mFragments.get(position);
    }

}
