package com.example.ruan.appcursos;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ruan.appcursos.fragmentos.BemVindoFragmento;
import com.example.ruan.appcursos.fragmentos.DesenvolvedorFragmento;
import com.example.ruan.appcursos.interfaces.IFragmentos;

/*
* Fragmentos em 4 passos:
*   https://www.androidpro.com.br/blog/desenvolvimento-android/fragments/
*
* Outro post:
*   http://www.botecodigital.info/android/trabalhando-com-android-fragments/
*
* Para trabalhar com webservices é necessário utilizar a extensão Volley do android, adicionando
* nas dependências.
*
* Existem outros tipos de layouts, como o ViewPage (muda de tela ou fragmento com arraste lateral),
* e LayoutComposto (inclui todos os recursos de layout, guias de navegação, etc)
* */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, IFragmentos {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        ///
        Fragment fragmentoBemVindo = new BemVindoFragmento();
        getSupportFragmentManager().beginTransaction().replace(R.id.view_content_main, fragmentoBemVindo).commit();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            // Handle the camera action
        } else if (id == R.id.nav_registro) {

        } else if (id == R.id.nav_consulta) {

        } else if (id == R.id.nav_consulta_url) {

        } else if (id == R.id.nav_consulta_lista) {

        } else if (id == R.id.nav_consulta_cursos_img) {

        } else if (id == R.id.nav_consulta_img_url) {

        } else if (id == R.id.nav_desenvolvedor) {
            Fragment fragmentoDesenvolvedor = new DesenvolvedorFragmento();
            getSupportFragmentManager().beginTransaction().replace(R.id.view_content_main, fragmentoDesenvolvedor).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
