/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author Saku
 */
public class Pelaaja {

    String nimi;
    int voitot;
    int haviot;

    public Pelaaja(String nimi) {
        this.nimi = nimi;
        voitot = 0;
        haviot = 0;

    }

    public String getNimi() {
        return nimi;
    }

    public int getVoitot() {
        return voitot;
    }

    public int getHaviot() {
        return haviot;
    }

    public int getPelit() {
        return voitot + haviot;
    }

    public void pelaa(boolean voitto) {
        if (voitto) {
            voitot++;
        } else {
            haviot++;
        }

    }

    public double getVoittoprosentti() {
        double dVoitot = voitot;
        double dHaviot = haviot;

        return dVoitot / (dVoitot + dHaviot);
    }

}
