package br.inatel.agenda;

import android.widget.EditText;
import android.widget.RatingBar;

import br.inatel.agenda.model.Aluno;

/**
 * Created by alexsandercaproni on 21/10/2016.
 */
public class FormularioHelper {

    private EditText campoNome;
    private EditText campoEndereco;
    private EditText campoIdade;
    private EditText campoSite;
    private RatingBar campoNota;

    private Aluno aluno;

    public FormularioHelper(FormularioActivity activity) {

        campoNome = (EditText) activity.findViewById(R.id.formulario_nome);
        campoEndereco = (EditText) activity.findViewById(R.id.formulario_endereco);
        campoIdade = (EditText) activity.findViewById(R.id.formulario_idade);
        campoSite = (EditText) activity.findViewById(R.id.formulario_site);
        campoNota = (RatingBar) activity.findViewById(R.id.formulario_nota);

        aluno = new Aluno();

    }

    public Aluno pegaAluno(){

        aluno.setNome(campoNome.getText().toString());
        aluno.setEndereco(campoEndereco.getText().toString());
        aluno.setIdade(Integer.valueOf(campoIdade.getText().toString()));
        aluno.setSite(campoSite.getText().toString());
        aluno.setNota(Double.valueOf(campoNota.getProgress()));

        return aluno;
    }

    public void preencheFormulario(Aluno aluno) {
        campoNome.setText(aluno.getNome());
        campoEndereco.setText(aluno.getEndereco());
        campoIdade.setText(String.valueOf(aluno.getIdade()));
        campoSite.setText(aluno.getSite());
        campoNota.setProgress((int) aluno.getNota() );
        this.aluno = aluno;
    }
}
