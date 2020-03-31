
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Saku
 */
public class Main {
    public static void main(String[] args) {
        
        ArrayList<String> sanat = new ArrayList();
        
        sanat.add("kettuterrieri");
        sanat.add("es");
        sanat.add("jonne");
        sanat.add("covid-19");
        
        Peli peli = new Peli(sanat.get(0));
        
        System.out.println(peli.getKeskenerainenSana());
        peli.arvaa("s");
        System.out.println("Arvattiin: s");
        System.out.println(peli.getKeskenerainenSana());
        if(peli.voitto()){
            System.out.println("Voitto jee!");
        } else {
            System.out.println("Voi hitsi ei voittoa viela");
        }
        
        peli.arvaa("i");
        System.out.println("Arvattiin: i");
        
        System.out.println(peli.getKeskenerainenSana());
        
        if(peli.voitto()){
            System.out.println("Voitto jee!");
        } else {
            System.out.println("Voi hitsi ei voittoa viela");
        }
        
        peli.arvaa("e");
        
        System.out.println("Arvattiin: e");
        
        System.out.println(peli.getKeskenerainenSana());
        
        if(peli.voitto()){
            System.out.println("Voitto jee!");
        } else {
            System.out.println("Voi hitsi ei voittoa viela");
        }
        
        System.out.println(peli.getArvatut());
        
        
        /*<dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
            <version>5.3.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-params</artifactId>
            <version>5.3.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-engine</artifactId>
            <version>5.3.1</version>
            <scope>test</scope>
        </dependency>*/
    }

}
