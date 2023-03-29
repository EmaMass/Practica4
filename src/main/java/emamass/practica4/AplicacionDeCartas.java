package emamass.practica4;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class AplicacionDeCartas {
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
 private int jugadores;
 private int contador;
 private int caraDado;
 private int respuesta;
 ArrayList<Baraja> mazo;
 ArrayList<Jugador> control;
 ArrayList<Integer> cartasEnJuego;
 ArrayList<Integer> cartasIguales;
 Dado dado;
 Carta temp;
  public void inicia() {
    mazo = new ArrayList<>();
    control = new ArrayList<>();
    cartasEnJuego = new ArrayList<Integer>();
    cartasIguales = new ArrayList<Integer>();
    Scanner scn = new Scanner(System.in);
    dado = new Dado();
    contador = 0;
    System.out.println("Cuantos jugadores? ");
    jugadores = scn.nextInt();
    mazo.add(new Baraja());
    mazo.get(contador).barajar();
    for(int i = 0; i < jugadores; i++){
        control.add(new Jugador(mazo.get(contador).repartir(5), i+1));
        if((i % 3) == 0 && i != 0){
            contador += 1;
            mazo.add(new Baraja());
            mazo.get(contador).barajar();
        }
    }
    for(int j = 9 /*Rondas*/; j < 10; j++){
        contador = 0;
        for(int i = 0; i < jugadores; i++){
            caraDado = dado.girarDado();
            System.out.println("Jugador "+(i+1)+" giro el dado y tiene "+caraDado+" nuevas cartas");
            control.get(i).agregarCarta(mazo.get(contador), caraDado);
            System.out.println(control.get(i));
            if((i % 3) == 0 && i != 0){
                contador += 1;
            }
        }
        contador = 0;
        for(int i = 0; i < jugadores; i++){
            System.out.println("Jugador "+(i+1)+", decida que carta tirar: ");
            respuesta = scn.nextInt();
            temp = (control.get(i).regresarCarta(respuesta));
            cartasEnJuego.add(temp.getValor());
            control.get(i).quitarCarta(mazo.get(contador), respuesta);
            if((i % 3) == 0 && i != 0){
                contador += 1;
            }
        }
        compararCartas();
  
    }
  }
  
  public void compararCartas(){
    int valorMax;
     valorMax = Collections.max(cartasEnJuego);
    int posicion;
     posicion = cartasEnJuego.indexOf(valorMax);
    for(int i = 0; i < control.size(); i++){
        if(valorMax == cartasEnJuego.get(i) && posicion != i){
            cartasIguales.add(i);
        }
    }
  }
  
}
