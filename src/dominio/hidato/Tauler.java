package hidato;

import java.io.Serializable;

public class Tauler implements Serializable {
  //DADES
  private Cela[][] taulerJoc;

  //FUNCIONS/OPERACIONS
  //Constructor
  public Tauler() { }

  //Constructor. Les Celes tenen tipus (i per tant, valor) igual a 0
  public Tauler (int tamany) {
    taulerJoc = new Cela[tamany][tamany];
    for (int i = 0; i < taulerJoc.length; ++i) {
        for (int j = 0; j < taulerJoc.length; ++j) {
            taulerJoc[i][j] = new Cela();
        }
    }
  }

  public int sizeTauler() { //mirar como size con array
    return taulerJoc.length;
  }

  //Set Cela d'una posicio del taulerJoc
  public void setCela (int i, int j, int valor) {
    taulerJoc[i][j].setValor(valor);
  }
  
  public int getCela (int i, int j) {
    return taulerJoc[i][j].getValor();
  }

  public Cela[][] getTauler() {
    return taulerJoc;
  }
}
