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
public class MaksukorttiTest {

    Maksukortti kortti;
    Maksukortti tyhja;

    public MaksukorttiTest() {
    }

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
        tyhja = new Maksukortti(0);
    }

    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        Maksukortti kortti = new Maksukortti(10);

        String vastaus = kortti.toString();

        assertEquals("Kortilla on rahaa 10.0 euroa", vastaus);
    }

    @Test
    public void syoEdullisestiVahentaaSaldoaOikein() {

        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 7.5 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiVahentaaSaldoaOikein() {

        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 6.0 euroa", kortti.toString());
    }

    @Test
    public void syoEdullisestiEiVieSaldoaNegatiiviseksi() {

        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoEdullisesti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(25);
        assertEquals("Kortilla on rahaa 35.0 euroa", kortti.toString());
    }

    @Test
    public void kortinSaldoEiYlitaMaksimiarvoa() {
        kortti.lataaRahaa(200);
        assertEquals("Kortilla on rahaa 150.0 euroa", kortti.toString());
    }

    @Test
    public void syoMaukkaastiEiVieSaldoaNegatiiviseksi() {
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();
        kortti.syoMaukkaasti();

        assertEquals("Kortilla on rahaa 2.0 euroa", kortti.toString());
    }

    @Test
    public void negatiivisenLataaminenEiMuutaSaldoa() {
        kortti.lataaRahaa(-1000);

        assertEquals("Kortilla on rahaa 10.0 euroa", kortti.toString());
    }

    @Test
    public void tasarahallaSaaMaukkaasti() {
        tyhja.lataaRahaa(4);
        tyhja.syoMaukkaasti();
        
        assertEquals("Kortilla on rahaa 0.0 euroa", tyhja.toString());
    }

    @Test
    public void tasarahallaSaaEdullisesti() {
        tyhja.lataaRahaa(2.5);
        tyhja.syoEdullisesti();
        
        assertEquals("Kortilla on rahaa 0.0 euroa", tyhja.toString());
    }
}
