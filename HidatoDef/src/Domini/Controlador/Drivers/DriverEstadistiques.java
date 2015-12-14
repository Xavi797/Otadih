/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador.Drivers;

import Domini.Clases.Estadistiques;

/**
 *
 * @author jaume.guell
 */
public class DriverEstadistiques {
    public static void main(String[] args) {
        Estadistiques est = new Estadistiques(10, 5, 3333, 10000);
        
        System.out.println("Primer cop d'ull:");
        System.out.println((int) est.getnPartides());
        System.out.println((int) est.getnPartidesGuanyades());
        System.out.println((int) est.getPercentatgeGuanyades() + "%");
        System.out.println((int) est.getPuntuacioMaxima());
        System.out.println((int) est.getPuntuacioMitja());
        
        est.afegeixPartida();
        est.afegeixPartidaGuanyada(true);
        est.afegeixPuntuacio(3500);
        
        System.out.println("Segon cop d'ull:");
        System.out.println((int) est.getnPartides());
        System.out.println((int) est.getnPartidesGuanyades());
        System.out.println((int) est.getPercentatgeGuanyades() + "%");
        System.out.println((int) est.getPuntuacioMaxima());
        System.out.println((int) est.getPuntuacioMitja());
    }
}