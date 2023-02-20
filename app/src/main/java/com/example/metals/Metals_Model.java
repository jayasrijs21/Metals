package com.example.metals;

public class Metals_Model {
    String metalName;
    String SciName;
    String Symbol;
    int image;

    public Metals_Model(String metalName, String sciName, String symbol, int image) {
        this.metalName = metalName;
        SciName = sciName;
        Symbol = symbol;
        this.image = image;
    }

    public String getMetalName() {
        return metalName;
    }

    public String getSciName() {
        return SciName;
    }

    public String getSymbol() {
        return Symbol;
    }

    public int getImage() {
        return image;
    }
}
