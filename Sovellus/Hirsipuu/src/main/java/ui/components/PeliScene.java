/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Peli;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Saku
 */
public class PeliScene {

    Peli peli;
    Scene scene;
    boolean loppu;
    int vaaraSananArvausNumero;

    public PeliScene(String sana, Stage ikkuna, Scene aloitusScene) {
        loppu = false;
        this.peli = new Peli(sana);
        
        BorderPane peliRuutu = new BorderPane();
        peliRuutu.setPrefSize(600, 600);
        peliRuutu.setMinHeight(600);
        peliRuutu.setMinWidth(500);
        this.scene = new Scene(peliRuutu);

        AakkosNappaimet aakkosgrid = new AakkosNappaimet();
        
        TextField sananArvausField = new TextField("");
        Button arvaaSanaa = new Button("Arvaa sanaa");
        VBox sananArvausBox = new VBox();
        sananArvausBox.getChildren().addAll(sananArvausField,arvaaSanaa);
        HBox alareuna = new HBox();
        alareuna.getChildren().addAll(aakkosgrid.getAakkosGrid(), sananArvausBox);
        peliRuutu.setBottom(alareuna);
        
        

        VBox asetteluLaatikko = new VBox();
        asetteluLaatikko.setSpacing(50);

        peliRuutu.setCenter(asetteluLaatikko);

        SanaRuudut sanaGrid = new SanaRuudut(peli);

        Label ilmoitus = new Label("Onnea peliin!");
        ilmoitus.setFont(new Font(30));
        Button takaisin = new Button("takaisin");
        takaisin.setFont(new Font(20));

        Kuva oikeaKuva = new Kuva();
        
        
        Label arvatutLabel = new Label();
        arvatutLabel.setFont(new Font(30));
        
        
        
        peliRuutu.setTop(takaisin);
        takaisin.setOnAction((event) -> {
            ikkuna.setScene(aloitusScene);
        });

        asetteluLaatikko.getChildren().add(ilmoitus);
        asetteluLaatikko.getChildren().add(sanaGrid.getSanagrid());
        asetteluLaatikko.setAlignment(Pos.CENTER);
        
        HBox kuvaJaArvatut = new HBox();
        kuvaJaArvatut.getChildren().add(oikeaKuva.getKuva());
        kuvaJaArvatut.getChildren().add(arvatutLabel);
        kuvaJaArvatut.setSpacing(40);

        
        asetteluLaatikko.getChildren().add(kuvaJaArvatut);

        Label painettuLabel = aakkosgrid.getPainettuKirjainLabel();
        
        
        painettuLabel.textProperty().addListener((final ObservableValue<? extends String> observable, final String oldValue, final String newValue) -> {
            
            if (loppu == false) {
                sanaGrid.arvaa();
                sanaGrid.paivita(aakkosgrid.getPainettuKirjainLabel().getText());
                if (sana.contains(aakkosgrid.getPainettuKirjainLabel().getText())) {
                    ilmoitus.setText("Oikein!");
                    sanaGrid.arvaaOikein();
                    arvatutLabel.setText(peli.getArvatutString());
                }
                if (!sana.contains(aakkosgrid.getPainettuKirjainLabel().getText())) {

                    ilmoitus.setText("Väärin!");
                    oikeaKuva.taydenna();
                    arvatutLabel.setText(peli.getArvatutString());
                }
                if (sanaGrid.voitettiinko()) {
                    ilmoitus.setText("Onneksi olkoon! Voitit pelin!");
                    sanaGrid.voita();
                    loppu = true;
                }
                if (sanaGrid.havittiinko() && loppu == false) {
                    ilmoitus.setText("GG! Hävisit pelin!");
                    sanaGrid.tayta();
                    loppu = true;
                }
            }
        });
        
        arvaaSanaa.setOnAction((event) -> {
            sanaGrid.arvaa();
            if (loppu == false) {
                if(sanaGrid.arvaaSanaa(sananArvausField.getText())){
                    ilmoitus.setText("Onneksi olkoon! Voitit pelin!");
                    sanaGrid.tayta();
                    sanaGrid.voita();
                    peli.arvaaOikein();
                    
                    loppu = true;
                    
                } else if(!sanaGrid.arvaaSanaa(sananArvausField.getText())) {
                    ilmoitus.setText("Väärin!");
                    oikeaKuva.taydenna();
                }
                if (sanaGrid.havittiinko() && loppu == false) {
                    ilmoitus.setText("GG! Hävisit pelin!");
                    sanaGrid.tayta();
                    loppu = true;
                }
            }
            sananArvausField.setText("");
        });
        

    }

    public Scene getScene() {
        return scene;
    }

}
