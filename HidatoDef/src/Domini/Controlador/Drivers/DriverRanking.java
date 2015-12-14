/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador.Drivers;

import Domini.Clases.Rankings;

/**
 *
 * @author jaume.guell
 */
public class DriverRanking {
    public static void main(String[] args) {
        
        Rankings rank = new Rankings();
        rank.afegeix("Jaume", 1000);
        rank.afegeix("Carlos", 1200);
        rank.afegeix("Xavi", 1100);
        
        for (int i = 0; i < rank.mida(); ++i) {
            System.out.println(rank.getUsuari(i) + " " + rank.getPunts(i));
        }
    }
}
