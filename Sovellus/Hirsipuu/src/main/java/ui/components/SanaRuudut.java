/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Peli;
import javafx.geometry.Orientation;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

/**
 *
 * @author Saku
 */
public class SanaRuudut {

    VBox sanagrid;
    String arvatut;
    String sana;
    Peli peli;
    Text[] text;
    TilePane kirjaimia;

    public SanaRuudut(Peli sana) {
        this.peli = sana;
        peli.pelaa();
   
        sanagrid = new VBox();
        arvatut = "";
        text = new Text[peli.getSana().length()];

        TilePane viivoja = new TilePane(Orientation.HORIZONTAL);

        viivoja.setHgap(12.0);
        viivoja.setVgap(8.0);

        Line[] viivat = new Line[peli.getSana().length()];
        int xStart = 20;
        int lineLength = 24;
        

        for (int i = 0; i < viivat.length; i++) {

            int xcoord = xStart;

            viivat[i] = new Line(xcoord, 0, xcoord - lineLength, 0);
            viivat[i].setStroke(Color.BLACK);
            viivat[i].setStrokeWidth(3);
            if (peli.getSana().substring(i, i + 1).equals(" ")) {
                viivat[i].setVisible(false);
            }
            viivoja.getChildren().add(viivat[i]);

        }

        kirjaimia = new TilePane(Orientation.HORIZONTAL);

        kirjaimia.setPrefTileWidth(26.5);
        kirjaimia.setHgap(12.0);
        kirjaimia.setVgap(8.0);

        for (int i = 0; i < text.length; i++) {

            text[i] = new Text(peli.getSana().substring(i, i + 1).toUpperCase());
            text[i].setFont(new Font(30));
            text[i].setVisible(false);
            if (text[i].getText().equals("-")) {
                text[i].setVisible(true);
            }
            kirjaimia.getChildren().add(text[i]);

        }

        sanagrid.getChildren().add(kirjaimia);
        sanagrid.getChildren().add(viivoja);
        HBox kokeilu = new HBox();
        kokeilu.setSpacing(30);

    }

    public void paivita(String arvaus) {
        boolean loytyiAinakinYksi = false;
        if (!arvaus.equals("")) {
            peli.arvaa(arvaus);
            
        }
        
        for (int i = 0; i < text.length; i++) {
            String tama = text[i].getText();

            String tuo = peli.getKeskenerainen()[i].toUpperCase();

            if (tama.equals(tuo)) {
                kirjaimia.getChildren().get(i).setVisible(true);
                loytyiAinakinYksi = true;
            }
        }
        
        

    }

    public boolean arvaaSanaa(String sana) {
        
        
       
        
        return peli.arvaaSanaa(sana);
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
    
    public void arvaa() {
        peli.arvaa();
    }
    
    public void arvaaOikein() {
        peli.arvaaOikein();
    }
    
    public void voita() {
        peli.voita();
    }
    
    
    
    

}
