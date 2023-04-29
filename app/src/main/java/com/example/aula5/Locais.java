package com.example.aula5;

public class Locais {

    private String nomeLocal;
    private String descricaoLocal;
    private int fotoLocal;

    public Locais() {
    }

    public Locais(String nomeLocal, String descricaoLocal, int fotoLocal) {
        this.nomeLocal = nomeLocal;
        this.descricaoLocal = descricaoLocal;
        this.fotoLocal = fotoLocal;
    }

    public String getNomeLocal() {
        return nomeLocal;
    }

    public void setNomeLocal(String nomeLocal) {
        this.nomeLocal = nomeLocal;
    }

    public String getDescricaoLocal() {
        return descricaoLocal;
    }

    public void setDescricaoLocal(String descricaoLocal) {
        this.descricaoLocal = descricaoLocal;
    }

    public int getFotoLocal() {
        return fotoLocal;
    }

    public void setFotoLocal(int fotoLocal) {
        this.fotoLocal = fotoLocal;
    }
}
