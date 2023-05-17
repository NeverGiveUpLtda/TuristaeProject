package com.app.turistae.model;

public class Voucher {
    private int turismoId;

    public Voucher() {
    }

    public Voucher(int turismoId) {
        this.turismoId = turismoId;
    }

    public int getTurismoId() {
        return turismoId;
    }

    public void setTurismoId(int turismoId) {
        this.turismoId = turismoId;
    }
}