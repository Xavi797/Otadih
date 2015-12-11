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
import Domini.Clases.Coord;
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
                    
                    if(continua == 1){
                        System.out.println("Vols sapiguer si una casella es ben colocada? 1(si), 0(no)");
                        int ajuda = in.nextInt();
                        if(ajuda == 1){
                            System.out.println("Indica la cela que vols consultar si es correcte (i, j): ");
                            int iaux = in.nextInt();
                            int jaux = in.nextInt();
                            if(celaCorrecta(iaux,jaux,tauler_partida)) System.out.println("Esta be!!!");
                            else System.out.println("Esta malament :( !!!");
                        }
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
                            System.out.println();
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
                                    for(int auxUsats = 0; auxUsats < conjuntUsats.size(); ++auxUsats)
                                        if(conjuntUsats.get(auxUsats) == aux_val) conjuntUsats.remove(auxUsats);
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
                 int tam = t.sizeTauler(); 
                 int dist[][] = new int [tam][tam];
                 int vis[][] = new int [tam][tam];
                 ControladorGenera cGen = new ControladorGenera();
                 //cGen.BuscaPosibles(i,j,t,conjuntPosibles,conjuntUsats);
                 init(dist,vis);
                 bfs(i,j,dist,t,vis);
                  for (int aux = 2; aux < cGen.getMaxCas(); ++aux){
                    if(!conjuntUsats.contains(aux)){
                        t.ModificaCela(i, j, aux);
                        if(propers(i,j,t) && dfs_posibles(dist,aux,t))
                            conjuntPosibles.add(aux);
                    }
                      //call a fastcheck y deepcheck con Tauler(i,j).setcela
                 }                 
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
            
            
            
        public boolean dfs_posibles(int dist[][], int x, Tauler t){
             for(int auxi = 0; auxi < dist.length; ++auxi)
                for(int auxj = 0; auxj < dist[0].length; ++auxj){
                    int dis_max = t.getCela(auxi, auxj) - x;
                    if(dis_max < 0)dis_max = dis_max *(-1);
                    //if(t.getCela(auxi, auxj) - dis_max < 0 && )
             }
                      return true;  
        }
        public boolean propers(int i, int j, Tauler t){
            boolean post,ant;
            post = ant = false;
            int veins_lliures = 0;
            int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	    int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};

                for (int aux = 0; aux < direccioVertical.length; ++aux){
                    int val = t.getCela(i + direccioHoritzontal[aux], j + direccioVertical[aux]);
                    if(val == 0) ++veins_lliures;
                    if(val == (t.getCela(i, j)-1)) ant = true;
                    else if(val == (t.getCela(i, j)+1)) post = true;
                }
                if(veins_lliures == 0 && (!post || !ant)) return false;
                else if(veins_lliures == 1 &&(!post && !ant)) return false;
                else return true;
        }
            
        public void init(int[][] dist,int[][] vis){
            for(int it = 0; it < dist.length; ++it){
                for(int it2 = 0; it2 < dist[0].length; ++it2){
                    dist[it][it2] = -1;
                    vis[it][it2] = 0;
                }
            }
        }
            
        public void bfs(int c1, int c2, int[][] dist, Tauler taulerGen, int [][] taulerVis){ //Coordenadas del nuevo numero
 

            Queue<Coord> q = new LinkedList<>();
            Coord aux = new Coord();
            aux.x = c1;
            aux.y = c2;
            q.add(aux);
            boolean trobat = false;

            while(!trobat && !q.isEmpty()){
                Coord p = q.poll();
         /* no para mai
                if(taulerGen[p.x][p.y] == num){
                    d = dist[p.x][p.y];
                    trobat = true;
                }*/ if(taulerGen.getCela(p.x, p.y) >= 0 && taulerVis[p.x][p.y] == 0){
                    taulerVis[p.x][p.y] = 1;
                    bfs_aux(p.x-1,p.y,dist[p.x][p.y],q,taulerGen,dist);
                    bfs_aux(p.x+1,p.y,dist[p.x][p.y],q,taulerGen,dist);
                    bfs_aux(p.x,p.y+1,dist[p.x][p.y],q,taulerGen,dist);
                    bfs_aux(p.x,p.y-1,dist[p.x][p.y],q,taulerGen,dist);
                                                                        //diagonales tambien
                    bfs_aux(p.x-1,p.y-1,dist[p.x][p.y],q,taulerGen,dist);
                    bfs_aux(p.x+1,p.y+1,dist[p.x][p.y],q,taulerGen,dist);
                    bfs_aux(p.x-1,p.y+1,dist[p.x][p.y],q,taulerGen,dist);
                    bfs_aux(p.x+1,p.y-1,dist[p.x][p.y],q,taulerGen,dist);
                }
            } 
        }

        public void bfs_aux(int i, int j, int d ,Queue<Coord> q, Tauler taulerGen, int[][] dist){
            Coord aux2 = new Coord();
            aux2.x = i;
            aux2.y = j;

            if(i >= 0 && i < taulerGen.sizeTauler() && j >= 0 && j < taulerGen.sizeTauler()){
                if(taulerGen.getCela(i, j) >= 0){
                    q.add(aux2);
                    dist[i][j] = d+1;
                }
            }

        }
    }