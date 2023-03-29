/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package emamass.practica4;
import java.util.ArrayList;

/**
 *
 * @author poppe
 */
public class Jugador {
    ArrayList<Carta> mano;
    private int numJugador;
    private int puntaje;
    public Jugador(ArrayList<Carta> cartas, int numJug){
        this.mano = cartas;
        this.numJugador = numJug;
        this.puntaje = 0;
  }
    
    public ArrayList<Carta> regresarMano(){
        return this.mano; 
    }
    
    public void agregarCarta(Baraja baraja,int dado){
        for(int i = 0; i < dado; i++){
         mano.add(baraja.agregarCarta());   
        }
    }
    
    public void quitarCarta(Baraja baraja, int index){
        baraja.quitarCarta(mano.remove(index-1));
    }
    
    public Carta regresarCarta(int index){
        return mano.get(index-1);
    }
    
    public void aumentarPuntaje(int puntos){
        this.puntaje += puntos;
    }
    
    public void disminuirPuntaje(){
        this.puntaje -= 3; 
    }
    
    public boolean estaVacia(){
        return this.mano.isEmpty();
    }
    
    public int getPuntaje(){
        return this.puntaje;
    }
    
    @Override
    public String toString(){
        String cadena = "";
        cadena += "Jugador "+this.numJugador; 
        for(int i = 0; i < mano.size(); i++){
            cadena += " "+(i+1)+". "+mano.get(i);
        }
        return cadena; 
    }
  
}
/*
public void inicia() {
    Baraja b = new Baraja();
    b.barajar();
    ArrayList<Carta> mano = b.repartir(5);
    System.out.println(mano);
    int negras=0;
    int rojas=0;
    for (Carta carta : mano) {
      if(carta.getColor() == Color.NEGRO)
        negras++;
      else
        rojas++;
    }
    System.out.println("Negras: "+negras+" Rojas: "+ rojas);
  }
  
*/