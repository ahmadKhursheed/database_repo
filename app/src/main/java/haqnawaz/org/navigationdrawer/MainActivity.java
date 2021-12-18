package haqnawaz.org.navigationdrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigation;
    DrawerLayout drawer;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(),"Start",Toast.LENGTH_LONG).show();

        }
        else
        {
            Toast.makeText(getApplicationContext(),"End",Toast.LENGTH_LONG).show();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigation=findViewById(R.id.nav_view);
        drawer=findViewById(R.id.drawer);

        toggle=new ActionBarDrawerToggle(this,drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem)
            {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_book :
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, BookActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_return :
                        Toast.makeText(getApplicationContext(),"Retur is Clicked",Toast.LENGTH_LONG).show();
                        break;

                    case R.id.nav_laptop :
                        Toast.makeText(getApplicationContext(),"Laptop is clicked",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_voice :
                        Toast.makeText(getApplicationContext(),"Voice is clicked",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.nav_chrome_reader :
                        Toast.makeText(getApplicationContext(),"Chrome Reader is clicked",Toast.LENGTH_LONG).show();
                        drawer.closeDrawer(GravityCompat.START);
                        break;
                }
                return true;
            }
        });
    }
}