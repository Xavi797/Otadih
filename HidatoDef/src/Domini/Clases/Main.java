package Domini.Clases;

import Persistencia.*;
import Domini.Controlador.*;
import Vistes.vistaJugar;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xavi
 */
public class Main {
    public static void main(String args[]) {

        /* Create and display the form */
        final ControladorDomini controlador = new ControladorDomini();
        final ControladorTaula controTaula = new ControladorTaula();
        //Menu
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        //Obtenim un objecte de la classe serialitzadora
        SerialitzadorPartides sP = new SerialitzadorPartides();
        String nom = "";
        String user = "";
        
        int ordre = -10;
        
        while (ordre != -1) {
            System.out.println("Tria un opcio:\n"
                    + "-1: Surt\n"
                    + "0: Crea un Tauler especificant tot //// 1: Genera un tauler nou\n"
                    + "2: Vista de jugar                  //// 3: Guarda partida/Hidato\n"
                    + "4: Carrega partida/Hidato          //// 5: Juga al tauler\n"
                    + "6: Soluciona el tauler             //// 7: Destrueix partida/Hidato\n");
            ordre = in.nextInt();
            switch(ordre) {
                case -1:
                    break;
                case 0:
                    
                    controlador.creaTauler();
                    break;
                case 1:
                    //si 5 <8>, si 6<13>, 7<16> mirar porque petan, no deberia
                    System.out.println("Indica el Tamany del tauler(un costat nomes)");
                    int l = in.nextInt();
                    System.out.println("Indica el numero de Numeros per defecte que vol al tauler\n"
                            + "Com a minim: "+ (l*l)/2);
                    int numInicial = in.nextInt();
                    controlador.generaTauler(l, numInicial, 0);
                    break;
                case 2:
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new vistaJugar().setVisible(true); 
                            int[][] matriu = controTaula.transformar(controlador.getTauler());
                            vistaJugar.createBoard(matriu);
                        }
                    }); 
                    break;
                case 3:
                    System.out.println("Escriu el nom del fitxer a guardar:");
                    nom = in.next();
                    System.out.println("Escriu el teu nom:");
                    user = in.next();
                    sP.serialitzarObjecte(controlador.getTauler(), nom, user);
                    break;
                case 4:
                    System.out.println("Escriu el nom del fitxer a carregar:");
                    nom = in.next();
                    System.out.println("Escriu el teu nom:");
                    user = in.next();
                    Tauler tauler = (Tauler) sP.deserialitzarObjecte(nom, user);
                    controlador.setTauler(tauler);
                    break;
                case 5: 
                    controlador.juga();
                    break;
                case 6: 
                    controlador.soluciona();
                    break;
                case 7: 
                    System.out.println("Escriu el nom del fitxer a destruir:");
                    nom = in.next();
                    System.out.println("Escriu el nom del fitxer a carregar:");
                    user = in.next();
                    boolean dest = sP.destrueixObjecte(nom, user);
                    if (dest) System.out.println("Objecte destruit");
                    else System.out.println("Objecte no destruit");
                    break;
            }
        }
        

    }
}

