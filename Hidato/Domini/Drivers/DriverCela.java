/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Drivers;

import Domini.Cela;

/**
 *
 * @author xavi
 */
public class DriverCela {
    public static void main (String[] args) {
        Cela cela = new Cela();
        cela.setTipus(-1);  //set cela com a forat
        int tipus = cela.getTipus();
        System.out.println(tipus + " El tipus setejat es -1 => forat");
        cela.setTipus(0);
        cela.setValor(20);  // set valor 20
        int valor = cela.getValor();
        System.out.println(valor + " El valor setejat es 20");
    } 
}
