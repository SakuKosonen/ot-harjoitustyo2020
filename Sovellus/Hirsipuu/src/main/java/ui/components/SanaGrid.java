/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Peli;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Saku
 */
public class SanaGrid {

    GridPane sanagrid;
    String arvatut;
    String sana;
    Peli peli;

    public SanaGrid(String sana) {
        this.peli = new Peli(sana);
        this.sana = sana;
        sanagrid = new GridPane();
        arvatut = "";

        for (int i = 0; i < peli.getSana().length(); i++) {
            sanagrid.add(new Label(" "), i, 2);

        }

    }

    public void paivita(String arvaus) {
        peli.arvaa(arvaus);
       // arvatut = arvatut + arvaus;
        GridPane uusigrid = new GridPane();
        String[] jotain = peli.getSana().split("");

        for (int i = 0; i < sana.length(); i++) {

            if (!peli.getArvatut().contains(jotain[i])) {
               
            } else {
                
                sanagrid.add(new Label(jotain[i]), i, 2);
            }

        }
        
        //sanagrid = uusigrid;
    }

    public GridPane getSanagrid() {
        return sanagrid;
    }
    
    
}
