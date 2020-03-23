package com.mycompany.unicafe;

public class Paaohjelma {

    public static void main(String[] args) {
        Kassapaate unicafeExactum = new Kassapaate();
        Maksukortti kortti = new Maksukortti(10000);
        
        unicafeExactum.syoEdullisesti(kortti);
        
        System.out.println( unicafeExactum.edullisiaLounaitaMyyty() );
        System.out.println(kortti);
        kortti.otaRahaa(2);
        System.out.println(kortti);
        Maksukortti testi = new Maksukortti(10);
        System.out.println(testi);
        testi.otaRahaa(9);
        System.out.println(testi);
        
    }
}
