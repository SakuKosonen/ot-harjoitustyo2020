/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Luokka joka mahdollistaa peli statistiikan tilastoimisen.
 */
public class Statistiikka {

    private int pelit;
    private int voitot;
    private int arvaukset;
    private int oikeatArvaukset;
    
    /**
     * Statistiikka luokan konstruktori joka alustaa muuttujat tekstitiedostosta.
     */
    public Statistiikka() {
        ArrayList<Integer> lista = new ArrayList();
        
        try (Scanner tiedostonLukija = new Scanner(Paths.get("statistiikka.txt"))) {
            int n = 4;
            int i = 0;
            String rivi = "";

            while (tiedostonLukija.hasNext()) {
                
                rivi = tiedostonLukija.nextLine();
                lista.add(Integer.parseInt(rivi));
                i++;
            }
            
        } catch (Exception e) {
            System.out.println("Virhe: " + e.getMessage());
        }

        pelit = lista.get(0);
        voitot = lista.get(1);
        arvaukset = lista.get(2);
        oikeatArvaukset = lista.get(3);

    }
    
     /**
     * Metodi antaa pelattujen pelien määrän.
     * 
     * @return pelatut pelit
     */    
    public int getPelit() {
        return pelit;
    }
    
    /**
     * Metodi antaa voitettujen pelien määrän.
     * 
     * @return voitetut pelit
     */    
    public int getVoitot() {
        return voitot;
    }
    
    /**
     * Metodi antaa hävittyjen pelien määrän.
     * 
     * @return hävityt pelit
     */    
    public int getHaviot() {
        return pelit - voitot;
    }
    
    /**
     * Metodi antaa arvattujen sanojen ja kirjaimien määrän.
     * 
     * @return arvatut sanat ja kirjaimet
     */    
    public int getArvaukset() {
        return arvaukset;
    }
    
    /**
     * Metodi antaa oikein arvattujen sanojen ja kirjaimien määrän.
     * 
     * @return oikein arvatut sanat ja kirjaimet
     */    
    public int getOikeatArvaukset() {
        return oikeatArvaukset;
    }
    
    /**
     * Metodi antaa väärin arvattujen sanojen ja kirjaimien määrän.
     * 
     * @return väärin arvatut sanat ja kirjaimet
     */    
    public int getVaaratArvaukset() {
        return arvaukset - oikeatArvaukset;
    }
    
    /**
     * Metodi antaa voittoprosentin.
     * 
     * @return voittoprosentti
     */    
    public double getVoittoprosentti() {
        double dVoitot = voitot;
        double dPelit = pelit;
        if (pelit == 0) {
            return 0;
        }
        double ka = (dVoitot / dPelit) * 100;
        return pyorista(ka, 2);

    }
    
    /**
     * Metodi antaa oikein arvattujen sanojen ja kirjaimien osuuden kaikista arvauksista.
     * 
     * @return arvausprosentti
     */    
    public double getArvausprosentti() {
        double dOikeatArvaukset = oikeatArvaukset;
        double dArvaukset = arvaukset;
        if (arvaukset == 0) {
            return 0;
        }
        double ka = (dOikeatArvaukset / dArvaukset) * 100;

        return pyorista(ka, 2);
    }
    
    /**
     * Metodi kirjaa pelatun pelin.     
     */    
    public void pelaa() {
        pelit++;
        paivita();
    }
    
    /**
     * Metodi kirjaa voitetun pelin.     
     */    
    public void voita() {
        voitot++;
        paivita();
    }
    
    /**
     * Metodi kirjaa arvatun sanan tai kirjaimen.     
     */    
    public void arvaa() {
        arvaukset++;
        paivita();
    }
    
    /**
     * Metodi kirjaa oikein arvatun sanan tai kirjaimen.     
     */    
    public void arvaaOikein() {
        oikeatArvaukset++;
        paivita();
    }
    
    /**
     * Metodi päivittää tilastot tekstitiedostoon.     
     */    
    public void paivita() {

        try {
            FileWriter fw = new FileWriter("statistiikka.txt", false);
            fw.write(pelit + "\n" + voitot + "\n" + arvaukset + "\n" + oikeatArvaukset);

            fw.close();
        } catch (IOException ex) {
            System.out.println("Kirjoitus epäonnistui");
        }

    }
    
    /**
     * Metodi asettaa tekstitiedoston muotoon jossa on 4 riviä joilla kaikilla on vain numero 0.     
     */    
    public void nollaa() {
        pelit = 0;
        voitot = 0;
        arvaukset = 0;
        oikeatArvaukset = 0;
        paivita();
    }
    
    /**
     * Metodi pyöristää luvun halutulle tarkkuudelle.
     *
     * @param arvo pyöristettävä luku
     * @param decimaali haluttu pyöristyksen tarkkuus
     *
     * @return pyöristetty luku
     */    
    public double pyorista(double arvo, int decimaali) {

        long factor = (long) Math.pow(10, decimaali);
        arvo = arvo * factor;
        long tmp = Math.round(arvo);
        return (double) tmp / factor;

    }

}
