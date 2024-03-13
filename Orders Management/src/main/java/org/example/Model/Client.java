package org.example.Model;

/***
 * Class that stores client data
 */
public class Client {
    private int client_id;
    private String nume;
    private String email;
    private String adresa;

    public Client(int client_id, String nume, String email, String adresa) {
        this.client_id = client_id;
        this.nume = nume;
        this.email = email;
        this.adresa = adresa;
    }

    public int getClient_id() {
        return client_id;
    }

    public void setClient_id(int client_id) {
        this.client_id = client_id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }
}
