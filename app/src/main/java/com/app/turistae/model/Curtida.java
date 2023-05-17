package com.app.turistae.model;

public class Curtida {
    public int turismoId;
    public int usuarioId;

    public Curtida() {}

    public Curtida(int turismoId, int usuarioId) {
        this.turismoId = turismoId;
        this.usuarioId = usuarioId;
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
