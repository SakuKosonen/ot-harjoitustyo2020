
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saku
 */
public class Peli {

    String sana;
    String[] tyomaa;
    HashSet<String> arvatutSet;
    ArrayList<String> arvatutList;

    public Peli(String sana) {
        tyomaa = sana.split("");
        this.sana = sana;
        String[] kirjaimet = sana.split("");
        for (int i = 0; i < sana.length(); i++) {
            if (kirjaimet[i].equals("-")) {
                tyomaa[i] = "-";
            } else {
                tyomaa[i] = "*";
            }
        }
        arvatutSet = new HashSet();
        arvatutSet.add("-");
        arvatutList = new ArrayList();
    }

    public String getSana() {
        return sana;
    }

    public String[] getTyomaa() {

        return tyomaa;
    }

    public String getKeskenerainenSana() {
        String uusiSana = "";

        for (String tyomaa1 : tyomaa) {
            uusiSana = uusiSana + tyomaa1;
        }
        return uusiSana;
    }

    public boolean arvaa(String kirjain) {
        String[] oikeaSana = sana.split("");
        boolean ihanko = false;

        if (arvatutSet.contains(kirjain)) {
            return false;
        } else {
            for (int i = 0; i < tyomaa.length; i++) {

                if (oikeaSana[i].equals(kirjain)) {
                    setTyomaa(i, kirjain);
                    ihanko = true;
                }

            }
            arvatutSet.add(kirjain);
            arvatutList.add(kirjain);
            return ihanko;
        }

    }

    public void setTyomaa(int n, String kirjain) {
        tyomaa[n] = kirjain;
    }

    public boolean voitto() {
        boolean ihanko = true;
        String[] vastaus = sana.split("");
        for (int i = 0; i < tyomaa.length; i++) {
            if (!arvatutSet.contains(vastaus[i])) {
                ihanko = false;
            }
        }
        return ihanko;
    }

    public List getArvatut() {
        return arvatutList;
    }
    
    public boolean arvaaSanaa(String arvaus){
        return arvaus.equals(sana);
    }

}
