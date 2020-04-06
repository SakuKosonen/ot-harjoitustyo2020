package ui;

import ui.components.SanaGrid;
import ui.components.AakkosGrid;
import domain.Aakkoset;
import domain.Peli;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.Event;
import javafx.event.EventType;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import ui.components.PeliScene;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saku
 */
public class Sovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Perinne peli");
        ikkuna.show();
        
       // Peli peli = new Peli(sana);
        
       
        PeliScene peliScene = new PeliScene("kanakettu");
        
        ikkuna.setScene(peliScene.getScene());

    }

    public static void main(String[] args) {
        launch(Sovellus.class);
    }

}
