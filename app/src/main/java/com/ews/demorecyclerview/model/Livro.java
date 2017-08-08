package com.ews.demorecyclerview.model;

import java.io.Serializable;

/**
 * Created by wallace on 26/06/17.
 */
public class Livro implements Serializable {

    private final String nomeLivro;
    private final String nomeAutor;
    private final String descricao;
    private final Double preco;

    public Livro(String nomeLivro, String nomeAutor, String descricao, Double preco) {
        this.nomeLivro = nomeLivro;
        this.nomeAutor = nomeAutor;
        this.descricao = descricao;
        this.preco = preco;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nomeLivro='" + nomeLivro + '\'' +
                ", nomeAutor='" + nomeAutor + '\'' +
                ", descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
