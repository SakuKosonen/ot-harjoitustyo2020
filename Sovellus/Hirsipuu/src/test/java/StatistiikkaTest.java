/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Statistiikka;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Saku
 */
public class StatistiikkaTest {

    public StatistiikkaTest() {
    }

    @Test
    public void nollausTest() {
        Statistiikka statistiikka = new Statistiikka();
        statistiikka.nollaa();
        
        assertEquals(statistiikka.getArvaukset(), 0);
        assertEquals(statistiikka.getPelit(), 0);
        assertEquals(statistiikka.getVoitot(), 0);
        assertEquals(statistiikka.getOikeatArvaukset(), 0);
    }
    
    @Test
    public void arvausProsenttiTest() {
        Statistiikka statistiikka = new Statistiikka();
        statistiikka.nollaa();
        statistiikka.arvaa();
        statistiikka.arvaa();
        statistiikka.arvaaOikein();
        assertEquals(statistiikka.getArvausprosentti(), 50.00, 0.01);
    }
    
    @Test
    public void voittoProsenttiTest() {
        Statistiikka statistiikka = new Statistiikka();
        statistiikka.nollaa();
        statistiikka.pelaa();
        statistiikka.pelaa();
        statistiikka.voita();        
        assertEquals(statistiikka.getVoittoprosentti(), 50.00, 0.01);
    }
    
    @Test
    public void paivitysJaPalautusTest() {
        Statistiikka statistiikka = new Statistiikka();
        statistiikka.nollaa();
        statistiikka.pelaa();
        statistiikka.voita();
        statistiikka.arvaa();
        statistiikka.arvaaOikein();
        statistiikka.paivita();
        Statistiikka uusi = new Statistiikka();
        assertEquals(uusi.getArvaukset(), 1);
        assertEquals(uusi.getPelit(), 1);
        assertEquals(uusi.getVoitot(), 1);
        assertEquals(uusi.getHaviot(), 0);
        assertEquals(uusi.getOikeatArvaukset(), 1);
        assertEquals(uusi.getVaaratArvaukset(), 0);
    }
}
