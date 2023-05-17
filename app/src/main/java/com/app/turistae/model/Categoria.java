package com.app.turistae.model;

public class Categoria {
    private String nome;

    public Categoria() {}

    private Categoria(String nome) {
        this.nome = nome;
    }

    private String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }
}
