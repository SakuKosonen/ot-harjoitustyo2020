package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Luokka joka sisältää hirsipuu pelin logiikan ja siihen tarvittavat metodit.
 */
public class Peli {

    private String sana;
    private String[] keskenerainen;
    private HashSet<String> arvatutSet;
    private ArrayList<String> arvatutList;
    private int arvaustenLkm;
    private Statistiikka statistiikka;

    /**
     * Peli luokan konstruktori joka alustaa muuttujat.
     *
     * @param sana haluttu sana jolla pelataan
     */
    public Peli(String sana) {
        statistiikka = new Statistiikka();

        arvaustenLkm = 0;
        keskenerainen = sana.split("");
        this.sana = sana;
        String[] kirjaimet = sana.split("");
        for (int i = 0; i < sana.length(); i++) {
            if (kirjaimet[i].equals("-")) {
                keskenerainen[i] = "-";
            } else {
                keskenerainen[i] = "*";
            }
        }
        arvatutSet = new HashSet();
        arvatutSet.add("-");
        arvatutSet.add(" ");
        arvatutList = new ArrayList();
    }
    
    /**
     * Metodi palauttaa kysytyn sanan merkkijonona.
     * 
     * @return kysytty sana
     */    
    public String getSana() {
        return sana;
    }
    
    /**
     * Metodi palauttaa keskeneräisen sanan taulukkona niin, että arvaamatta jääneet sanat merkitään
     * tähti (*) merkillä.
     * 
     * @return keskeneräinen sana taulukkona 
     */    
    public String[] getKeskenerainen() {
        return keskenerainen;
    }
    
    /**
     * Metodi palauttaa merkkijonona keskeneräisen sanan. Kaikki arvaamatta jääneet kohdat palautetaan
     * tähti (*) merkillä.
     * 
     * @return keskeneräinen sana 
     */    
    public String getKeskenerainenSana() {
        String uusiSana = "";

        for (String tyomaa1 : keskenerainen) {
            uusiSana = uusiSana + tyomaa1;
        }
        return uusiSana;
    }
    
    /**
     * Metodi katsoo kuuluuko arvattu kirjain kysyttyyn sanaan ja täyttää keskeneräisten listaa.
     * 
     * @param kirjain pelaajan antama arvaus kirjaimena
     * 
     * @return löytyikö kirjain kysytystä sanasta
     */    
    public boolean arvaa(String kirjain) {
        String[] oikeaSana = sana.split("");
        boolean ihanko = false;
        if (arvatutSet.contains(kirjain)) {
            arvaustenLkm++;
            return false;
        } else {
            for (int i = 0; i < keskenerainen.length; i++) {
                if (oikeaSana[i].equals(kirjain)) {
                    setKeskenerainen(i, kirjain);
                    ihanko = true;
                }
            }
            arvatutSet.add(kirjain);
            arvatutList.add(kirjain);
            if (ihanko == false) {
                arvaustenLkm++;
            }
            return ihanko;
        }
    }

    public void setKeskenerainen(int n, String kirjain) {
        keskenerainen[n] = kirjain;
    }
    
    /**
     * Metodi kysyy peliltä onko keskeneräinen sana sama kuin kysytty sana.
     * 
     * @return onko voitettu
     */    
    public boolean voitto() {
        boolean ihanko = true;
        String[] vastaus = sana.split("");
        for (int i = 0; i < keskenerainen.length; i++) {
            if (!arvatutSet.contains(vastaus[i])) {
                ihanko = false;
            }
        }

        return ihanko;
    }
    
     /**
     * Metodi antaa arvatut kirjaimet listana.
     * 
     * @return arvatut kirjaimet
     */    
    public List getArvatut() {
        return arvatutList;
    }
    
     /**
     * Metodi kertoo oliko arvattu sana kysytty sana ja kasvattaa
     * arvausten lukumäärää jos arvaus oli väärä.
     *
     * @param arvaus pelaajan antama arvaussana
     *
     * @return arvauksen oikeellisuus
     */    
    public boolean arvaaSanaa(String arvaus) {

        if (!arvaus.toLowerCase().equals(sana)) {
            arvaustenLkm++;
        }

        return arvaus.toLowerCase().equals(sana);

    }
    
     /**
     * Metodi kertoo onko vääriä arvauksia tullut tarpeeksi häviötä varten.
     *
     * @return onko hävitty
     */    
    public boolean havio() {
        if (arvaustenLkm >= 8) {

            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodi arvaa kaikki oikeat kirjaimet, jolloin oikea sana tulee näkyviin.
     */    
    public void taytaSana() {
        String[] kaikki = sana.split("");
        for (int i = 0; i < sana.length(); i++) {
            arvaa(kaikki[i]);
        }
    }
    
    /**
     * Metodi palauttaa merkkijonona kaikki väärät arvaukset isoina kirjaimina ja välilyönneillä.
     *
     * @return väärät arvatut kirjaimet
     */    
    public String getArvatutString() {
        String arvatut = "";
        for (int i = 0; i < getArvatut().size(); i++) {

            if (!sana.contains(getArvatut().get(i).toString())) {
                arvatut = arvatut + " " + getArvatut().get(i);
            }
        }
        arvatut = arvatut.toUpperCase();
        return arvatut;
    }
    
    /**
     * Metodi kirjaa tilastoihin pelatun pelin.  
     */    
    public void pelaa() {
        statistiikka.pelaa();
    }
    
    /**
     * Metodi kirjaa tilastoihin voitetun pelin.
     */    
    public void voita() {
        statistiikka.voita();
    }
    
    /**
     * Metodi kirjaa tilastoihin arvauksen.
     */    
    public void arvaa() {
        statistiikka.arvaa();
    }
    
    /**
     * Metodi kirjaa oikean arvauksen.
     */    
    public void arvaaOikein() {
        statistiikka.arvaaOikein();
    }

}
