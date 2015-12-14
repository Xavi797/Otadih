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
    private List<Integer> conjuntPropers;
    private Tauler tauler_partida;
    private Tauler sol;
    private int maxTauler;
    
    public Tauler getTauler_partida() {
        return tauler_partida;
    }
    
    /**
    * Funcio publica encarregada de cridar a la funcio juga_aux per entrar en la funcio juga.
    * PRE: -- 
    * POST: Si la partida queda a mitjes, al tauler tauler_partida esta la partida
    * @param t Tauler que se l'hi passa per jugar
    * @param sol Tauler solucionat del tauler t
    */
    public void juga(Tauler t, Tauler sol){
        cT = new ControladorTaula();
        conjuntPosibles = new ArrayList<Integer>();
        conjuntUsats = new ArrayList<Integer>();
        conjuntPropers = new ArrayList<Integer>();
        this.sol = sol;
        maxTauler = cT.getMax(t);
        juga_aux(t);
    }
    
    /**
    * Funcio encarregada de gestionar la partida.
    * PRE: -- 
    * POST: Si la partida queda a mitjes, al tauler tauler_partida esta la partida
    * @param t1 Tauler que se l'hi passa per jugar
    */
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
 //Ajudes aquiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii
                            //posibles(i,j,tauler_partida);
                            //proba(i,j,tauler_partida);
                            ajudaPropers(tauler_partida);
                            System.out.println("Posibles numeros a posar en el tauler: ");
                            for (int auxCont = 0; auxCont < conjuntPropers.size(); ++auxCont){
                                System.out.printf(" " + conjuntPropers.get(auxCont));   
                            }
                            System.out.println();
                            System.out.println("Indica el valor: ");
                            int val = in.nextInt();
                            if (!conjuntPropers.contains(val)) {
                                System.out.println("Valor no valid, torna a començar el proces");
                            }
                            
                            else if(bencolocat(i,j,val,tauler_partida)) {
                                int aux_val = tauler_partida.getCela(i, j);
                                if(tauler_partida.ModificaCela(i, j, val)){
                                    System.out.println("Cela modificada correctament");
                                    conjuntUsats.add(val);
                                    for(int auxUsats = 0; auxUsats < conjuntUsats.size(); ++auxUsats)
                                        if(conjuntUsats.get(auxUsats) == aux_val) conjuntUsats.remove(auxUsats);
                                }
                                else System.out.println("Incorrecte!!!");
                            }
                            else{
                                System.out.println("El numero que has posat no es adjacent al seu seguent"
                                        + "i/o anterior");
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
    
            /**
            * Funcio encarregada de mirar si el tauler esta tot emplenat. Mira
            * que cada posicio contingui un valor o un forat.
            * PRE: -- 
            * @return Retorna true si el tauler esta ple
            * @param t Tauler que se l'hi passa per sapigue si es ple
            */
            private boolean acabat (Tauler t){
                  for (int i = 0; i < t.sizeTauler(); ++i)
                      for (int j = 0; j < t.sizeTauler(); ++j)
                           if (t.getCela(i, j) == 0) return false;
                  return true;
            }
            
            /**
            * Funcio encarregada de mirar si el tauler esta ben solucionat, 
            * comprobant que cada posicio del tauler t coincideix amb el solucionat
            * PRE: -- 
            * @return Retorna true si el tauler esta ben solucionat
            * @param t Tauler que se l'hi passa per sapigue si es correcte
            */
            private boolean bensolucionat(Tauler t){
                  for (int i = 0; i < t.sizeTauler(); ++i)
                      for (int j = 0; j < t.sizeTauler(); ++j)
                           if (t.getCela(i, j) != sol.getCela(i, j)) return false;
                  return true;
            }
            
            /**
            * Funcio encarregada de mirar si una cela concreta(i,j) es correcte,
            * comprobant amb el Tauler solucionat.
            * PRE: -- 
            * @return Retorna true si la cela es correcte
            * @param i Conte la posicio de la fila de la cela que es vol mirar
            * @param j Conte la posicio de la columne de la cela que es vol mirar
            * @param t Tauler que se l'hi passa per sapigue si una cela es correcte
            */
            private boolean celaCorrecta(int i, int j, Tauler t){
                if(i < 0 || j <0 || i >= t.sizeTauler() || j >= t.sizeTauler()) return false;
                if(t.getCela(i, j) != sol.getCela(i, j)) return false;
                return true;
            }
            
             /**
            * Funcio encarregada de mirar tots els posibles valors que es poden
            * posar el la casella (i,j), per al tauler t, sense violar cap condicio
            * del hidato
            * PRE: -- 
            * POST: conjuntPosibles conte tots els valors que es poden ficar a 
            * la casella (i,j)
            * @param i Conte la posicio de la fila de la cela que es vol mirar
            * @param j Conte la posicio de la columne de la cela que es vol mirar
            * @param t Tauler que se l'hi passa per sapigue tots els posibles valors
            */
            private void posibles(int i, int j, Tauler t){   
                 conjuntPosibles.clear();
                 conjuntPosibles.add(0);
                 int tam = t.sizeTauler(); 
                 int dist[][] = new int [tam][tam];
                 int vis[][] = new int [tam][tam];

                 
                 
                  for (int aux = 2; aux < maxTauler; ++aux){
                        t.ModificaCela(i, j, aux);
                        init(dist,vis);
                        bfs(i,j,dist,t,vis);
                        for(int ax = 0; ax < tam; ++ax){
                            for(int ay = 0; ay < tam; ++ay)
                                System.out.print(" " + dist[ax][ay]);
                            System.out.println();
                        }  
                        if(propers(i,j,t) && dfs_posibles(dist,aux,t) && !conjuntUsats.contains(aux))
                            conjuntPosibles.add(aux);
                 }                 
                 t.ModificaCela(i, j, 0);
                          
            }
            
             /**
            * Funcio encarregada de inicialitzar els numeros del tauler t que ja
            * estan ficats.
            * PRE: -- 
            * POST: conjuntUsats conte tots els valors inicials del tauler t
            * @param t Tauler que se l'hi passa per sapigue tots els valors inicials.
            */
            private void iniciaUsados(Tauler t){
                for(int i = 0; i < t.sizeTauler(); ++i){
                    for(int j = 0; j < t.sizeTauler(); ++j){
                        int aux = t.getCela(i, j);
                        if(aux > 0) conjuntUsats.add(aux);
                    }
                }
            }
          
        /**
        * Funcio encarregada de mirar si totes les distancies al valor x 
        * son valides.
        * PRE: -- 
        * @param dist Matriu de distancies del tauler t, desde una certa posicio
        * @param t Tauler que se l'hi passa per sapigue tots els valors inicials.
        * @param x Valor del numero del qual s'ha fet la matriu de distancies.
        * @return Retorna true si la distancia entre tots els numeros del tauler
        * i el seu valor es correcte.
        */    
        public boolean dfs_posibles(int dist[][], int x, Tauler t){
             for(int auxi = 0; auxi < dist.length; ++auxi)
                for(int auxj = 0; auxj < dist[0].length; ++auxj){
                    int num = t.getCela(auxi, auxj);
                    if(num > 0){
                        int dis_max = num - x;
                        if(dis_max < 0)dis_max = dis_max *-1;
                        if(dis_max < dist[auxi][auxj]) return false;
                    }
             }
                      return true;  
        }
        
        /**
        * Funcio encarregada de mirar si tots els valors al voltant de la posicio
        * (i,j) son valids, es a dir, retornara false en cas de que incompleixi 
        * alguna condicio de un hidato valid.
        * PRE: -- 
        * @param i Conte la posicio de la fila de la cela que es vol mirar
        * @param j Conte la posicio de la columne de la cela que es vol mirar
        * @param t Tauler que se l'hi passa per sapigue tots els valors inicials.
        * @return Retorna true si compleix la condicio d'un hidato valid.
        */    
        public boolean propers(int i, int j, Tauler t){
            int tam = t.sizeTauler();
            boolean post,ant;
            post = ant = false;
            int veins_lliures = 0;
            int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	    int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};

                for (int aux = 0; aux < direccioVertical.length; ++aux){
                    if(i + direccioHoritzontal[aux] >= 0 && i + direccioHoritzontal[aux] < tam 
                      && j + direccioVertical[aux] >= 0 && j + direccioVertical[aux] < tam ){
                        int val = t.getCela(i + direccioHoritzontal[aux], j + direccioVertical[aux]);
                        if(val == 0) ++veins_lliures;
                        if(val == (t.getCela(i, j)-1)) ant = true;
                        else if(val == (t.getCela(i, j)+1)) post = true;
                    }
                }
                if(veins_lliures == 0 && (!post || !ant)) return false;
                else if(veins_lliures == 1 &&(!post && !ant)) return false;
                return true;
        }
        
        /**
        * Funcio especifica que inicialitza les dues matrius per fer el dfs, 
        * la de distancies i la de caselles ja visitades.
        * PRE: -- 
        * POST: Inicialitza la matriu de distancies a -1 i la de visitats a 0.
        * @param dist Conte la matriu de distancies
        * @param vis Conte la matriu de caselles visitades
        */  
        public void init(int[][] dist,int[][] vis){
            for(int it = 0; it < dist.length; ++it){
                for(int it2 = 0; it2 < dist[0].length; ++it2){
                    dist[it][it2] = -1;
                    vis[it][it2] = 0;
                }
            }
        }
        
        /**
        * Funcio encarregada de fer el dfs, per a una certa posicio inicial (c1,c2).
        * PRE: -- 
        * POST: dist conte les distancies de la posicio inicial (c1, c2)
        * @param c1 Conte la posicio de la fila per fer el dfs.
        * @param c2 Conte la posicio de la columne per fer el dfs.
        * @param dist Conte la matriu de distancies
        * @param taulerGen Conte el tauler en el que es fara el dfs
        * @param taulerVis  Conte la matriu de caselles visitades
        */  
        public void bfs(int c1, int c2, int[][] dist, Tauler taulerGen, int [][] taulerVis){ //Coordenadas del nuevo numero
 

            Queue<Coord> q = new LinkedList<>();
            Coord aux = new Coord();
            aux.x = c1;
            aux.y = c2;
            q.add(aux);
            boolean trobat = false;
            dist[c1][c2] = 0;
            while(!trobat && !q.isEmpty()){
                Coord p = q.poll();
                int num_act = taulerGen.getCela(p.x, p.y);
                if(num_act != -1 && taulerVis[p.x][p.y] == 0){
                    taulerVis[p.x][p.y] = 1;
                    bfs_aux(p.x-1,p.y,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                    bfs_aux(p.x+1,p.y,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                    bfs_aux(p.x,p.y+1,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                    bfs_aux(p.x,p.y-1,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                                                                        //diagonales tambien
                    bfs_aux(p.x-1,p.y-1,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                    bfs_aux(p.x+1,p.y+1,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                    bfs_aux(p.x-1,p.y+1,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                    bfs_aux(p.x+1,p.y-1,dist[p.x][p.y],q,taulerGen,dist,taulerVis,num_act);
                }
            } 
        }

        /**
        * Funcio auxiliar que ficara a la cua la nova posicio en cas de que sigui valida,
        * i augmentara la distancia de la posicio (i,j).
        * PRE: -- 
        * @param i Conte la posicio de la fila per fer el dfs.
        * @param j Conte la posicio de la columne per fer el dfs.
        * @param d Distancia de la posicio anterior a (i,j)
        * @param q Conte la cua de totes les posicions a fer el check
        * @param dist Conte la matriu de distancies
        * @param taulerGen Conte el tauler en el que es fara el dfs
        * @param taulerVis  Conte la matriu de caselles visitades
        * @param num_act Conte el valor del numero anterior a (i,j)
        */  
        public void bfs_aux(int i, int j, int d ,Queue<Coord> q, Tauler taulerGen, int[][] dist, int [][] taulerVis, int num_act){
            Coord aux2 = new Coord();
            aux2.x = i;
            aux2.y = j;

            if(i >= 0 && i < taulerGen.sizeTauler() && j >= 0 && j < taulerGen.sizeTauler()){
                int num = taulerGen.getCela(i, j);
                if((num == 0 || num == num_act + 1 || num == num_act - 1)  && taulerVis[i][j] == 0){
                    q.add(aux2);
                    if(dist[i][j] == -1)dist[i][j] = d+1;
                }
            }

        }
        /*
        public void proba(int i, int j,Tauler t){
            ControladorGenera cGen= new ControladorGenera();
            conjuntPosibles.clear();
            conjuntPosibles.add(0);
            cGen.prueba(i, j, t, conjuntPosibles);
        }
        */

        public void ajudaPropers(Tauler t){
            conjuntPropers.clear();
            conjuntPropers.add(0);
            int num, ant, post;
            for (int i = 0; i< conjuntUsats.size(); ++i){
                num = conjuntUsats.get(i);
                post = num +1;
                ant = num -1;
                if(post < maxTauler && !conjuntUsats.contains(post) && !conjuntPropers.contains(post)) conjuntPropers.add(post);
                if(ant > 1 && !conjuntUsats.contains(ant) && !conjuntPropers.contains(ant)) conjuntPropers.add(ant);
            }
            Collections.sort(conjuntPropers);
        }
        
        public boolean bencolocat(int i, int j, int val, Tauler t){
            int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	    int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
            if(conjuntUsats.contains(val+1)){
                boolean aux2 = false;
                for (int auxi = 0; auxi < direccioVertical.length; ++auxi)
                    if(i+ direccioVertical[auxi] >=  0 && i+ direccioVertical[auxi] < t.sizeTauler()
                        && j + direccioHoritzontal[auxi] > 0 && j + direccioHoritzontal[auxi] < t.sizeTauler())
                            if(t.getCela(i+ direccioVertical[auxi], j + direccioHoritzontal[auxi]) == val+1)
                                aux2= true;
                
                if(aux2 == false) return false;
            }
            if(conjuntUsats.contains(val-1)){
                boolean aux3 = false;
                for (int auxj = 0; auxj < direccioVertical.length; ++auxj){
                    if(i+ direccioVertical[auxj] >=  0 && i+ direccioVertical[auxj] < t.sizeTauler()
                        && j + direccioHoritzontal[auxj] > 0 && j + direccioHoritzontal[auxj] < t.sizeTauler())
                            if(t.getCela(i+ direccioVertical[auxj], j + direccioHoritzontal[auxj]) == val-1)
                                aux3= true;
                }
                if(aux3 == false) return false;
            }
            return true;
        }
    }