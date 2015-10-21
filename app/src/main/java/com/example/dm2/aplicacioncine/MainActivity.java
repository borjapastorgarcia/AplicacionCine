package com.example.dm2.aplicacioncine;


import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity  implements Cartelera.OnFragmentInteractionListener, Ajustes.OnFragmentInteractionListener,Favoritos.OnFragmentInteractionListener,Proximamente.OnFragmentInteractionListener{
    DrawerLayout drawerLayout;
    NavigationView navview;
    MenuItem item;
    Toolbar appBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    //http://www.hermosaprogramacion.com/2015/07/como-sincronizar-sqlite-con-mysql-en-android/
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=(DrawerLayout)findViewById(R.id.drawer_layout);
        navview=(NavigationView)findViewById(R.id.navview);
        navview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                boolean fragmentTransaction=false;
                Fragment fragment=null;
                switch (menuItem.getItemId()){
                    case R.id.menu_seccion_1:
                        fragment=new Cartelera();
                        fragmentTransaction=true;
                        break;
                    case R.id.menu_seccion_2:
                        fragment=new Proximamente();
                        fragmentTransaction=true;
                        break;
                    case R.id.menu_seccion_3:
                        fragment=new Favoritos();
                        fragmentTransaction=true;
                        break;
                    case R.id.menu_seccion_4:
                        fragment=new Ajustes();
                        fragmentTransaction=true;
                        break;
                }
                if(fragmentTransaction){
                    getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,fragment).commit();
                    menuItem.setChecked(true);
                    getSupportActionBar().setTitle(menuItem.getTitle());
                    drawerLayout.closeDrawer(GravityCompat.START);
                }

                return true;
            }
        });
         appBar= (Toolbar) findViewById(R.id.appbar);
        setSupportActionBar(appBar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        this.item=item;
        int id = item.getItemId();
        switch (id){
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
        }
        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
