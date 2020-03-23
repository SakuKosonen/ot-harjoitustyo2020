package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class KassapaateTest {

    Kassapaate kassa;
    Maksukortti rikas;
    Maksukortti koyha;

    @Before
    public void setUp() {
        kassa = new Kassapaate();
        rikas = new Maksukortti(1000);
        koyha = new Maksukortti(2);
    }

    @Test
    public void alustaminen() {
        assertEquals(100000, kassa.kassassaRahaa());
        int lounaitaMyyty = kassa.edullisiaLounaitaMyyty() + kassa.maukkaitaLounaitaMyyty();
        assertEquals(0, lounaitaMyyty);
    }

    @Test
    public void riittavaMaksuVaihtoraha() {
        assertEquals(60, kassa.syoEdullisesti(300));
        assertEquals(100, kassa.syoMaukkaasti(500));
    }

    @Test
    public void riittavaMaksuKassaKasvaa() {
        kassa.syoEdullisesti(300);
        kassa.syoMaukkaasti(100000);
        assertEquals(100640, kassa.kassassaRahaa());
    }

    @Test
    public void myytyjenLounaidenMaaraKasvaa() {
        kassa.syoEdullisesti(10000000);
        kassa.syoMaukkaasti(Integer.MAX_VALUE);
        int maara = kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty();
        assertEquals(2, maara);
    }

    @Test
    public void eiRiittavaMaksuVaihtoraha() {
        assertEquals(2, kassa.syoEdullisesti(2));
        assertEquals(5, kassa.syoMaukkaasti(5));
    }

    @Test
    public void EiriittavaMaksuKassaEiKasva() {
        kassa.syoEdullisesti(3);
        kassa.syoMaukkaasti(1);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void myytyjenLounaidenMaaraEiKasva() {
        kassa.syoEdullisesti(2);
        kassa.syoMaukkaasti(1);
        int maara = kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty();
        assertEquals(0, maara);
    }

    @Test
    public void rikasKorttiToimiiEdullisesti() {
        kassa.syoEdullisesti(rikas);
        assertEquals(760, rikas.saldo());
        assertEquals(true, kassa.syoEdullisesti(rikas));
    }

    @Test
    public void rikasKorttiToimiiMaukkaasti() {
        kassa.syoMaukkaasti(rikas);
        assertEquals(600, rikas.saldo());
        assertEquals(true, kassa.syoMaukkaasti(rikas));
    }

    @Test
    public void myytyjenLounaidenMaaraKasvaaKortilla() {
        kassa.syoEdullisesti(rikas);
        kassa.syoMaukkaasti(rikas);
        int maara = kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty();
        assertEquals(2, maara);
    }

    @Test
    public void koyhaKorttiToimiiEdullisesti() {
        kassa.syoEdullisesti(koyha);
        assertEquals(2, koyha.saldo());
        assertEquals(false, kassa.syoEdullisesti(koyha));
    }

    @Test
    public void koyhaKorttiToimiiMaukkaasti() {
        kassa.syoMaukkaasti(koyha);
        assertEquals(2, koyha.saldo());
        assertEquals(false, kassa.syoMaukkaasti(koyha));
    }

    @Test
    public void myytyjenLounaidenMaaraEiKasvaKortilla() {
        kassa.syoEdullisesti(koyha);
        kassa.syoMaukkaasti(koyha);
        int maara = kassa.maukkaitaLounaitaMyyty() + kassa.edullisiaLounaitaMyyty();
        assertEquals(0, maara);
    }

    @Test
    public void kassaEiKasvaKortilla() {
        kassa.syoEdullisesti(rikas);
        kassa.syoMaukkaasti(rikas);
        assertEquals(100000, kassa.kassassaRahaa());
    }

    @Test
    public void kortinLataus() {
        kassa.lataaRahaaKortille(koyha, 500);
        assertEquals(100500, kassa.kassassaRahaa());
        assertEquals(502, koyha.saldo());
    }

    @Test
    public void kortinLatausNegatiivisesti() {
        kassa.lataaRahaaKortille(koyha, -100);
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(2, koyha.saldo());
    }

}
