package com.example.navigationbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Switch;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView;

    DrawerLayout drawerLayout;

    ActionBarDrawerToggle toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationView=findViewById(R.id.navigation);
        drawerLayout=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(MainActivity.this,drawerLayout,R.string.open,R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);




    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){

            case R.id.add:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new add()).commit();
                break;

            case R.id.update:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new update()).commit();
                break;

            case R.id.delete:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new delete()).commit();
                break;

            case R.id.view:
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new view()).commit();
                break;
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;

    }


}
