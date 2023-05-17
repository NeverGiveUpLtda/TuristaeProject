package com.app.turistae.model;

public class Review {
    public String teste;
    public int nota;
    public int turismoId;
    public int usuarioId;

    public Review() {}

    public Review(String teste, int nota, int turismoId, int usuarioId) {
        this.teste = teste;
        this.nota = nota;
        this.turismoId = turismoId;
        this.usuarioId = usuarioId;
    }

    public String getTeste() {
        return teste;
    }

    public void setTeste(String teste) {
        this.teste = teste;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public int getTurismoId() {
        return turismoId;
    }

    public void setTurismoId(int turismoId) {
        this.turismoId = turismoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }
}

/*
texto": "teste",
"nota": 0,
"turismoId": 1,
"usuarioId": 1
*/
