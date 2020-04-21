/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Peli;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
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
public class PeliScene {

    Peli peli;
    Scene scene;
    boolean loppu;

    public PeliScene(String sana) {
        loppu = false;
        this.peli = new Peli(sana);

        BorderPane peliRuutu = new BorderPane();
        peliRuutu.setPrefSize(500, 600);

        this.scene = new Scene(peliRuutu);

        AakkosGrid aakkosgrid = new AakkosGrid();

        peliRuutu.setBottom(aakkosgrid.getAakkosGrid());

        VBox asetteluLaatikko = new VBox();
        asetteluLaatikko.setSpacing(50);

        peliRuutu.setCenter(asetteluLaatikko);

        SanaGrid sanaGrid = new SanaGrid(peli);

        Label ilmoitus = new Label("Onnea peliin!");
        ilmoitus.setFont(new Font(30));

        Kuva oikeaKuva = new Kuva();

        asetteluLaatikko.getChildren().add(ilmoitus);
        asetteluLaatikko.getChildren().add(sanaGrid.getSanagrid());
        asetteluLaatikko.setAlignment(Pos.CENTER);
        

        asetteluLaatikko.getChildren().add(oikeaKuva.getKuva());

        Label painettuLabel = aakkosgrid.getLaabeli();

        
        painettuLabel.textProperty().addListener((final ObservableValue<? extends String> observable, final String oldValue, final String newValue) -> {
            
            if (loppu == false) {
                sanaGrid.paivita(aakkosgrid.getLaabeli().getText());
                if (sana.contains(aakkosgrid.getLaabeli().getText())) {
                    ilmoitus.setText("Oikein!");
                }
                if (!sana.contains(aakkosgrid.getLaabeli().getText())) {

                    ilmoitus.setText("Väärin!");
                    oikeaKuva.taydenna();
                }
                if (sanaGrid.voitettiinko()) {
                    ilmoitus.setText("Onneksi olkoon! Voitit pelin!");
                    loppu = true;
                }
                if (sanaGrid.havittiinko()) {
                    ilmoitus.setText("GG! Hävisit pelin!");
                    sanaGrid.tayta();
                    loppu = true;
                }
            }
        });

    }

    public Scene getScene() {
        return scene;
    }

}
