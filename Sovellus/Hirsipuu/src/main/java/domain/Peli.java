package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * herra on hyva ja laittaa pisteen javadoc lauseeseeen.
 *
 * @author Saku
 */
public class Peli {

    String sana;
    String[] keskenerainen;
    HashSet<String> arvatutSet;
    ArrayList<String> arvatutList;
    int arvaustenLkm;

    /**
     * konstuktori juttu jee.
     *
     * @param sana
     */
    public Peli(String sana) {
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
        arvatutList = new ArrayList();
    }

    public String getSana() {
        return sana;
    }

    public String[] getKeskenerainen() {

        return keskenerainen;
    }

    public String getKeskenerainenSana() {
        String uusiSana = "";

        for (String tyomaa1 : keskenerainen) {
            uusiSana = uusiSana + tyomaa1;
        }
        return uusiSana;
    }

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

    public List getArvatut() {
        return arvatutList;
    }

    public boolean arvaaSanaa(String arvaus) {
        if (!arvaus.equals(sana)) {
            arvaustenLkm++;
        }

        return arvaus.equals(sana);

    }

    public boolean havio() {
        if (arvaustenLkm >= 8) {

            return true;
        } else {
            return false;
        }
    }

    public void taytaSana() {
        String[] kaikki = sana.split("");
        for (int i = 0; i < sana.length(); i++) {
            arvaa(kaikki[i]);
        }
    }

}
