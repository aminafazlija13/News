package com.example.aminapc.novosti;

public class Novosti {
    private  int id;
    private String naslov;
    private String slika;
    private String opis;

    public Novosti(int id, String naslov, String slika, String opis) {
        this.id = id;
        this.naslov = naslov;
        this.slika = slika;
        this.opis = opis;
    }

    public int getId() {
        return id;
    }

    public String getNaslov() {
        return naslov;
    }

    public String getSlika() {
        return slika;
    }

    public String getOpis() {
        return opis;
    }
}
