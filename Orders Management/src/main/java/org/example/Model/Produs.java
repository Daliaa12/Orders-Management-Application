package org.example.Model;

/***
 * Class that stores Product data
 */
public class Produs {
    private int produs_id;
    private String nume;
    private int cantitate;

    public Produs(int produs_id, String nume, int cantitate) {
        this.produs_id = produs_id;
        this.nume = nume;
        this.cantitate = cantitate;
    }

    public int getProdus_id() {
        return produs_id;
    }
    public void setProdus_id(int produs_id) {
        this.produs_id = produs_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getCantitate() {
        return cantitate;
    }

    public void setCantitate(int cantitate) {
        this.cantitate = cantitate;
    }
}
