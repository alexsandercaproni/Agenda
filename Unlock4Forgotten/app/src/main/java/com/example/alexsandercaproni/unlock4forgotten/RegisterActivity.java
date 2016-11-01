package com.example.alexsandercaproni.unlock4forgotten;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.dao.banco.UsuarioDAO;
import com.model.Usuario;

import java.sql.SQLException;

public class RegisterActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextSenha;
    EditText editTextConfirmaSenha;
    EditText editTextEmail;

    CheckBox checkBoxPrivacity;

    UsuarioDAO usuarioDAO;

    MainActivity ma;
    PrivacyPolicy privacyPolicy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        ma = new MainActivity();
        ma.finish();

        usuarioDAO = new UsuarioDAO(this);

        editTextNome = (EditText) findViewById(R.id.input_nome);
        editTextSenha = (EditText) findViewById(R.id.input_senha);
        editTextConfirmaSenha = (EditText) findViewById(R.id.input_confirm_senha);
        editTextEmail = (EditText) findViewById(R.id.input_email);

        checkBoxPrivacity = (CheckBox) findViewById(R.id.checkboxPrivacity);


    }


    public void signUp(View view){

        String nome = "";
        String senha = "";
        String confirmaSenha = "";
        String email = "";

        nome = editTextNome.getText().toString();
        senha = editTextSenha.getText().toString();
        confirmaSenha = editTextConfirmaSenha.getText().toString();
        email = editTextEmail.getText().toString();

        //Cria o contato
        Usuario usuario = new Usuario(nome, senha, email);

        //Abre a conexão com o banco de dados
        try {
            usuarioDAO.open();
        } catch (SQLException e) {
            e.printStackTrace();
        }



        //Salva o contato
        usuarioDAO.novoUsuario(usuario);

        //Fecha a conexão com o banco de dados
        usuarioDAO.close();

        requisitosObrigatorios(nome, senha, confirmaSenha, email);

    }

    public void requisitosObrigatorios(String nome, String senha, String confirmaSenha, String email){

        int aux = 0;

        if(nome.isEmpty()){
            editTextNome.setError(getString(R.string.error_empty_name));
            aux++;
        }

        if (senha.isEmpty()){
            editTextSenha.setError(getString(R.string.error_empty_senha));
            aux++;
        }

        if(confirmaSenha.isEmpty()){
            editTextConfirmaSenha.setError(getString(R.string.error_empty_senha));
            aux++;
        }

        if(email.isEmpty()){
            editTextEmail.setError(getString(R.string.error_empty_email));
            aux++;
        }

        if(!senha.equals(confirmaSenha)){
            editTextConfirmaSenha.setError(getString(R.string.error_different_passwords));
            aux++;
        }

        if (!checkBoxPrivacity.isChecked()){
            aux++;
        }

        if (aux == 0 && checkBoxPrivacity.isChecked()){
            limparTela();
            Toast.makeText(this, "Usuário registrado com sucesso", Toast.LENGTH_SHORT).show();
            finish();
        }

        if (!checkBoxPrivacity.isChecked()){
            Toast.makeText(this, "É necessário aceitar ps termos de uso", Toast.LENGTH_SHORT).show();
        }
    }

    private void limparTela() {
        editTextNome.setText("");
        editTextSenha.setText("");
        editTextEmail.setText("");
        editTextConfirmaSenha.setText("");
    }

    public void textoTermos(View view){
        Intent intent = new Intent(this, PrivacyPolicy.class);
        startActivity(intent);
    }


}
