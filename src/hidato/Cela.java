package hidato;

public class Cela 
{
  //////////Dades//////////
  /*Definim una cela de diferents maneres:
	una cela forat: tipus = -1 / valor = -1
	una cela buida: tipus = 0  / valor = valor actual de la cela (comença a 0)
	una cela  fixe: tipus = valor inicial i inalterable
				   / valor = valor inicial i inalterable
  */
  private int tipus;
  private int valor;
  /////////////////////////


  //Constructor
  public Cela() { }
  
  //Constructor
  public Cela(int tipus) {
    this.tipus = tipus;
    valor = tipus;
  }

  //Set valor. Retorna false si el set es 'ilegal' (canviar una cela fixe...)
  public void setValor (int valor) {
    if (tipus == 0) {
      this.valor = valor;
    }
  }

  //Set tipus. Retorna true si s'ha efectuat un canvi de tipus de cela
  /*public boolean setTipus (int tipus) {
    if (this.tipus != tipus) {
      this.tipus = tipus;
      valor = tipus;
      return true;
    }
    this.tipus = tipus;
    valor = tipus;
    return false;
  } */

  public int getTipus() {
    return tipus;
  }

  public int getValor() {
    return valor;
  }

}