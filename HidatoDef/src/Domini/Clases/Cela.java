package Domini.Clases;



import Domini.Clases_compartides.Cela_Compartida;
import java.io.Serializable;

/**
 * Classe contenidora d'informació. Cada cel·la pren un valor i és d'un tipus determinat.
 * 
 * @author jaume
 */
public class Cela extends Cela_Compartida implements Serializable {
  /*Definim una cela de diferents maneres:
	una cela forat: tipus = -1 / valor = -1
	una cela buida: tipus = 0  / valor = valor actual de la cela (comença a 0)
	una cela  fixe: tipus = valor inicial i inalterable
				   / valor = valor inicial i inalterable
  */
  private int tipus = 0;
  private int valor = 0;

  /**
   * Constructor bàsic. Les variables tipus i valor estan inicialitzades a 0.
   */
  public Cela() { }
  
  /**
   * Constructor inicialitzat amb un determinat tipus, seguint la definició de cel·la.
   * @param tipus Pot pendre els següents valors: -1(forat), 0(cel·la buida) o un valor enter positiu (cel·la fixe)
   */
  public Cela(int tipus) {
    this.tipus = tipus;
    valor = tipus;
  }

  /**
   * Setter encarregat de canviar el valor d'una cel·la, només es pot canviar el valor d'una cel·la modificable.
   * @param valor Té per valor un nombre natural
   * 
   */
  public void setValor (int valor) {
      tipus = valor;
      this.valor = valor;
      //return true;
  }
  
  public boolean modificaValor(int valor){
      if(tipus == 0){
          this.valor = valor;
          return true;
      }
      return false;
  }

  /**
   * Setter encarregat de canviar el tipus d'una cel·la.
   * @param tipus Pot pendre els següents valors: -1(forat), 0(cel·la buida) o un valor enter positiu (cel·la fixe)
   * @return Retorna un valor booleà que indica si el setter ha provocat algun canvi en el tipus de la cel·la
   */
  public boolean setTipus (int tipus) {
    if (this.tipus != tipus) {
      this.tipus = tipus;
      valor = tipus;
      return true;
    }
    this.tipus = tipus;
    valor = tipus;
    return false;
  } 

  /**
   * Getter encarregat d'obtenir el tipus d'una cel·la.
   * @return Valor (int) que indica el tipus de la cel·la
   */
  public int getTipus() {
    return tipus;
  }

  /**
   * Getter encarregat d'obtenir el valor d'una cel·la.
   * @return Valor (int) de la cel·la
   */
  public int getValor() {
    return valor;
  }

}