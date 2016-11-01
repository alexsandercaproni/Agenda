package com.dao.banco;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Usuario;

public class UsuarioDAO {

    private SQLiteDatabase database;
    private BaseDAO baseDAO;

    public UsuarioDAO(Context context){
        baseDAO = new BaseDAO(context);
    }

    public void open() throws SQLException{
        database = baseDAO.getWritableDatabase();
    }

    public void close(){
        baseDAO.close();
    }

    public void novoUsuario(Usuario usuario){
        ContentValues values = new ContentValues();

        values.put(BaseDAO.CAMPO_NOME, usuario.getNome());
        values.put(BaseDAO.CAMPO_SENHA, usuario.getSenha());
        values.put(BaseDAO.CAMPO_EMAIL, usuario.getEmail());

        database.insert(BaseDAO.TABELA_USUARIO, null, values);
    }

    public int atualizarUsuario(Usuario usuario) {
        long id = usuario.getId();
        ContentValues values = new ContentValues();

        values.put(BaseDAO.CAMPO_NOME, usuario.getNome());
        values.put(BaseDAO.CAMPO_SENHA, usuario.getSenha());
        values.put(BaseDAO.CAMPO_EMAIL, usuario.getEmail());

        return database.update(BaseDAO.TABELA_USUARIO, values, BaseDAO.CAMPO_ID + " = " + id, null);
    }

    public void apagarUsuario(Usuario contato) {
        long id = contato.getId();

        database.delete(BaseDAO.TABELA_USUARIO, BaseDAO.CAMPO_ID + " = " + id, null);
    }

    public List<Usuario> buscar(){
        List<Usuario> list = new ArrayList<Usuario>();
        String[] colunas = new String[]{"_id", "nome", "email", "senha"};
        Cursor cursor = database.query(BaseDAO.TABELA_USUARIO, colunas, null, null, null, null, "nome ASC");

        if(cursor.getCount() > 0){
            cursor.moveToFirst();
            do {
                Usuario user = new Usuario();
                user.setId(cursor.getLong(0));
                user.setNome(cursor.getString(1));
                user.setEmail(cursor.getString(2));
                user.setSenha(cursor.getString(3));
                list.add(user);

            }while (cursor.moveToNext());
        }

        return(list);
    }

}


