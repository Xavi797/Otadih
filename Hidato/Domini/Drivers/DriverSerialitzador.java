/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Drivers;

import Persistencia.Serialitzador;
import Domini.Tauler;

/**
 *
 * @author jaume
 */
public class DriverSerialitzador {
    public static void main (String[] args) {
        Serialitzador s = new Serialitzador();
        Tauler t = new Tauler(1);
        
        //Creem dos taulers diferents i els guardem
        t = new Tauler(3); //Tauler 3x3
        s.SerialitzarObjecte(t.getTauler(), "tauler3x3");
        t = new Tauler(5); //Tauler 5x5
        s.SerialitzarObjecte(t.getTauler(), "tauler5x5");
        
        int cas = -1;
        while (cas != 0) {
            System.out.println("Indica quin tauler carregar: 1 -> tauler3x3 // 2 -> tauler5x5 // 3 -> escriu el size del tauler ");
            System.out.println("0 per sortir");
            switch(cas) {
                case 0:
                    break;
                case 1:
                    t = (Tauler) s.DeserialitzarObjecte("tauler3x3");
                    break;
                case 2:
                    t = (Tauler) s.DeserialitzarObjecte("tauler5x5");
                    break;
                case 3:
                    int size = t.sizeTauler();
                    System.out.println("El size del tauler carregat es:" + size);
                    break;
            }
        }
        
    }
}