package com.example.menuuis;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.menuuis.ui.main.SectionsPagerAdapter;

public class Menu7 extends AppCompatActivity {

    private int currentTab;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu7);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        final ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = findViewById(R.id.fab);
        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        this.setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        tabs.setOnTabSelectedListener(
                new TabLayout.OnTabSelectedListener()
                {
                    @Override
                    public void onTabSelected(TabLayout.Tab tab)
                    {
                        viewPager.setCurrentItem(tab.getPosition());
                        currentTab = tab.getPosition();
                        invalidateOptionsMenu();
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {

                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {

                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.tab_menu1, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        // TODO Auto-generated method stub
        MenuInflater inflater = getMenuInflater();

        Toast.makeText(getApplicationContext(), currentTab+"", Toast.LENGTH_SHORT);
        menu.clear();
        if (currentTab == 0)
        {
            inflater.inflate(R.menu.tab_menu1, menu);
        }
        else {
            inflater.inflate(R.menu.tab_menu2, menu);
        }
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id){
            case R.id.user:
                Toast.makeText(getApplicationContext(),"User Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.videocam:
                Toast.makeText(getApplicationContext(),"VideoCam Selected",Toast.LENGTH_SHORT).show();
                return true;
            case R.id.favourite:
                Toast.makeText(getApplicationContext(),"Favourite selected", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.delete:
                Toast.makeText(getApplicationContext(),"Delete selected",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}