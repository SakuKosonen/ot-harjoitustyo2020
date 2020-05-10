
package ui.components;


import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;


/**
 * Luokka joka sisältää hirvettävän tikku-ukon.
 */
public class Kuva {

    Pane pane;
    int mones;
    
    /**
     * Kuva luokan konstruktori joka tekee hirtettävän tikku-ukon näkymättömänä.
     */    
    public Kuva() {
        mones = 0;
        pane = new Pane();

        ObservableList<Node> children;

        children = pane.getChildren();

        Line puu1 = new Line(25, 25, 25, 300);
        puu1.setStroke(Color.BROWN);
        puu1.setStrokeWidth(5);
        puu1.setVisible(false);
        children.add(puu1);

        Line puu2 = new Line(25, 25, 200, 25);
        puu2.setStroke(Color.BROWN);
        puu2.setStrokeWidth(5);
        puu2.setVisible(false);
        children.add(puu2);

        Line naru = new Line(200, 25, 200, 75);
        naru.setStroke(Color.BROWN);
        naru.setStrokeWidth(5);
        naru.setVisible(false);
        children.add(naru);

        Ellipse paa = new Ellipse(200, 112, 35, 35);
        paa.setStroke(Color.BLACK);
        paa.setFill(Color.WHITE);
        paa.setStrokeWidth(5);
        paa.setVisible(false);
        children.add(paa);

        Line kroppa = new Line(200, 200, 200, 150);
        kroppa.setStroke(Color.BLACK);
        kroppa.setStrokeWidth(5);
        kroppa.setVisible(false);
        children.add(kroppa);

        Line kadet = new Line(150, 175, 250, 175);
        kadet.setStroke(Color.BLACK);
        kadet.setStrokeWidth(5);
        kadet.setVisible(false);
        children.add(kadet);

        Line vasenJalka = new Line(200, 200, 175, 275);
        vasenJalka.setStroke(Color.BLACK);
        vasenJalka.setStrokeWidth(5);
        vasenJalka.setVisible(false);
        children.add(vasenJalka);

        Line oikeaJalka = new Line(200, 200, 225, 275);
        oikeaJalka.setStroke(Color.BLACK);
        oikeaJalka.setStrokeWidth(5);
        oikeaJalka.setVisible(false);
        children.add(oikeaJalka);

    }
    
    /**
     * Metodi palauttaa implementoitavan kuvan sopivana nodena.
     * 
     * @return hirtettävä tikku-ukko.
     */    
    public Pane getKuva() {
        return pane;
    }
    
    /**
     * Metodi laittaa kuvan seuraavan palasen näkyväksi.
     */    
    public void taydenna() {

        pane.getChildren().get(mones).setVisible(true);
        mones++;
    }
    
    /**
     * Metodi laittaa vain tikku-ukon näkyväksi.
     */   
    public void taydennaUkko() {
        for (int i = 0; i < 8; i++) {
            if (i > 2) {
                pane.getChildren().get(i).setVisible(true);
            }
        }
    }

}
