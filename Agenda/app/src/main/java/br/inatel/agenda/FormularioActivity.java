package br.inatel.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import br.inatel.agenda.dao.AlunoDAO;
import br.inatel.agenda.model.Aluno;

public class FormularioActivity extends AppCompatActivity {

    FormularioHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        helper = new FormularioHelper(this);

        Intent intent = getIntent();
        Aluno aluno = (Aluno)  intent.getSerializableExtra("aluno");
        if (aluno !=null) {
            helper.preencheFormulario(aluno);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //convertendo meu codigo xml em View
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_formulario, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_formulario:

                Aluno aluno = helper.pegaAluno();
                AlunoDAO dao = new AlunoDAO(this);

                if(!Long.toString(aluno.getID()).equals(null)){
                    dao.insere(aluno);
                    Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " cadastrado!", Toast.LENGTH_SHORT).show();
                }else{
                    dao.altera(aluno);
                    Toast.makeText(FormularioActivity.this, "Aluno " + aluno.getNome() + " alterado!", Toast.LENGTH_SHORT).show();
                }

                dao.close();
                finish();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
