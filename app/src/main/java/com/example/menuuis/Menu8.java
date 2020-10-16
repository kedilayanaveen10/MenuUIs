package com.example.menuuis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

public class Menu8 extends AppCompatActivity
{
    private ListView listView;

    void printMsg(String s)
    {
        Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu8);

        listView = (ListView)findViewById(R.id.listView8);
        listView.setMultiChoiceModeListener(
                new AbsListView.MultiChoiceModeListener()
                {
                    private int count = 0;
                    @Override
                    public void onItemCheckedStateChanged(ActionMode mode, int position, long id, boolean checked)
                    {
                        if(checked)
                            count++;
                        else
                            count--;
                        mode.setTitle(count + " selected");
                    }

                    @Override
                    public boolean onCreateActionMode(ActionMode mode, Menu menu)
                    {
                        count = 0;
                        MenuInflater inflater = getMenuInflater();
                        inflater.inflate(R.menu.tab_menu2,menu);
                        return true;
                    }

                    @Override
                    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                        return false;
                    }

                    @Override
                    public boolean onActionItemClicked(ActionMode mode, MenuItem item)
                    {
                        switch (item.getItemId())
                        {
                            case R.id.delete:
                                printMsg("Deleted");
                                listView.clearChoices();
                                mode.finish();
                                return true;

                            case R.id.favourite:
                                printMsg("Added to favourites");
                                listView.clearChoices();
                                mode.finish();
                                return true;

                            default:
                                mode.finish();
                        }
                        return true;
                    }

                    @Override
                    public void onDestroyActionMode(ActionMode mode) {

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
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();
        switch (id){
            case R.id.user:
                printMsg("User selected");
                return true;
            case R.id.videocam:
                printMsg("VideoCam selected");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}