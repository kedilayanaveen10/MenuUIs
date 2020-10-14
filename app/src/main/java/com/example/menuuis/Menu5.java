package com.example.menuuis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

public class Menu5 extends AppCompatActivity
{
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu5);

        button = (Button)findViewById(R.id.button);

    }

    public void onClick(View view)
    {
        PopupMenu popupMenu = new PopupMenu(this,button);
        popupMenu.getMenuInflater().inflate(R.menu.option_menu, popupMenu.getMenu());

        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener()
                {
                    @Override
                    public boolean onMenuItemClick(MenuItem item)
                    {
                        Toast.makeText(Menu5.this,"You clicked: " + item.getTitle(),Toast.LENGTH_SHORT).show();
                        return true;
                    }
                }
        );

        popupMenu.show();
    }
}