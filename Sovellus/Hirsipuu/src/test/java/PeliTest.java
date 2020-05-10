/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Peli;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saku
 */
public class PeliTest {

    public PeliTest() {

    }

    @Test
    public void sanaAluksiTahtinaTest() {
        Peli peli = new Peli("kettuterrieri");
        assertEquals(peli.getKeskenerainenSana(), "*************");
    }

    @Test
    public void sanaVoidaanArvataKirjaimillaTest() {
        Peli peli = new Peli("kettuterrieri");
        peli.arvaa("k");
        peli.arvaa("e");
        peli.arvaa("t");
        peli.arvaa("u");
        peli.arvaa("i");
        peli.arvaa("r");
        assertEquals(true, peli.voitto());
    }

    @Test
    public void getSanaPalauttaaOikeanSananTest() {
        Peli peli = new Peli("kettuterrieri");
        assertEquals(peli.getSana(), "kettuterrieri");
    }

    @Test
    public void keskenerainenSanaOnKeskenerainenSanaTest() {
        Peli peli = new Peli("kettuterrieri");
        peli.arvaa("k");
        peli.arvaa("e");
        peli.arvaa("t");
        peli.arvaa("u");
        peli.arvaa("i");

        assertEquals(peli.getKeskenerainenSana(), "kettute**ie*i");
    }

    @Test
    public void sanaJossaViivaSisaltaaViivanKeskeneraisenaTest() {
        Peli peli = new Peli("kettu-terrieri");
        assertEquals(peli.getKeskenerainenSana(), "*****-********");
    }

    @Test
    public void sanaaVoiArvataTest() {
        Peli peli = new Peli("kettuterrieri");

        assertEquals(peli.arvaaSanaa("kettuterrieri"), true);
    }

    @Test
    public void arvatutListaOnOikea() {
        Peli peli = new Peli("kettuterrieri");
        peli.arvaa("k");
        peli.arvaa("e");
        peli.arvaa("t");
        peli.arvaa("u");
        peli.arvaa("i");

        ArrayList<String> oikea = new ArrayList();
        oikea.add("k");
        oikea.add("e");
        oikea.add("t");
        oikea.add("u");
        oikea.add("i");

        assertEquals(peli.getArvatut(), oikea);
    }

    @Test
    public void taytto() {
        Peli peli = new Peli("kanakettu");
        peli.taytaSana();
        assertEquals(true,peli.voitto());
    }

    @Test
    public void havio() {
        Peli peli = new Peli("kanakettu");
        peli.arvaa("w");
        peli.arvaa("r");
        peli.arvaa("i");
        peli.arvaa("c");
        peli.arvaa("l");
        peli.arvaa("ö");
        peli.arvaa("z");
        peli.arvaa("q");
        assertEquals(true,peli.havio());
    }
    
    @Test
    public void voitto() {
        Peli peli = new Peli("kanakettu");
        peli.arvaa("k");
        peli.arvaa("a");
        peli.arvaa("n");
        peli.arvaa("e");
        peli.arvaa("t");
        peli.arvaa("u");
        assertEquals(true, peli.voitto());
    }
    
    @Test
    public void arvatutStringTest() {
        Peli peli = new Peli("kanakettu");
        peli.arvaa("u");
        peli.arvaa("e");
        peli.arvaa("c");
        assertEquals(" C", peli.getArvatutString());
        
    }
}
