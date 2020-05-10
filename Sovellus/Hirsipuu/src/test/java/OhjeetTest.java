/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Ohjeet;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


/**
 *
 * @author Saku
 */
public class OhjeetTest {
    
    public OhjeetTest() {
    }
    
    @Test
    public void ohjeetOvatOikeatTest() {
        Ohjeet ohjeet = new Ohjeet();
        assertEquals(ohjeet.getOhjeet(), "Ohjeet: \n kirjoita tekstikenttään sana jolla halutaan pelata, tai \n jätä kenttä tyhjäksi aloittaaksesi peli satunnaisella sanalla");
    }
}
