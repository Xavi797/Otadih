package Domini.Clases;


import Domini.Clases_compartides.Tauler_Compartit;
import java.io.Serializable;

/**
 * Classe encarregada de contenir diferents Celes per tal de formar un tauler de joc.
 * @author jaume.guell
 */
public class Tauler extends Tauler_Compartit implements Serializable {
    
    private Cela[][] taulerJoc;

    /**
     * Constructor basic.
     */
    public Tauler() { }

    /**
     * Constructor, el tauler te celes inicialitzades amb tipus i valor igual a 0.
     * @param tamany Indica la mida que tindra el tauler. Es a dir, tamany x tamany
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
     * Setter encarregat de canviar el valor d'una cela determinada del tauler.
     * @param i Indica la fila a accedir
     * @param j Indica la columna a accedir
     * @param valor Indica el valor que volem que prengui la cel�la
     */
    public void setCela (int i, int j, int valor) {
      taulerJoc[i][j].setValor(valor);
    }

    /**
     * Setter encarregat de canviar el valor d'una cela no forat determinada del tauler.
     * @param i Indica la fila de la cela dins la matriu
     * @param j Indica la columna de la cela dins la matriu
     * @param valor Valor a posar
     */
    public void setCelaNoforat(int i, int j, int valor){
      taulerJoc[i][j].SetValorNoForat(valor);
    }
  
  
    /**
     * Setter encarregat de modificar una cela modificable d'una posicio determinada.
     * @param i Fila dins la matriu
     * @param j Columna dins la matriu
     * @param valor Valor a posar
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean ModificaCela (int i, int j, int valor) {
        return taulerJoc[i][j].modificaValor(valor);
    }

    /**
    * Getter encarregat d'obtenir una cela determinada del tauler.
    * @param i Indica la fila a accedir
    * @param j Indica la columna a accedir
    * @return Retorna un objecte de tipus Cela
    */
    public int getCela (int i, int j) {
        return taulerJoc[i][j].getValor();
    }

    public int getTipus (int i, int j) {
        return taulerJoc[i][j].getTipus();
    }

     /**
      * getTauler() retorna el propi tauler.
      * @return Retorna el tauler (i les seves celes) sobre el que s'ha fet la crida a la funcio
      */
    public Cela[][] getTauler() {
        return taulerJoc;
    }

    /**
     * Funcio encarregada de clonar el tauler en un altre objecte de tipus Tauler.
     * @return Objecte de tipus Tauler amb el tauler clonat
     */
    public Tauler clonar(){
        Tauler t = new Tauler(taulerJoc.length);
        for(int i = 0; i <taulerJoc.length; ++i)
                for(int j = 0; j <taulerJoc.length; ++j)
                        t.setCela(i, j, taulerJoc[i][j].getValor());

        return t;
    }

    /**
     * Funcio que retorna la quantitat de celes de tipus no fixes o forats del tauler
     * @return 
     */
    public int getNumPosades(){
        int num = 0;
        for (int i = 0; i < taulerJoc.length; ++i) {
                    for (int j = 0; j < taulerJoc.length; ++j) {
                        if (taulerJoc[i][j].getTipus() != 0) ++num;
                    }
        }
        return num;
    }
  
}
