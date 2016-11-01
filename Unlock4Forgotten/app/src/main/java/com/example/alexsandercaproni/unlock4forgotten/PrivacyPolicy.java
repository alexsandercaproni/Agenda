package com.example.alexsandercaproni.unlock4forgotten;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class PrivacyPolicy extends AppCompatActivity {

    public boolean flagRecusar = true;

    public PrivacyPolicy() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_policy);
    }

    public void buttonAceitar(View view){
        finish();
        flagRecusar = false;
    }

    public void buttonCancelar(View view){

        if(flagRecusar){
            Toast.makeText(this, "É necessário aceitar os termos de uso do aplicativo", Toast.LENGTH_SHORT).show();
        }

        else {
            finish();
        }

    }

}
