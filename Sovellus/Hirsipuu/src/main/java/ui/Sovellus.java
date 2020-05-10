package ui;


import javafx.application.Application;
import javafx.stage.Stage;
import ui.components.AloitusScene;


public class Sovellus extends Application {

    @Override
    public void start(Stage ikkuna) {
        ikkuna.setTitle("Hirsipuu");
        ikkuna.show();
              
        AloitusScene aloitusScene = new AloitusScene(ikkuna);
        
        ikkuna.setScene(aloitusScene.getAloitusScene());
        
        
        
    }

    public static void main(String[] args) {
        launch(Sovellus.class);
    }

}
