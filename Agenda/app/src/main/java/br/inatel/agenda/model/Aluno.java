package br.inatel.agenda.model;

import java.io.Serializable;

/**
 * Created by alexsandercaproni on 21/10/2016.
 */
public class Aluno implements Serializable{

    private long ID;
    private String nome;
    private String endereco;
    private Integer idade;
    private String site;
    private double nota;

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getID() + " -> " + getNome();
    }
}
