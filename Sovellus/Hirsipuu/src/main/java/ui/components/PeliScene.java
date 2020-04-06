/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author Saku
 */
public class PeliScene {

    String sana;
    Scene scene;
    
    public PeliScene(String sana) {
        this.sana = sana;
        
        BorderPane peliRuutu = new BorderPane();
        peliRuutu.setPrefSize(500, 500);

        this.scene = new Scene(peliRuutu);

        AakkosGrid aakkosgrid = new AakkosGrid();

        peliRuutu.setTop(aakkosgrid.getAakkosGrid());

        

        SanaGrid sanaGrid = new SanaGrid(sana);
        peliRuutu.setCenter(sanaGrid.getSanagrid());

        Label painettuLabel = aakkosgrid.getLaabeli();

        VBox weebo = new VBox();
        weebo.getChildren().add(painettuLabel);

        Button paivitys = new Button("paivita");
        paivitys.setOnAction((event) -> {
            sanaGrid.paivita(aakkosgrid.getLaabeli().getText());

        });

        painettuLabel.textProperty().addListener((final ObservableValue<? extends String> observable, final String oldValue, final String newValue) -> {
            sanaGrid.paivita(aakkosgrid.getLaabeli().getText());
        });

        
    }

    public Scene getScene() {
        return scene;
    }
    
    
    
}
