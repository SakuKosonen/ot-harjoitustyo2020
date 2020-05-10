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
public class AakkosNappaimet {

    GridPane aakkosGrid;
    String painettu;
    Label painettuKirjainLabel;

    public AakkosNappaimet() {
        Aakkoset aakkoset = new Aakkoset();
        aakkosGrid = new GridPane();
        painettu = "ei painettu";
        painettuKirjainLabel = new Label(painettu);

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
                painettu = jotain.toLowerCase();
                painettuKirjainLabel.setText(painettu);
                aakkonen.setVisible(false);
            });
            
            
            aakkosGrid.add(aakkonen, kohta, rivi);
        }
       
    }

    public String getPainettu() {
        return painettu;
    }

    public GridPane getAakkosGrid() {
        return aakkosGrid;
    }

    public Label getPainettuKirjainLabel() {
        return painettuKirjainLabel;
    }

}
