/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador.Drivers;

import Domini.Clases.Tauler;

/**
 *
 * @author xavi
 */
public class DriverTauler {
    public static void main(String[] args){
        Tauler tauler = new Tauler(10);
        System.out.println("Dimensio del tauler" + tauler.sizeTauler());
        for(int i = 0; i <tauler.sizeTauler(); ++i){
            System.out.println();
            for(int j = 0; j <tauler.sizeTauler(); ++j){
                System.out.print(tauler.getCela(i, j));
            }
        }
    }
}
