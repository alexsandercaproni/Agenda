package com.example.alexsandercaproni.unlock4forgotten;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.control.FragmentCommunicatorPortaFechada;
import com.control.ThingSpeakPorta;
import com.control.ThingSpeakPortaFechada;
import com.control.ThingSpeakSistema;
import com.fragments.TabPagerAdapter;
import com.control.FragmentCommunicatorPorta;
import com.control.FragmentCommunicatorSistema;
import com.model.AboutSection;

public class MainActivity extends AppCompatActivity {

    ThingSpeakPorta thingSpeakPorta;
    ThingSpeakSistema thingSpeakSistema;
    ThingSpeakPortaFechada thingSpeakPortaFechada;

    FragmentCommunicatorPorta fragmentCommunicatorPorta;
    FragmentCommunicatorSistema fragmentCommunicatorSistema;
    FragmentCommunicatorPortaFechada fragmentCommunicatorPortaFechada;

    Button buttonAbrir;
    Button buttonDesligar;
    Button buttonFechar;

    boolean clickAbrir = false;
    boolean clickDesligar = false;
    boolean clickFechar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        thingSpeakPorta = new ThingSpeakPorta();
        thingSpeakSistema = new ThingSpeakSistema();
        thingSpeakPortaFechada = new ThingSpeakPortaFechada();

        buttonAbrir = (Button) findViewById(R.id.buttonAbrir);
        buttonDesligar = (Button) findViewById(R.id.buttonDesligar);
        buttonFechar = (Button) findViewById(R.id.buttonFechar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuItem menuItem = menu.add(0, 0, 0, "Sobre");
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);

        MenuItem menuItem1 = menu.add(1, 1, 1, "Sair");
        menuItem1.setShowAsAction(MenuItem.SHOW_AS_ACTION_NEVER);


        // Tabs
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        TabPagerAdapter adapter = new TabPagerAdapter(getSupportFragmentManager());

        pager.setAdapter(adapter);
        tabs.setupWithViewPager(pager);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 0: {
                Intent intent = new Intent(this, AboutSection.class);
                startActivity(intent);
                return true;
            }

            case 1:{
                finish();
                return true;
            }

            default:
                return true;
        }

    }

    public void abrirPorta(View view) {
        clickFechar = false;
        if (clickAbrir == false) {
            thingSpeakPorta.startTarefa();
            Toast.makeText(this, "Porta aberta", Toast.LENGTH_SHORT).show();
            fragmentCommunicatorPorta.changeText("Porta atualmente aberta");
            fragmentCommunicatorPorta.changeIV(R.drawable.door_opened);
        }

        else{
            Toast.makeText(this, "Porta já esta aberta", Toast.LENGTH_SHORT).show();
        }

        clickAbrir = true;
    }

    public void fecharPorta(View view){
        clickAbrir = false;
        if (clickFechar == false) {
            thingSpeakPortaFechada.startTarefa();
            Toast.makeText(this, "Porta Fechada", Toast.LENGTH_SHORT).show();
            fragmentCommunicatorPortaFechada.changeText("Porta atualmente fechada");
            fragmentCommunicatorPortaFechada.changeIV(R.drawable.door_closed);
        }

        else{
            Toast.makeText(this, "Porta já esta fechada", Toast.LENGTH_SHORT).show();
        }

        clickFechar = true;
    }


    public void desligarSistema(View view){
        if (clickDesligar == false){
            thingSpeakSistema.startTarefaSistema();
            Toast.makeText(this, "Sistema Desligado", Toast.LENGTH_SHORT).show();
            fragmentCommunicatorSistema.changeText("Sistema desativado");
            fragmentCommunicatorSistema.changeIV(R.drawable.sistema_desligado);
        }

        else{
            Toast.makeText(this, "Sistema já se encontra desligado", Toast.LENGTH_SHORT).show();
        }

        clickDesligar = true;
    }

    public void passVal(FragmentCommunicatorPorta fragmentCommunicatorPorta) {
        this.fragmentCommunicatorPorta = fragmentCommunicatorPorta;

    }

    public void passVal(FragmentCommunicatorSistema fragmentCommunicatorSistema) {
        this.fragmentCommunicatorSistema = fragmentCommunicatorSistema;

    }

    public void passVal(FragmentCommunicatorPortaFechada fragmentCommunicatorPortaFechada) {
        this.fragmentCommunicatorPortaFechada = fragmentCommunicatorPortaFechada;

    }



}
