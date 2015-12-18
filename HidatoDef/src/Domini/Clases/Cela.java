package Domini.Clases;



import Domini.Clases_compartides.Cela_Compartida;
import java.io.Serializable;

/**
 * Classe contenidora de informacio, cada cela pren un valor i es de un tipus determinat.
 * 
 * @author jaume.guell
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
   * Constructor basic, les variables tipus i valor estan inicialitzades a 0.
   */
  public Cela() { }
  
  /**
   * Constructor inicialitzat amb un determinat tipus, seguint la definició de cela.
   * @param tipus Pot pendre els seguents valors: -1(forat), 0(cela buida) o un valor enter positiu (cela fixe)
   */
  public Cela(int tipus) {
    this.tipus = tipus;
    valor = tipus;
  }

  /**
   * Setter encarregat de canviar el valor de una cela, nomes es pot canviar el valor d'una cela modificable.
   * @param valor Te per valor un nombre natural
   * 
   */
  public void setValor (int valor) {
      tipus = valor;
      this.valor = valor;
  }
  
  /**
   * Setter encarregat de canviar el valor de una cela no forat.
   * @param valor Valor a posar
   */
  public void SetValorNoForat(int valor) {
      if(tipus != -1){
        tipus = valor;
        this.valor = valor;
      }
  }
  
  /**
   * Funcio encarregada de modificar el valor de una cela modificable.
   * @param valor Valor a posar
   * @return True en cas de que es fagi el set correctament, false si la cela no es modificable
   */
  public boolean modificaValor(int valor){
      if(tipus == 0){
          this.valor = valor;
          return true;
      }
      return false;
  }

  /**
   * Setter encarregat de canviar el tipus d'una cela.
   * @param tipus Pot pendre els seguents valors: -1(forat), 0(cela buida) o un valor enter positiu (cela fixe)
   * @return Retorna un valor boolea que indica si el setter ha provocat algun canvi en el tipus de la cela
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
   * Getter encarregat de obtenir el tipus d'una cela.
   * @return Valor (int) que indica el tipus de la cela
   */
  public int getTipus() {
    return tipus;
  }

  /**
   * Getter encarregat de obtenir el valor de una cela.
   * @return Valor (int) de la cela
   */
  public int getValor() {
    return valor;
  }

}