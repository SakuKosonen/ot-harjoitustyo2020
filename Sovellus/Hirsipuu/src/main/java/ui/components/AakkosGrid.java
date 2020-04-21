/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Aakkoset;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

/**
 *
 * @author Saku
 */
public class AakkosGrid {

    GridPane aakkosGrid;
    String painettu;
    Label laabeli;

    public AakkosGrid() {
        Aakkoset aakkoset = new Aakkoset();
        aakkosGrid = new GridPane();
        painettu = "ei painettu";
        laabeli = new Label(painettu);
        
        

        for (int i = 0; i < aakkoset.getAakkosetLista().size(); i++) {
            int rivi = 0;
            int kohta = i;
            if (i > 10) {
                rivi = 1;
                kohta = i - 10;
            }
            if (i > 20) {
                rivi = 2;
                kohta = i - 20;
            }

            Button aakkonen = new Button((String) aakkoset.getAakkosetLista().get(i));
            String jotain = (String) aakkoset.getAakkosetLista().get(i);

            aakkonen.setOnAction((event) -> {
                painettu = jotain;
                laabeli.setText(painettu);
                
            });
            aakkosGrid.add(aakkonen, kohta, rivi);
        }
        aakkosGrid.add(laabeli, aakkoset.getAakkosetLista().size(), 3);
    }

    public String getPainettu() {
        return painettu;
    }

    public GridPane getAakkosGrid() {
        return aakkosGrid;
    }

    public Label getLaabeli() {
        return laabeli;
    }

}
