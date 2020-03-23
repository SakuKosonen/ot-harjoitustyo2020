package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti != null);
    }

    @Test
    public void saldoAluksiOikein() {
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldonLataaminen() {
        kortti.lataaRahaa(100);
        assertEquals("saldo: 1.10", kortti.toString());
    }

    @Test
    public void saldoVaheneeOikeinKunRahatRiittaa() {
        kortti.lataaRahaa(10);
        kortti.otaRahaa(9);
        assertEquals("saldo: 0.11", kortti.toString());
    }

    @Test
    public void saldoEiVaheneKunRahatEiRiita() {
        kortti.otaRahaa(11);
        assertEquals("saldo: 0.10", kortti.toString());
    }

    @Test
    public void saldonOttaminenAntaaOikeanBooleaninKunRahatEiRiita() {

        assertEquals(false, kortti.otaRahaa(11));
    }

    @Test
    public void saldonOttaminenAntaaOikeanBooleaninKunRahatRiittaa() {

        assertEquals(true, kortti.otaRahaa(9));
    }

    @Test
    public void saldoMetodiToimii() {
        assertEquals(10, kortti.saldo());
    }

}
