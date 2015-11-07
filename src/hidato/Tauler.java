package hidato;

public class Tauler
{
  //////////Dades//////////
  private Cela[][] taulerJoc;
  /////////////////////////


  //Constructor
  public Tauler() {  }

  //Constructor. Les Celes tenen tipus (i per tant, valor) random
  public Tauler (int tamany) {
    taulerJoc = new Cela[tamany][tamany];
  }

  public int sizeTauler() { //mirar como size con array
    return taulerJoc.length;
  }

  //Set Cela d'una posicio del taulerJoc
  public void setCela (int i, int j, int valor) {
    taulerJoc[i][j].setValor(valor);
  }

  //
  public Cela[][] getTauler() {
    return taulerJoc;
  }
}
