package com.ulan.timetable.Activities;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.preference.PreferenceManager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import com.ulan.timetable.Adapters.FragmentsTabAdapter;
import com.ulan.timetable.Adapters.NotesAdapter;
import com.ulan.timetable.Fragments.FridayFragment;
import com.ulan.timetable.Fragments.FridayWeekFragment;
import com.ulan.timetable.Fragments.MondayFragment;
import com.ulan.timetable.Fragments.MondayWeekFragment;
import com.ulan.timetable.Fragments.SaturdayFragment;
import com.ulan.timetable.Fragments.SaturdayWeekFragment;
import com.ulan.timetable.Fragments.SundayFragment;
import com.ulan.timetable.Fragments.SundayWeekFragment;
import com.ulan.timetable.Fragments.ThursdayFragment;
import com.ulan.timetable.Fragments.ThursdayWeekFragment;
import com.ulan.timetable.Fragments.TuesdayFragment;
import com.ulan.timetable.Fragments.TuesdayWeekFragment;
import com.ulan.timetable.Fragments.WednesdayFragment;
import com.ulan.timetable.Fragments.WednesdayWeekFragment;
import com.ulan.timetable.R;
import com.ulan.timetable.Utils.AlertDialogsHelper;
import com.ulan.timetable.Utils.DbHelper;

import java.util.Calendar;

/**
 * Created by Admin on 12/08/2018.
 */

public class WeekActivity extends AppCompatActivity {
    private FragmentsTabAdapter adapter2;
    private FragmentsTabAdapter adapter3;
    private FragmentsTabAdapter adapter4;
    private FragmentsTabAdapter adapter5;
    private FragmentsTabAdapter adapter6;
    private FragmentsTabAdapter adapter7;
    private FragmentsTabAdapter adapterCN;

    private ViewPager viewPager2;
    private ViewPager viewPager3;
    private ViewPager viewPager4;
    private ViewPager viewPager5;
    private ViewPager viewPager6;
    private ViewPager viewPager7;
    private ViewPager viewPagerCN;


    //private boolean switchSevenDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week2);
        initAll();
    }

    private void initAll() {
       // NavigationView navigationView = findViewById(R.id.nav_view);
       // navigationView.setNavigationItemSelectedListener(this);
        PreferenceManager.setDefaultValues(this, R.xml.settings, false);
/*
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
*/

        setupFragments();
        setupCustomDialog();
        //if(switchSevenDays) changeFragments(true);
    }

    private void setupFragments() {
        adapter2 = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager2 = findViewById(R.id.viewPager2);
        adapter3 = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager3 = findViewById(R.id.viewPager3);
        adapter4 = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager4 = findViewById(R.id.viewPager4);
        adapter5 = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager5 = findViewById(R.id.viewPager5);
        adapter6 = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager6 = findViewById(R.id.viewPager6);
        adapter7 = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPager7 = findViewById(R.id.viewPager7);
        adapterCN = new FragmentsTabAdapter(getSupportFragmentManager());
        viewPagerCN = findViewById(R.id.viewPagerCN);

        //TabLayout tabLayout = findViewById(R.id.tabLayout);
        //Calendar calendar = Calendar.getInstance();
        //int day = 7;
        adapter2.addFragment(new MondayWeekFragment(), getResources().getString(R.string.monday));
        adapter3.addFragment(new TuesdayWeekFragment(), getResources().getString(R.string.tuesday));
        adapter4.addFragment(new WednesdayWeekFragment(), getResources().getString(R.string.wednesday));
        adapter5.addFragment(new ThursdayWeekFragment(), getResources().getString(R.string.thursday));
        adapter6.addFragment(new FridayWeekFragment(), getResources().getString(R.string.friday));
        adapter7.addFragment(new SaturdayWeekFragment(), getResources().getString(R.string.saturday));
        adapterCN.addFragment(new SundayWeekFragment(), getResources().getString(R.string.sunday));
        viewPager2.setAdapter(adapter2);
        viewPager3.setAdapter(adapter3);
        viewPager4.setAdapter(adapter4);
        viewPager5.setAdapter(adapter5);
        viewPager6.setAdapter(adapter6);
        viewPager7.setAdapter(adapter7);
        viewPagerCN.setAdapter(adapterCN);

        //viewPager2.setCurrentItem(day == 1 ? 6 : day-2, true);
        //tabLayout.setupWithViewPager(viewPager2);
    }
    private void setupCustomDialog() {
        final View alertLayout = getLayoutInflater().inflate(R.layout.dialog_add_subject, null);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapter2, viewPager2);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapter3, viewPager3);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapter4, viewPager4);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapter5, viewPager5);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapter6, viewPager6);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapter7, viewPager7);
        AlertDialogsHelper.getAddSubjectDialog(WeekActivity.this, alertLayout, adapterCN, viewPagerCN);

    }
}