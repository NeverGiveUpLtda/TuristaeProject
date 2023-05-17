package com.app.turistae.model;

public class Imagem {
    private int turismoId;
    private String string64;

    public Imagem() {}

    public Imagem(int turismoId, String string64) {
        this.turismoId = turismoId;
        this.string64 = string64;
    }

    public int getTurismoId() {
        return turismoId;
    }

    public void setTurismoId(int turismoId) {
        this.turismoId = turismoId;
    }

    public String getString64() {
        return string64;
    }

    public void setString64(String string64) {
        this.string64 = string64;
    }
}
