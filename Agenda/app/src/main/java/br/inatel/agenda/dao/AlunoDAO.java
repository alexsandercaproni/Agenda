package br.inatel.agenda.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import br.inatel.agenda.model.Aluno;

/**
 * Created by Alexsander on 24/10/2016.
 */
public class AlunoDAO extends SQLiteOpenHelper{

    public AlunoDAO(Context context) {
        super(context, "Agenda", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE Aluno (id INTEGER PRIMARY KEY, nome TEXT NOT NULL, endereco TEXT, idade INTEGER, site TEXT, nota REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS Aluno;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void insere(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosAlunos(aluno);

        db.insert("Aluno", null, dados);

    }

    @NonNull
    private ContentValues pegaDadosAlunos(Aluno aluno) {
        ContentValues dados = new ContentValues();
        dados.put("nome", aluno.getNome());
        dados.put("endereco", aluno.getEndereco());
        dados.put("idade", aluno.getIdade());
        dados.put("site", aluno.getSite());
        dados.put("nota", aluno.getNota());
        return dados;
    }

    public List<Aluno> busca() {
        String sql = "SELECT * FROM Aluno";
        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.rawQuery(sql, null);
        List<Aluno> alunos = new ArrayList<>();

        while (cursor.moveToNext()){
            Aluno aluno = new Aluno();

            aluno.setID(cursor.getLong(cursor.getColumnIndex("id")));
            aluno.setNome(cursor.getString(cursor.getColumnIndex("nome")));
            aluno.setEndereco(cursor.getString(cursor.getColumnIndex("endereco")));
            aluno.setIdade(cursor.getInt(cursor.getColumnIndex("idade")));
            aluno.setSite(cursor.getString(cursor.getColumnIndex("site")));
            aluno.setNota(cursor.getDouble(cursor.getColumnIndex("nota")));

            alunos.add(aluno);
        }
        cursor.close();

        return alunos;
    }

    public void deleta(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        String[] params = {Long.toString(aluno.getID())};
        db.delete("Aluno", "id = ?", params);
    }


    public void altera(Aluno aluno) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues dados = pegaDadosAlunos(aluno);

        String[] params = {Long.toString(aluno.getID())};
        db.update("Aluno", dados, "id = ?", params);
    }
}
