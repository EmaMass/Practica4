/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emamass.practica4;
import java.util.Random;
/**
 *
 * @author poppe
 */
public class Dado {
   
    Random rmd;
    
    public Dado(){
        rmd = new Random();
    }
    
    public int girarDado(){
        return rmd.nextInt(5)+1;
    }
}
