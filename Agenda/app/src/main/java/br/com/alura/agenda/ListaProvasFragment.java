package br.com.alura.agenda;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

import br.com.alura.agenda.modelo.Prova;

/**
 * Created by alexsandercaproni on 09/11/2016.
 */

public class ListaProvasFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_lista_provas, container, false);

        List<String> topicosPort = Arrays.asList("Sujeito", "Predicado", "Gramática");
        Prova provaPortugues = new Prova("Português", "18/11/2016", topicosPort);

        List<String> topicosMat = Arrays.asList("Equações", "Inequações", "Logaritmos");
        Prova provaMatematica = new Prova("Matemática", "25/11/2016", topicosMat);

        List<Prova> provas = Arrays.asList(provaPortugues, provaMatematica);

        ArrayAdapter<Prova> adapter = new ArrayAdapter<Prova>(getContext(), android.R.layout.simple_list_item_1, provas);

        ListView lvProvas = (ListView) view.findViewById(R.id.provas_list);
        lvProvas.setAdapter(adapter);

        lvProvas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Prova prova = (Prova) parent.getItemAtPosition(position);
                Toast.makeText(getContext(), "Prova de " + prova + " selecionada", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(getContext(), DetalhesProvaActivity.class);
                intent.putExtra("prova", prova);
                startActivity(intent);
            }
        });

        return view;
    }
}
