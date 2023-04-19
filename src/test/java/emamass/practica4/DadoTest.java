/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package emamass.practica4;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author poppe
 */
public class DadoTest {
    
    public DadoTest() {
    }
    

    /**
     * Test of girarDado method, of class Dado.
     */
    @Test
    public void testGirarDado() {
        System.out.println("girarDado");
        Dado instance = new Dado();
        int result = instance.girarDado();
        if (result < 1 || result > 5){
        // TODO review the generated test code and remove the default call to fail.
        fail("Dado giro un numero desconocido, fuera de rango 1-5.");
        }
    }
    
}
