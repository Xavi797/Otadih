/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Hidato {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner in = new Scanner(System.in);
        //Obtenim un objecte de la classe serialitzadora
        Serialitzador s = new Serialitzador();
        String directori = "";
        
        System.out.println("Entrem un tauler 3x3");
        Tauler tauler = new Tauler(3);
        for (int i = 0; i < tauler.sizeTauler() ; ++i) {
            for (int j = 0; j < tauler.sizeTauler(); ++j) {
                int x = in.nextInt();
                tauler.setCela(i, j, x);
            }
        }
        
        int ordre = 0;
        while (ordre != 4) {
            System.out.println("Ordre: 0--> triar directori(OBLIGAT EL PRIMER COP), 1 --> imprimir tauler, 2 --> guardar tauler, 3 --> carregar tauler, 4 --> sortir");
            ordre = in.nextInt();
            switch(ordre) {
                case 0:
                    System.out.println("Escriu el directori desitjat per fer la carrega o guardat necessari:");
                    directori = in.next(); //"C:\\Users\\usuario\\Desktop\\tauler.obj";
                    break;
                case 1:
                    escriuTauler(tauler);
                    break;
                case 2:
                    s.SerialitzarObjecte(tauler, directori);
                    System.out.println("Guardat correctament");
                    break;
                case 3:
                    tauler = (Tauler) s.DeserialitzarObjecte(directori);
                    System.out.println("Carregat correctamet");
                    break;
                case 4:
                    break;
            }
        }
    }
    
    public static void escriuTauler(Tauler t) {     // S'ha de refer escriure per quan tinguem les classes cel·la i tauler
        for (int i = 0; i < t.sizeTauler(); ++i) {
            for (int j = 0; j < t.sizeTauler(); ++j) {
                System.out.print(t.getCela(i, j));
            }
            System.out.println();
        }
    }
}
