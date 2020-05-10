/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 * Luokka joka sisältää halutut ohjeet sovelluksen etusivulle.
 */
public class Ohjeet {
    private String ohjeet;
    
    /**
     * Ohjeet luokan konstruktori joka alustaa muuttujan.
     */
    public Ohjeet() {
        ohjeet = "Ohjeet: \n kirjoita tekstikenttään sana jolla halutaan pelata, tai \n jätä kenttä tyhjäksi aloittaaksesi peli satunnaisella sanalla";
    }
    
    /**
     * Metodi palauttaa peliohjeet merkkijonona.
     * 
     * @return ohjeet
     */    
    public String getOhjeet() {
        return ohjeet;
    }
}
