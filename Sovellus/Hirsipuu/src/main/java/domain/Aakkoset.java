
package domain;

import java.util.ArrayList;

/**
 * Luokka josta voidaan ottaa aakkoset.
 */
public class Aakkoset {
    
    private ArrayList<String> aakkosetLista;
    private String aakkosetString;

    /**
     * konstuktori joka alustaa muuttujat.
     */
    public Aakkoset() {

        this.aakkosetLista = new ArrayList();
        this.aakkosetString = "abcdefghijklmnopqrstuvwxyzåäö";
        aakkosetString = aakkosetString.toUpperCase();
        String[] palat = aakkosetString.split("");

        for (int i = 0; i < palat.length; i++) {
            aakkosetLista.add(palat[i]);
        }
    }
    
    /**
     * Metodi palauttaa aakkoset järjestyksessä merkkijonona.
     * 
     * @return aakkoset
     */    
    public String getAakkosetString() {
        return aakkosetString;
    }
    
    /**
     * Metodi palauttaa aakkoset järjestyksessä listana.
     * 
     * @return aakkoset
     */    
    public ArrayList getAakkosetLista() {
        return aakkosetLista;
    }

}
