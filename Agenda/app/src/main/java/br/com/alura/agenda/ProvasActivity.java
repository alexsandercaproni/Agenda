package br.com.alura.agenda;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class ProvasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_provas);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction tx = fragmentManager.beginTransaction();
        tx.replace(R.id.frame_principal, new ListaProvasFragment());
        if(isModoPaisagem()){
            tx.replace(R.id.frame_secundario, new DetalhesProvaFragment());
        }
        tx.commit();
    }

    private boolean isModoPaisagem() {
        return getResources().getBoolean(R.bool.modoPaisagem);
    }
}
