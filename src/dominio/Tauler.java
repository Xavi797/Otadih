package hidato;

import java.io.Serializable;

/**
 * Classe encarregada de contenir diferents Cel·les per tal de formar un tauler de joc.
 * 
 * @author jaume
 */
public class Tauler implements Serializable {
    
  private Cela[][] taulerJoc;

  /**
   * Constructor bàsic.
   */
  public Tauler() { }

  /**
   * Constructor. El tauler té cel·les inicialitzades amb tipus i valor igual a 0.
   * @param tamany Indica la mida que tindrà el tauler. És a dir, tamany x tamany
   */
  public Tauler (int tamany) {
    taulerJoc = new Cela[tamany][tamany];
    for (int i = 0; i < taulerJoc.length; ++i) {
        for (int j = 0; j < taulerJoc.length; ++j) {
            taulerJoc[i][j] = new Cela();
        }
    }
  }

  /**
   * sizeTauler() retorna la mida del tauler.
   * @return Valor (int) que indica la mida del tauler
   */
  public int sizeTauler() {
    return taulerJoc.length;
  }

  /**
   * Setter encarregat de canviar el valor d'una cel·la dterminada del tauler.
   * @param i Indica la fila a accedir
   * @param j Indica la columna a accedir
   * @param valor Indica el valor que volem que prengui la cel·la
   */
  public void setCela (int i, int j, int valor) {
    taulerJoc[i][j].setValor(valor);
  }
  
  /**
   * Getter encarregat d'obtenir una cel·la determinada del tauler.
   * @param i Indica la fila a accedir
   * @param j Indica la columna a accedir
   * @return Retorna un objecte de tipus Cela
   */
  public int getCela (int i, int j) {
    return taulerJoc[i][j].getValor();
  }

  /**
   * getTauler() retorna el propi tauler.
   * @return Retorna el tauler (i les seves cel·les) sobre el que s'ha fet la crida a la funció
   */
  public Cela[][] getTauler() {
    return taulerJoc;
  }
}

