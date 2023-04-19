/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package emamass.practica4;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poppe
 */
public class JugadorTest {
    
    public JugadorTest() {
    }
    
    /**
     * Test of regresarMano method, of class Jugador.
     */
    @Test
    public void testRegresarMano() {
        System.out.println("regresarMano");
        Baraja baraja = new Baraja();
        baraja.barajar();
        ArrayList<Carta> expResult = baraja.repartir(5);
        Jugador instance = new Jugador(expResult,1);
        ArrayList<Carta> result = instance.regresarMano();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of agregarCarta method, of class Jugador.
     */
    @Test
    public void testAgregarCarta() {
        System.out.println("agregarCarta");
        Baraja baraja = new Baraja();
        baraja.barajar();
        int dado = 2;
        Jugador instance = new Jugador(baraja.repartir(5),1);
        instance.agregarCarta(baraja, dado);
        assertEquals(7,instance.regresarMano().size());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of quitarCarta method, of class Jugador.
     */
    @Test
    public void testQuitarCarta() {
        System.out.println("quitarCarta");
        Baraja baraja = new Baraja();
        baraja.barajar();
        int index = 1;
        Jugador instance = new Jugador(baraja.repartir(5),1);
        instance.quitarCarta(baraja, index);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(4,instance.regresarMano().size());
    }

    /**
     * Test of regresarCarta method, of class Jugador.
     */
    @Test
    public void testRegresarCarta() {
        System.out.println("regresarCarta");
        int index = 1;
        Baraja baraja = new Baraja();
        baraja.barajar();
        ArrayList<Carta> expResult = baraja.repartir(1);
        Jugador instance = new Jugador(expResult,1);
        Carta result = instance.regresarCarta(index);
        assertEquals(expResult.get(0), result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of aumentarPuntaje method, of class Jugador.
     */
    @Test
    public void testAumentarPuntaje() {
        System.out.println("aumentarPuntaje");
        int puntos = 3;
        ArrayList<Carta> vacio = new ArrayList<>();
        Jugador instance = new Jugador(vacio, 1);
        instance.aumentarPuntaje(puntos);
        assertEquals(puntos,instance.getPuntaje());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of disminuirPuntaje method, of class Jugador.
     */
    @Test
    public void testDisminuirPuntaje() {
        System.out.println("disminuirPuntaje");
        ArrayList<Carta> vacio = new ArrayList<>();
        Jugador instance = new Jugador(vacio,1);
        int expResult = 1;
        instance.aumentarPuntaje(4);
        assertNotEquals(expResult,instance.getPuntaje());
        instance.disminuirPuntaje();
        assertEquals(expResult,instance.getPuntaje());
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of estaVacia method, of class Jugador.
     */
    @Test
    public void testEstaVacia() {
        System.out.println("estaVacia");
        ArrayList<Carta> vacio = new ArrayList<>();
        Jugador instance = new Jugador(vacio, 1);
        boolean expResult = false;
        boolean result = instance.estaVacia();
        assertNotEquals(expResult, result);
        Baraja baraja = new Baraja();
        instance.agregarCarta(baraja, 1);
        result = instance.estaVacia();
        assertEquals(expResult,result);
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of getPuntaje method, of class Jugador.
     */
    @Test
    public void testGetPuntaje() {
        System.out.println("getPuntaje");
        ArrayList<Carta> vacio = new ArrayList<>();
        Jugador instance = new Jugador(vacio, 1);
        int expResult = 3;
        int result = instance.getPuntaje();
        assertNotEquals(expResult, result);
        instance.aumentarPuntaje(expResult);
        result = instance.getPuntaje();
        assertEquals(expResult,result);
    }
    
}
