/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Ohjeet;
import java.nio.file.Paths;
import java.util.Random;
import java.util.Scanner;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class AloitusScene {

    Scene aloitusScene;
    Boolean kuuntelija;
    Scene peliScene;
    Stage ikkuna;

    public AloitusScene(Stage ikkuna) {
        this.ikkuna = ikkuna;
        BorderPane aloitusRuutu = new BorderPane();

        aloitusRuutu.setPrefSize(500, 600);

        aloitusScene = new Scene(aloitusRuutu);

        VBox asettelulaatikko = new VBox();

        aloitusRuutu.setTop(asettelulaatikko);

        
        Button uusiPeli = new Button("Uusi Peli");
        TextField sanaKentta = new TextField();
        uusiPeli.setFont(new Font(30));
        sanaKentta.setFont(new Font(30));
        Text ohjeet = new Text(new Ohjeet().getOhjeet());
        ohjeet.setFont(new Font(20));
        Button statistiikka = new Button("Statistiikka");
        statistiikka.setFont(new Font(30));
        
        Kuva kuva = new Kuva();
        kuva.taydennaUkko();
        
        asettelulaatikko.getChildren().add(uusiPeli);
        asettelulaatikko.getChildren().add(sanaKentta);
        asettelulaatikko.getChildren().add(ohjeet);
        asettelulaatikko.getChildren().add(statistiikka);
        asettelulaatikko.getChildren().add(kuva.getKuva());
        
        asettelulaatikko.setAlignment(Pos.CENTER);
        

        uusiPeli.setOnAction((event) -> {

            if (!sanaKentta.getText().equals("")) {
                PeliScene jotai = new PeliScene(sanaKentta.getText().toLowerCase(), ikkuna, getAloitusScene());
                peliScene = jotai.getScene();
                sanaKentta.setText("");
            } else {
                try (Scanner tiedostonLukija = new Scanner(Paths.get("sanat.txt"))) {

                    Random rand = new Random();
                    int n = rand.nextInt(94110);
                    int i = 0;
                    String rivi = "";
                    while (i < n) {

                        rivi = tiedostonLukija.nextLine();
                        if (i == n - 1) {
                            if (rivi.contains("-") || rivi.contains("(") || rivi.contains("'")) {
                                n++;
                            }

                        }
                        i++;
                    }
                    String[] oikeaRivi = rivi.split(" ");
                    
                    PeliScene jotai = new PeliScene(oikeaRivi[0].toLowerCase(), ikkuna, getAloitusScene());
                    peliScene = jotai.getScene();

                } catch (Exception e) {
                    System.out.println("Virhe: " + e.getMessage());
                }
            }

            ikkuna.setScene(peliScene);
        });
        
        statistiikka.setOnAction((event) -> {
            StatistiikkaScene statistiikkaScene = new StatistiikkaScene(ikkuna, getAloitusScene());
            ikkuna.setScene(statistiikkaScene.getStatistiikkaScene());
        });
        
       
        
    }

    public Scene getAloitusScene() {
        return aloitusScene;
    }

    public Scene getPeliScene() {
        return peliScene;
    }

}
