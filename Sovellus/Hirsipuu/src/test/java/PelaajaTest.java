/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Pelaaja;
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
public class PelaajaTest {

    public PelaajaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    @Test
    public void pelaajanLuominen() {

    }

    @Test
    public void nimiOikein() {
        Pelaaja pelaaja = new Pelaaja("I1337pwn3rI");
        assertEquals("I1337pwn3rI",pelaaja.getNimi());
    }

    @Test
    public void voittojenHavioidenJaPelienMaaraOikein() {
        Pelaaja pelaaja = new Pelaaja("I1337pwn3rI");
        pelaaja.pelaa(true);
        pelaaja.pelaa(true);
        pelaaja.pelaa(true);
        pelaaja.pelaa(false);
        assertEquals(pelaaja.getHaviot() + pelaaja.getVoitot() + pelaaja.getPelit(), 8);
    }

    @Test
    public void voittoProsenttiOikein() {
        Pelaaja pelaaja = new Pelaaja("I1337pwn3rI");
        pelaaja.pelaa(true);
        pelaaja.pelaa(true);
        pelaaja.pelaa(true);
        pelaaja.pelaa(false);

        assertEquals(0.75, pelaaja.getVoittoprosentti(), 0.001);
    }

}
