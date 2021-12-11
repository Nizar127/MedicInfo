package com.doctor.medicinfo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.doctor.medicinfo.Patient_condition.HomeActivity;
import com.doctor.medicinfo.Task.FragmentAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import org.jetbrains.annotations.NotNull;

public class TaskActivity extends AppCompatActivity {

    BottomNavigationView bottomtabmenu;
    TabLayout tabLayout;
    ViewPager2 viewPager;
    FragmentAdapter adapter;
    //String[] items = {"Past","Ongoing","Future"};

    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewpager_line);

//        autoCompleteTextView = findViewById(R.id.taskData);
//
//        adapterItem = new ArrayAdapter<String>(this, R.layout.list_item_task);
//
//        autoCompleteTextView.setAdapter(adapterItem);
//        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String item = parent.getItemAtPosition(position).toString();
//                Toast.makeText(getApplicationContext(), "Item: "+item,Toast.LENGTH_SHORT).show();
//            }
//        });



       FragmentManager fm = getSupportFragmentManager();
       adapter = new FragmentAdapter(fm, getLifecycle());
       viewPager.setAdapter(adapter);

       tabLayout.addTab(tabLayout.newTab().setText("Past"));
       tabLayout.addTab(tabLayout.newTab().setText("Ongoing"));
       tabLayout.addTab(tabLayout.newTab().setText("Future"));

       tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
           @Override
           public void onTabSelected(TabLayout.Tab tab) {
               viewPager.setCurrentItem(tab.getPosition());
           }

           @Override
           public void onTabUnselected(TabLayout.Tab tab) {

           }

           @Override
           public void onTabReselected(TabLayout.Tab tab) {

           }
       });

       viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
           @Override
           public void onPageSelected(int position) {
               tabLayout.selectTab(tabLayout.getTabAt(position));
           }
       });

        bottomtabmenu = findViewById(R.id.bottom_navigation);
        bottomtabmenu.setSelectedItemId(R.id.patientCond);

        bottomtabmenu.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.patientCond:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.profileID:
                        startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.task:
                        return true;
                }
                return false;
            }
        });
    }
}