/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saku
 */
public class PeliTest {

    public PeliTest() {

    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
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
}
