package Domini.Clases;

import Persistencia.Serialitzador;
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
        final ControladorTaula controlador = new ControladorTaula();
        ControladorJuga cJ = new ControladorJuga();
        ControladorCrea cC = new ControladorCrea();
        ControladorSoluciona cS = new ControladorSoluciona();
        //Menu
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        //Obtenim un objecte de la classe serialitzadora
        Serialitzador s = new Serialitzador();
        String nom = "";
        
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
                    System.out.println("Indica el Tamany del tauler(un costat nomes) ");
                    int costat = in.nextInt();
                    cC.crea(controlador,costat);
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
                            int[][] matriu = controlador.transformar(controlador.getTauler());
                            vistaJugar.createBoard(matriu);
                        }
                    }); 
                    break;
                case 3:
                    System.out.println("Escriu el nom del fitxer a guardar:");
                    nom = in.next();
                    s.serialitzarObjecte(controlador.getTauler(), nom, "Tauler");
                    break;
                case 4:
                    System.out.println("Escriu el nom del fitxer a carregar:");
                    nom = in.next();
                    Tauler tauler = (Tauler) s.deserialitzarObjecte(nom, "Tauler");
                    controlador.setTauler(tauler);
                    break;
                case 5: 
                    cJ.juga(controlador);
                    break;
                case 6: 
                    cS.soluciona(controlador);
                    break;
                case 7: 
                    System.out.println("Escriu el nom del fitxer a destruir:");
                    nom = in.next();
                    boolean dest = s.destrueixObjecte(nom, "Tauler");
                    if (dest) System.out.println("Objecte destruit");
                    else System.out.println("Objecte no destruit");
                    break;
            }
        }
        

    }
}

