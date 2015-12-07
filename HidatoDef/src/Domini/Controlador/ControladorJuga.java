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
    private ControladorTaula cT;
    private List<Integer> conjuntPosibles;
    private List<Integer> conjuntUsats;
    private Tauler tauler_partida;
    private Tauler sol;
    
    
    public void juga(Tauler t, Tauler sol){
        cT = new ControladorTaula();
        conjuntPosibles = new ArrayList<Integer>();
        conjuntUsats = new ArrayList<Integer>();
        this.sol = sol;
        juga_aux(t);
    }
    
    private void juga_aux(Tauler t1) {
                Scanner in = new Scanner(System.in);
                
                int continua = 1;
                tauler_partida = t1.clonar();

                iniciaUsados(tauler_partida);
                while(!acabat(tauler_partida) && continua == 1) {
                    System.out.println("Estat actual del tauler:");
                    cT.escriuTauler(tauler_partida);
                    System.out.println("Vols continuar jugant(1) o sortir?(0)");
                    continua = in.nextInt();
                    System.out.println("Vols sapiguer si una casella es ben colocada? 1(si), 0(no)");
                    int ajuda = in.nextInt();
                    if(ajuda == 1){
                        System.out.println("Indica la cela que vols consultar si es correcte (i, j): ");
                        int iaux = in.nextInt();
                        int jaux = in.nextInt();
                        if(celaCorrecta(iaux,jaux,tauler_partida)) System.out.println("Esta be!!!");
                        else System.out.println("Esta malament :( !!!");
                    }
                    if(continua == 1){
                        System.out.println("Indica la cela que vols escriure (i, j): ");
                        int i = in.nextInt();
                        int j = in.nextInt();
                        
                        if (i < 0 || j < 0 || i > tauler_partida.sizeTauler()-1 || j > tauler_partida.sizeTauler()-1 || !tauler_partida.ModificaCela(i, j, 0)) {
                            System.out.println("Coordenades no valides, torna a començar el proces");
                        }
                        else{
                            posibles(i,j,tauler_partida);
                            System.out.println("Posibles numeros a posar en aquesta casella: ");

                            for (int auxCont = 0; auxCont < conjuntPosibles.size(); ++auxCont){
                                System.out.printf(" " + conjuntPosibles.get(auxCont));
                            }
                            System.out.println("Indica el valor: ");
                            int val = in.nextInt();
                            if (!conjuntPosibles.contains(val)) {
                                System.out.println("Valor no valid, torna a començar el proces");
                            }
                            else {
                                int aux_val = tauler_partida.getCela(i, j);
                                if(tauler_partida.ModificaCela(i, j, val)){
                                    System.out.println("Cela modificada correctament");
                                    conjuntUsats.add(val);
                                    conjuntUsats.remove(aux_val);
                                }
                                else System.out.println("Incorrecte!!!");
                            }
                        }
                    }
                }
                if(continua == 1){
                    if (bensolucionat(tauler_partida))
                        System.out.println("SOLUCIONAT CORRECTAMENT!");
                    else 
                        System.out.println("SOLUCIÓ ERRONEA");
                }
                else{
                    System.out.println("Vols guardar la partida?(1)si, 0(no)");
                }
            }
    

            private boolean acabat (Tauler t){
                  for (int i = 0; i < t.sizeTauler(); ++i)
                      for (int j = 0; j < t.sizeTauler(); ++j)
                           if (t.getCela(i, j) == 0) return false;
                  return true;
             }
              
            private boolean bensolucionat(Tauler t){
                  for (int i = 0; i < t.sizeTauler(); ++i)
                      for (int j = 0; j < t.sizeTauler(); ++j)
                           if (t.getCela(i, j) != sol.getCela(i, j)) return false;
                  return true;
            }
            
            private boolean celaCorrecta(int i, int j, Tauler t){
                if(i < 0 || j <0 || i >= t.sizeTauler() || j >= t.sizeTauler()) return false;
                if(t.getCela(i, j) != sol.getCela(i, j)) return false;
                return true;
            }
            
            private void posibles(int i, int j, Tauler t){   
                 conjuntPosibles.clear();
                 ControladorGenera cGen = new ControladorGenera();
                 cGen.BuscaPosibles(i,j,t,conjuntPosibles,conjuntUsats);
                 t.ModificaCela(i, j, 0);
                          
            }
            private void iniciaUsados(Tauler t){
                for(int i = 0; i < t.sizeTauler(); ++i){
                    for(int j = 0; j < t.sizeTauler(); ++j){
                        int aux = t.getCela(i, j);
                        if(aux > 0) conjuntUsats.add(aux);
                    }
                }
            }

            public Tauler getTauler_partida() {
                return tauler_partida;
            }
              
}