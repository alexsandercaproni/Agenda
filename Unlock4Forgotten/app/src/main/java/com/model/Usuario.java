package com.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    private long id;
    private String nome;
    private String senha;
    private String email;

    public Usuario(){}

    public Usuario(String nome, String senha, String email){
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public Usuario(long id, String nome, String senha, String email){
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
