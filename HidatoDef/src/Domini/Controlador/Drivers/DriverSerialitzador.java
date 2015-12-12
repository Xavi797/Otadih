/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador.Drivers;

import Persistencia.SerialitzadorDades;
import Persistencia.SerialitzadorPartides;

/**
 *
 * @author jaume.guell
 */
public class DriverSerialitzador {
    
    public static void main (String[] args) {
        SerialitzadorDades sDades = new SerialitzadorDades();
        SerialitzadorPartides sPartides = new SerialitzadorPartides();
        
        
    }
}
/*
    public static void main (String[] args) {
        SerialitzadorTaulers sT = new SerialitzadorTaulers();
        Tauler t = new Tauler(1);
        
        //Creem dos taulers diferents i els guardem
        t = new Tauler(3); //Tauler 3x3
        sT.guardar(t.getTauler(), "tauler3x3");
        t = new Tauler(5); //Tauler 5x5
        sT.guardar(t.getTauler(), "tauler5x5");
        
        int cas = -1;
        while (cas != 0) {
            System.out.println("Indica quin tauler carregar: 1 -> tauler3x3 // 2 -> tauler5x5 // 3 -> escriu el size del tauler ");
            System.out.println("0 per sortir");
            switch(cas) {
                case 0:
                    break;
                case 1:
                    t = (Tauler) sT.carregar("tauler3x3");
                    break;
                case 2:
                    t = (Tauler) sT.carregar("tauler5x5");
                    break;
                case 3:
                    int size = t.sizeTauler();
                    System.out.println("El size del tauler carregat es:" + size);
                    break;
            }
        }
        
    }*/