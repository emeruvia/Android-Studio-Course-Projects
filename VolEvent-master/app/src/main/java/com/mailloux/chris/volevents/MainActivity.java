package com.mailloux.chris.volevents;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity
{
    // TODO: Disable using back button to go back to LoginActivity

    private DrawerLayout drawerLayout;
    private ListView drawerList;

    private String[] navDrawerItemNames;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeNavDrawerItemNames();
        initializeUiComponentReferences();
        // TODO: Change simple list item 1 to more customized layout if needed.
        drawerList.setAdapter(
            new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                navDrawerItemNames
            )
        );
        drawerList.setOnItemClickListener(new DrawerItemClickListener());
        drawerList.setItemChecked(0, true);
    }

    private void initializeNavDrawerItemNames()
    {
        // TODO: Come up with better way to initialize item names

        navDrawerItemNames = getResources().getStringArray(
            R.array.nav_drawer_menu_items
        );
    }

    private void initializeUiComponentReferences()
    {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.nav_drawer);
    }

    private void selectItem(int position)
    {
        switch(position)
        {
            case 0:
                // TODO: Implement
                break;
            case 1:
                // TODO: Implement
                break;
            case 2:
                // TODO: Implement
                break;
        }
        drawerList.setItemChecked(position, true);
        setTitle(navDrawerItemNames[position]);
        drawerLayout.closeDrawer(drawerList);
    }

    @Override
    public void setTitle(CharSequence title)
    {
        getSupportActionBar().setTitle(title);
    }

    private class DrawerItemClickListener
        implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(
            AdapterView<?> parent, View view, int position, long id
        )
        {
            selectItem(position);
        }
    }
}
