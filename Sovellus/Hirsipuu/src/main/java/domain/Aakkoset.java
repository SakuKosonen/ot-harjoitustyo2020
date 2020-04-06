/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.ArrayList;

/**
 * aakkostentekoluokka.
 * @author Saku
 */
public class Aakkoset {

    private ArrayList<String> aakkosetLista;
    private String aakkosetString;

    /**
     *javadocijuttu.
     */
    public Aakkoset() {

        this.aakkosetLista = new ArrayList();
        this.aakkosetString = "abcdefghijklmnopqrstuvwxyzåäö";
        String[] palat = aakkosetString.split("");

        for (int i = 0; i < palat.length; i++) {
            aakkosetLista.add(palat[i]);
        }
    }

    public String getAakkosetString() {
        return aakkosetString;
    }

    public ArrayList getAakkosetLista() {
        return aakkosetLista;
    }

}
