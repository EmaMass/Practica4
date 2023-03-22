package emamass.practica4;
import java.util.ArrayList;

public class AplicacionDeCartas {

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
  
}
