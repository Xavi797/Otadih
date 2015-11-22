/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador;

import Domini.Clases.Tauler;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
/**
 *
 * @author Carlos
 */
public class ControladorJuga {
    ControladorTaula cT;
    public void juga(ControladorTaula cT){
        this.cT = cT;
        juga_aux();
    }
    
    private void juga_aux() {
                Scanner in = new Scanner(System.in);
                int continua = 1;
                Tauler t = cT.getTauler().clonar();
                while(!acabat(t) && continua == 1) {
                    System.out.println("Estat actual del tauler:");
                    cT.escriuTauler(t);
                    System.out.println("Vols continuar jugant(1) o sortir?(0)");
                    continua = in.nextInt();
                    if(continua == 1){
                        System.out.println("Indica la cela que vols escriure (i, j): ");
                        int i = in.nextInt();
                        int j = in.nextInt();
                        System.out.println("Indica el valor: ");
                        int val = in.nextInt();
                        if (i < 0 || j < 0 || i > t.sizeTauler()-1 || j > t.sizeTauler()-1) {
                            System.out.println("Coordenades no valides, torna a començar el proces");
                        }
                        else if (val < 0 || val > t.sizeTauler()*t.sizeTauler()) {
                            System.out.println("Valor no valid, torna a començar el proces");
                        }
                        else {
                            if(t.ModificaCela(i, j, val)) System.out.println("Cela modificada correctament");
                            else System.out.println("Incorrecte!!!");
                        }
                    }
                }
                if(continua == 1){
                    if (bensolucionat(t))
                        System.out.println("SOLUCIONAT CORRECTAMENT!");
                    else 
                        System.out.println("SOLUCIÓ ERRONEA");
                }
            }
    

            public boolean acabat (Tauler t){
                  for (int i = 0; i < t.sizeTauler(); ++i)
                      for (int j = 0; j < t.sizeTauler(); ++j)
                           if (t.getCela(i, j) == 0) return false;
                  return true;
             }
              
            public boolean bensolucionat(Tauler t){
                  for (int i = 0; i < t.sizeTauler(); ++i)
                      for (int j = 0; j < t.sizeTauler(); ++j)
                           if (t.getCela(i, j) != cT.getSolucio().getCela(i, j)) return false;
                  return true;
            }
              
}