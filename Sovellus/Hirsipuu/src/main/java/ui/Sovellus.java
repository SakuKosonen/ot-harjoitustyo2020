package ui;

import javafx.application.Application;
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
