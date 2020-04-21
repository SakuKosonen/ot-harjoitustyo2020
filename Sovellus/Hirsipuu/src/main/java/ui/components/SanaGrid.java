/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Peli;
import java.util.ArrayList;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Saku
 */
public class SanaGrid {

    VBox sanagrid;
    String arvatut;
    String sana;
    Peli peli;
    Text[] text;
    HBox kirjaimia;

    public SanaGrid(Peli sana) {
        this.peli = sana;
       // this.sana = sana;
        sanagrid = new VBox();
        arvatut = "";
        text = new Text[peli.getSana().length()];

        HBox viivoja = new HBox();
        viivoja.setSpacing(20);

        Line[] viivat = new Line[peli.getSana().length()];
        int xStart = 375;
        int lineLength = 25;
        int lineSpacing = 35;

        for (int i = 0; i < viivat.length; i++) {

            int xcoord = xStart + (lineSpacing * i);

            viivat[i] = new Line(xcoord, 225, xcoord - lineLength, 225);
            viivat[i].setStroke(Color.BLACK);
            viivat[i].setStrokeWidth(3);
            viivoja.getChildren().add(viivat[i]);

        }

        kirjaimia = new HBox();
        kirjaimia.setSpacing(34);

        for (int i = 0; i < text.length; i++) {

            text[i] = new Text(peli.getSana().substring(i, i + 1).toUpperCase());
            text[i].setFont(new Font(30));

            text[i].setVisible(false);
            kirjaimia.getChildren().add(text[i]);

        }

        sanagrid.getChildren().add(kirjaimia);
        sanagrid.getChildren().add(viivoja);
        HBox kokeilu = new HBox();
        kokeilu.setSpacing(30);

    }

    public void paivita(String arvaus) {

        peli.arvaa(arvaus);

        for (int i = 0; i < text.length; i++) {
            String tama = text[i].getText();

            String tuo = peli.getKeskenerainen()[i].toUpperCase();

            if (tama.equals(tuo)) {
                kirjaimia.getChildren().get(i).setVisible(true);
            }
        }

    }

    public boolean voitettiinko() {
        return peli.voitto();
    }

    public boolean havittiinko() {
        return peli.havio();
    }

    public VBox getSanagrid() {
        return sanagrid;
    }
    
    public void tayta() {
        peli.taytaSana();
        paivita("");
    }
    

}
