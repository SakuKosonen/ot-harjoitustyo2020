/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.components;

import domain.Statistiikka;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Saku
 */
public class StatistiikkaScene {

    Scene statistiikkaScene;
    Scene aloitusScene;
    Stage ikkuna;
    Statistiikka statistiikka;

    public StatistiikkaScene(Stage ikkuna, Scene aloitusScene) {
        this.ikkuna = ikkuna;
        this.aloitusScene = aloitusScene;
        statistiikka = new Statistiikka();
        BorderPane ruutu = new BorderPane();

        ruutu.setPrefSize(400, 500);
        ruutu.setMaxHeight(500);
        ruutu.setMaxWidth(400);
        statistiikkaScene = new Scene(ruutu);

        HBox box = new HBox();
        box.setSpacing(50);
        TilePane tekstit = new TilePane(Orientation.VERTICAL);
        tekstit.setHgap(12.0);
        tekstit.setVgap(8.0);

        TilePane numerot = new TilePane(Orientation.VERTICAL);
        numerot.setHgap(12.0);
        numerot.setVgap(8.0);

        box.getChildren().add(tekstit);
        box.getChildren().add(numerot);

        ruutu.setCenter(box);

        Button takaisin = new Button("Takaisin");
        takaisin.setFont(new Font(30));
        ruutu.setTop(takaisin);

        Button nollaa = new Button("Nollaa");
        nollaa.setFont(new Font(20));
        ruutu.setBottom(nollaa);

        Text pelitT = new Text("Pelit");
        pelitT.setFont(new Font(30));
        Text voitotT = new Text("Voitot");
        voitotT.setFont(new Font(30));
        Text haviotT = new Text("Häviot");
        haviotT.setFont(new Font(30));
        Text arvauksetT = new Text("Arvaukset");
        arvauksetT.setFont(new Font(30));
        Text oikeatArvauksetT = new Text("Oikeat arvaukset");
        oikeatArvauksetT.setFont(new Font(30));
        Text vaaratArvauksetT = new Text("Väärät arvaukset");
        vaaratArvauksetT.setFont(new Font(30));
        Text voittoProsenttiT = new Text("Voittoprosentti");
        voittoProsenttiT.setFont(new Font(30));
        Text arvausProsenttiT = new Text("Arvausprosentti");
        arvausProsenttiT.setFont(new Font(30));

        tekstit.getChildren().add(pelitT);
        tekstit.getChildren().add(voitotT);
        tekstit.getChildren().add(haviotT);
        tekstit.getChildren().add(arvauksetT);
        tekstit.getChildren().add(oikeatArvauksetT);
        tekstit.getChildren().add(vaaratArvauksetT);
        tekstit.getChildren().add(voittoProsenttiT);
        tekstit.getChildren().add(arvausProsenttiT);

        Text pelit = new Text(Integer.toString(statistiikka.getPelit()));
        pelit.setFont(new Font(30));
        Text voitot = new Text(Integer.toString(statistiikka.getVoitot()));
        voitot.setFont(new Font(30));
        Text haviot = new Text(Integer.toString(statistiikka.getHaviot()));
        haviot.setFont(new Font(30));
        Text arvaukset = new Text(Integer.toString(statistiikka.getArvaukset()));
        arvaukset.setFont(new Font(30));
        Text oikeatArvaukset = new Text(Integer.toString(statistiikka.getOikeatArvaukset()));
        oikeatArvaukset.setFont(new Font(30));
        Text vaaratArvaukset = new Text(Integer.toString(statistiikka.getVaaratArvaukset()));
        vaaratArvaukset.setFont(new Font(30));
        Text voittoProsentti = new Text(Double.toString(statistiikka.getVoittoprosentti()) + "%");
        voittoProsentti.setFont(new Font(30));
        Text arvausProsentti = new Text(Double.toString(statistiikka.getArvausprosentti()) + "%");
        arvausProsentti.setFont(new Font(30));

        numerot.getChildren().add(pelit);
        numerot.getChildren().add(voitot);
        numerot.getChildren().add(haviot);
        numerot.getChildren().add(arvaukset);
        numerot.getChildren().add(oikeatArvaukset);
        numerot.getChildren().add(vaaratArvaukset);
        numerot.getChildren().add(voittoProsentti);
        numerot.getChildren().add(arvausProsentti);

        takaisin.setOnAction((event) -> {
            this.ikkuna.setScene(this.aloitusScene);
        });

        nollaa.setOnAction((event) -> {
            statistiikka.nollaa();
            takaisin.fire();

        });
    }

    public Scene getStatistiikkaScene() {
        return statistiikkaScene;
    }

}
