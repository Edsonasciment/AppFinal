package com.mt.tecinfo.finalapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView nome = (TextView) findViewById(R.id.text_NOME);
        final TextView email = (TextView) findViewById(R.id.text_email);
        final TextView cidade = (TextView) findViewById(R.id.text_cidade);
        final TextView estado = (TextView) findViewById(R.id.text_estado);
        final TextView endereco = (TextView) findViewById(R.id.text_end);
        final TextView pais = (TextView) findViewById(R.id.text_pais);

        SharedPreferences meusDados = getSharedPreferences("call", Context.MODE_PRIVATE);

        String tnome = meusDados.getString("nome","");
        String tcidade = meusDados.getString("cidade","");
        String testado = meusDados.getString("estado","");
        String temail = meusDados.getString("email","");
        String tend = meusDados.getString("end","");
        String tpais = meusDados.getString("pais", "");

        nome.setText(tnome);
        email.setText(temail);
        cidade.setText(tcidade);
        estado.setText(testado);
        endereco.setText(tend);
        pais.setText(tpais);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if(drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Ota Configuração", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.configuracoes) {
            Toast.makeText(getApplicationContext(), "Abrir Configurações", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.chamadaFalsa) {
            Intent intent = new Intent(MainActivity.this, ActivityChamada.class);
            startActivity(intent);
        } else if (id == R.id.calculadora) {
            Intent intent = new Intent(MainActivity.this, ActivityCalculadora.class);
            startActivity(intent);
        } else if (id == R.id.calcularMedia) {
            Intent intent = new Intent(MainActivity.this, ActivityMedia.class);
            startActivity(intent);
        }

        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
