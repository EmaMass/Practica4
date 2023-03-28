package emamass.practica4;
import java.util.ArrayList;
import java.util.Scanner;
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
 ArrayList<Baraja> mazo;
 ArrayList<Jugador> control;
 Dado dado;
  public void inicia() {
    mazo = new ArrayList<>();
    control = new ArrayList<>();
    Scanner scn = new Scanner(System.in);
    dado = new Dado();
    contador = 0;
    System.out.println("Cuantos jugadores? ");
    jugadores = 4; //scn.nextInt();
    mazo.add(new Baraja());
    mazo.get(contador).barajar();
    for(int i = 1; i <= jugadores; i++){
        control.add(new Jugador(mazo.get(contador).repartir(5), i));
        if((i % 3) == 0){
            contador += 1;
            mazo.add(new Baraja());
            mazo.get(contador).barajar();
        }
    }
    for(int j = 9; j < 10; j++){
        contador = 0;
        for(int i = 0; i < jugadores; i++){
            control.get(i).agregarCarta(mazo.get(contador), dado.girarDado());
            System.out.println(control.get(i));
            if((i % 3) == 0 ){
                contador += 1;
            }
        }
        
    }
  }
  
}
