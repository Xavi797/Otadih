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
    List<Integer> conjuntPosibles;
    public void juga(ControladorTaula cT){
        this.cT = cT;
        conjuntPosibles = new ArrayList<Integer>();
        juga_aux();
    }
    
    private void juga_aux() {
                Scanner in = new Scanner(System.in);
                
                int continua = 1;
                Tauler t = cT.getTauler().clonar();
                cT.setTablero(t);
                while(!acabat(t) && continua == 1) {
                    System.out.println("Estat actual del tauler:");
                    cT.escriuTauler(t);
                    System.out.println("Vols continuar jugant(1) o sortir?(0)");
                    continua = in.nextInt();
                    System.out.println("Vols sapiguer si una casella es ben colocada? 1(si), 0(no)");
                    int ajuda = in.nextInt();
                    if(ajuda == 1){
                        System.out.println("Indica la cela que vols consultar si es correcte (i, j): ");
                        int iaux = in.nextInt();
                        int jaux = in.nextInt();
                        if(celaCorrecta(iaux,jaux,t)) System.out.println("Esta be!!!");
                        else System.out.println("Esta malament :( !!!");
                    }
                    if(continua == 1){
                        System.out.println("Indica la cela que vols escriure (i, j): ");
                        int i = in.nextInt();
                        int j = in.nextInt();
                        //llamar a fastCheck y a deepchek con 1 for por cada numero para saber cuales son validos. en la posicion (i,j)
                        
                        
                        
                        if (i < 0 || j < 0 || i > t.sizeTauler()-1 || j > t.sizeTauler()-1 || !t.ModificaCela(i, j, 0)) {
                            System.out.println("Coordenades no valides, torna a començar el proces");
                        }
                        else{
                            posibles(i,j,t);
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
                                if(t.ModificaCela(i, j, val)) System.out.println("Cela modificada correctament");
                                else System.out.println("Incorrecte!!!");
                            }
                        }
                    }
                }
                cT.setPartida(t);
                if(continua == 1){
                    if (bensolucionat(t))
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
                           if (t.getCela(i, j) != cT.getSolucio().getCela(i, j)) return false;
                  return true;
            }
            
            private boolean celaCorrecta(int i, int j, Tauler t){
                if(i < 0 || j <0 || i >= t.sizeTauler() || j >= t.sizeTauler()) return false;
                if(t.getCela(i, j) != cT.getSolucio().getCela(i, j)) return false;
                return true;
            }
            
            private void posibles(int i, int j, Tauler t){   
                 conjuntPosibles.clear();
                 int max = cT.getMaxCas(); //obtener max del tablero
                 for (int aux = 2; aux < max; ++aux){
                     t.ModificaCela(i, j, aux);
                     if(cT.fastCheck(i, j) && cT.deepCheck()) conjuntPosibles.add(aux);
                     
                      //call a fastcheck y deepcheck con Tauler(i,j).setcela
                 }
                      
                          
            }
              
}