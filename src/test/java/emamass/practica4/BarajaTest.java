/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package emamass.practica4;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;

/**
 *
 * @author poppe
 */
public class BarajaTest {
    
    public BarajaTest() {
        
    }
    

    /**
     * Test of barajar method, of class Baraja.
     */
    @Test
    public void testBarajar() {
        System.out.println("Barajar");
        Baraja instance = new Baraja(); 
        String inicial = instance.toString();
        instance.barajar();
        String barajado = instance.toString();
        assertNotEquals(inicial,barajado);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of repartir method, of class Baraja.
     */
    @Test
    public void testRepartir() {
        System.out.println("repartir");
        int n = 5;
        Baraja instance = new Baraja();
        ArrayList<Carta> result = instance.repartir(n);
        assertEquals(result.size(), n);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of agregarCarta method, of class Baraja.
     */
    @Test
    public void testAgregarCarta() {
        System.out.println("agregarCarta");
        int n = 1;
        Baraja instance = new Baraja();
        ArrayList<Carta> result = instance.repartir(n);
        assertEquals(result.size(), n);
        result.add(instance.agregarCarta());
        assertEquals(result.size(),n+1);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of quitarCarta method, of class Baraja.
     */
    @Test
    public void testQuitarCarta() {
        System.out.println("quitarCarta");
        Baraja instance = new Baraja();
        ArrayList<Carta> test = instance.repartir(1);
        assertEquals(1,test.size());
        instance.quitarCarta(test.remove(0));
        assertEquals(0,test.size());
        
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
