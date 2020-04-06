/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Aakkoset;
import java.util.ArrayList;
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
public class AakkosetTest {

    public AakkosetTest() {
    }

    @Test
    public void aakkoslistaAlkaaAJaLoppuuÖTest() {
        Aakkoset testi = new Aakkoset();

        ArrayList<String> testiLista = testi.getAakkosetLista();

        String testiString = testiLista.get(0) + testiLista.get(testiLista.size() - 1);

        assertEquals(testiString, "aö");
    }

    @Test
    public void aakkoStringiOnOikeaTest() {
        Aakkoset testi = new Aakkoset();
        String testiString = testi.getAakkosetString();
        
        assertEquals(testiString, "abcdefghijklmnopqrstuvwxyzåäö");
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
