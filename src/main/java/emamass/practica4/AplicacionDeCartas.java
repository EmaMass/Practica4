package emamass.practica4;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
public class AplicacionDeCartas {

 private int jugadores;
 private int contador;
 private int caraDado;
 private int respuesta;
 private int ganador;
 private int puntos; 
 private int valorMax;
 private int posicion; 
 ArrayList<Baraja> mazo;
 ArrayList<Jugador> control;
 ArrayList<Integer> cartasEnJuego;
 ArrayList<Integer> cartasIguales;
 ArrayList<Integer> cartasIgualesEmpate;
 ArrayList<Integer> puntosDeTodos;
 Dado dado;
 Carta temp;
 Scanner scn;
  public void inicia() {
    mazo = new ArrayList<>();
    control = new ArrayList<>();
    cartasEnJuego = new ArrayList<>();
    cartasIguales = new ArrayList<>();
    cartasIgualesEmpate = new ArrayList<>();
    puntosDeTodos = new ArrayList<>();
    scn = new Scanner(System.in);
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
    for(int i = 0; i < jugadores; i++){
            caraDado = dado.girarDado();
            System.out.println("Jugador "+(i+1)+" giro el dado y tiene "+caraDado+" nuevas cartas");
            control.get(i).agregarCarta(mazo.get(contador), caraDado);
            System.out.println(control.get(i));
            if((i % 3) == 0 && i != 0){
                contador += 1;
            }
        }
    for(int j = 0 /*Rondas*/; j < 10; j++){
        contador = 0;
        for(int i = 0; i < jugadores; i++){
            System.out.println("Jugador "+(i+1)+", decida que carta tirar: ");
            System.out.println(control.get(i));
            respuesta = scn.nextInt();
            temp = (control.get(i).regresarCarta(respuesta));
            cartasEnJuego.add(temp.getValor());
            control.get(i).quitarCarta(mazo.get(contador), respuesta);
            if((i % 3) == 0 && i != 0){
                contador += 1;
            }
        }
        compararCartas();
        if(!cartasIgualesEmpate.isEmpty()){
            System.out.println("Empate, se repartira 1 puntos entre los jugadores empatados");
            for(Integer num : cartasIgualesEmpate){
                control.get(num).aumentarPuntaje(puntos);
            }
            cartasIgualesEmpate.clear();
        } else{
            System.out.println("El ganador es el jugador "+(ganador+1)+" y recibira 2 puntos");
            control.get(ganador).aumentarPuntaje(puntos);
        }
        contador = 0;
        if(j != 9){
        revisarVacio();
        }
    }
    compararPuntos();
    if(cartasIguales.isEmpty()){
        System.out.println("El ganador del juego es el jugador "+(ganador+1)+" con un puntaje de "+puntos);
    } else {
        System.out.println("Empate, entre los jugadores "+(ganador+1));
        for(Integer num : cartasIguales){
            System.out.println(" y el jugador "+(num+1));
        }
    }
    for(int i = 0; i < jugadores; i++){
        System.out.println("Jugador "+(i+1)+": "+control.get(i).getPuntaje());
    }
  }
  
  public void compararCartas(){
     valorMax = Collections.max(cartasEnJuego);
     posicion = cartasEnJuego.indexOf(valorMax);
     ganador = posicion; 
    for(int i = 0; i < control.size(); i++){
        if(valorMax == cartasEnJuego.get(i) && posicion != i){
            cartasIguales.add(i);
        }
    }
    if(cartasIguales.isEmpty()){
        ganador = posicion;
        puntos = 2;
    } else {
        casoEmpate();
    }
    cartasEnJuego.clear();
    cartasIguales.clear();
  }
  
  public void compararPuntos(){
      cartasIguales.clear();
      for(int i = 0; i < jugadores; i++){
          puntosDeTodos.add(control.get(i).getPuntaje());
      }
      puntos = Collections.max(puntosDeTodos);
      ganador = puntosDeTodos.indexOf(puntos);
      for(int i = 0; i < jugadores; i++){
        if(puntos == puntosDeTodos.get(i) && ganador != i){
            cartasIguales.add(i);
        }
    }
  }
  
  public void casoEmpate(){
    cartasIgualesEmpate.clear();
    cartasEnJuego.clear();
    revisarVacio();
    System.out.println("Empate");
    System.out.println("Jugador "+(ganador+1)+", decida que carta tirar: ");
    System.out.println(control.get(ganador));
    respuesta = scn.nextInt();
    temp = (control.get(ganador).regresarCarta(respuesta));
    cartasEnJuego.add(temp.getValor());
    if(ganador < 3){
        contador = 0;
    }
    else {
        contador = ganador/3;
    }
    control.get(ganador).quitarCarta(mazo.get(contador), respuesta);
    for(Integer i: cartasIguales){
            System.out.println("Jugador "+(i+1)+", decida que carta tirar: ");
            System.out.println(control.get(i));
            respuesta = scn.nextInt();
            temp = (control.get(i).regresarCarta(respuesta));
            cartasEnJuego.add(temp.getValor());
            if(i < 3){
                contador = 0;
            }
            else {
                contador = i/3;
            }
            control.get(i).quitarCarta(mazo.get(contador), respuesta);
        }
     valorMax = Collections.max(cartasEnJuego);
     posicion = cartasEnJuego.indexOf(valorMax);
     if(posicion == 0){
         posicion = ganador; 
     } else {
         posicion = cartasIguales.get(posicion-1);
     }
    for(int i = 0; i < cartasEnJuego.size(); i++){
        System.out.println(i);
        if(valorMax == cartasEnJuego.get(i) && posicion != i){
            cartasIgualesEmpate.add(i);
        }
    }
    if(cartasIgualesEmpate.isEmpty()){
        ganador = posicion;
        puntos = 2;
    } else {
        puntos = 1;
        cartasIgualesEmpate.add(posicion);
    }
  }
  
  public void revisarVacio(){
        contador = 0;
        for(int i = 0; i < jugadores; i++){
            if(control.get(i).estaVacia() == true){
                System.out.println("Jugador "+(i+1)+" no tiene cartas en su mano, girando dado para que tenga cartas, y se pierde 3 puntos");
                caraDado = dado.girarDado();
                System.out.println("Consigue "+caraDado+" cartas");
                control.get(i).agregarCarta(mazo.get(contador), caraDado);
                control.get(i).disminuirPuntaje();
            }
            if((i % 3) == 0 && i != 0){
                contador += 1;
            }
        }
  }
}
