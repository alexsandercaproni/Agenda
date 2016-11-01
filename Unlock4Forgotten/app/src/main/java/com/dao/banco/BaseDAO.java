package com.dao.banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDAO extends SQLiteOpenHelper {

    //Nome do banco de dados
    public static final String NOME_BANCO = "registro";
    //Versão do banco de dados
    public static final int VERSAO_SCHEMA = 1;

    //Nome da tabela
    public static final String TABELA_USUARIO = "usuario";

    //Nome dos campos
    public static final String CAMPO_ID = "_id";
    public static final String CAMPO_EMAIL = "email";
    public static final String CAMPO_NOME = "nome";
    public static final String CAMPO_SENHA = "senha";

    private static final String CRIAR_TABELA_CADASTRO = "CREATE TABLE "
            + TABELA_USUARIO + " (" + CAMPO_ID + " INTEGER PRIMARY KEY, "
            + CAMPO_NOME + " TEXT, "
            + CAMPO_EMAIL + " TEXT, "
            + CAMPO_SENHA + " TEXT)";

    public BaseDAO(Context context) {
        super(context, NOME_BANCO, null, VERSAO_SCHEMA);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CRIAR_TABELA_CADASTRO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table usuario");
        onCreate(db);
    }
}
