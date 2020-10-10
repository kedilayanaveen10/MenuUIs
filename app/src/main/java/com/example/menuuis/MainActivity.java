package com.example.menuuis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private Intent menuIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    public void openMenu1(View view)
    {
        menuIntent = new Intent(this,Menu1.class);
        startActivity(menuIntent);
    }

    public void openMenu2(View view)
    {
        menuIntent = new Intent(this,Menu2.class);
        startActivity(menuIntent);
    }

    public void openMenu3(View view)
    {
        menuIntent = new Intent(this,Menu3.class);
        startActivity(menuIntent);
    }

    public void openMenu4(View view)
    {

    }

    public void openMenu5(View view)
    {

    }

    public void openMenu6(View view)
    {

    }

    public void openMenu7(View view)
    {

    }

    public void openMenu8(View view)
    {

    }
}