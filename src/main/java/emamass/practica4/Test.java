package emamass.practica4;
import java.util.ArrayList;

public class Test {

  void main(String args[]) {
    try {
      Carta c = new Carta("K", Figura.CORAZONES);
      System.out.println(c);
      System.out.println(
        new Carta("j",Figura.DIAMANTES)+"\n"+
        new Carta("q",Figura.DIAMANTES)+"\n"+
        new Carta("a",Figura.DIAMANTES)+"\n"+
        new Carta(10,Figura.PICAS)+"\n"+
        new Carta(11,Figura.TREBOLES)
      );
      System.out.println("--------------------");
     
      System.out.println(new Carta("10",Figura.PICAS));
    } catch (FueraDeRangoException e) {
      System.out.println(e);
    }
  }

}
