package hidato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;



public class controladorTauler {
	
    private static int[][] tauler;
    private static int[] numDonats, posInicial;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int ordre = -1;

        while (ordre != 3) {
            System.out.println("Dona'm ordres:0 =>Predefinit 1 => Genera, 2 => Soluciona, 3 => Surt");
            ordre = in.nextInt();

            switch (ordre) {
                case 0: 
                
                case 1:
                    System.out.println("Indica la dimensió del tauler");
                    int costat = in.nextInt();

                    System.out.println("Indica la cuantitat de numero incials de l'hidato, minim 2");
                    int numInicials = in.nextInt();

                    generaTauler(costat, numInicials);
                    escriuTaluer();
                    break;

                case 2:
                    System.out.println("Solucio");
                    soluciona(posInicial[0], posInicial[1], 1, 0);
                    escriuTaluer();
                    break;

                case 3:
                    break;
            }
        }
    }


    public static boolean soluciona(int fila, int col, int n, int seguent) {
        System.out.println("valor n " + n);
        int dimensioTauler = tauler.length;
        if (fila<0 || col<0 || fila>dimensioTauler-1 || col>dimensioTauler-1)//si es fora del tauler surt
            return false;

        if (n > numDonats[numDonats.length - 1]) // si es mas grande que el utlimo sale
            return true;


        if (tauler[fila][col] != 0 && tauler[fila][col] != n)//si ya esta agafada la posicio i no es el nou numero surt
            return false;

        if (tauler[fila][col] == 0 && numDonats[seguent] == n)//si no hi ha cap numero pero ya esta ficat a la taula
            return false;

        int numRetorn = tauler[fila][col];
        if (numRetorn == n) //si el del tauler es igual al que poso incremento numdonats
            seguent++;

        tauler[fila][col] = n;
        int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i < direccioVertical.length; ++i)
            if (soluciona(fila + direccioHoritzontal[i], col + direccioVertical[i], n + 1, seguent))
                return true;

        tauler[fila][col] = numRetorn;
        return false;
    }

    public static void escriuTaluer() {     // S'ha de refer escriure per quan tinguem les classes cel·la i tauler
        for (int[] row : tauler) {
            for (int c : row) {
                if (c == -1)
                    System.out.print(" . ");
                else
                    System.out.printf(c > 0 ? "%2d " : "__ ", c);
            }
            System.out.println();
        }
    }

    public static void generaTauler(int costat, int numInicials) { // S'haura d'optimitzar, a més s'ha d'afegir el nivell dificultat

        int numMaxim = costat*costat;
        Coord coordenadaAux = new Coord();
        int[][] taulerGenerat = new int[costat][costat];
        Random rand = new Random();
        List<Integer> conjuntPropers = new ArrayList<>(numInicials);
        List<Integer> conjuntGenerat = new ArrayList<>(numInicials);
        List<Coord> conjuntGeneratPos = new ArrayList<>(numInicials);
        conjuntGenerat.add(1);
        conjuntGenerat.add(numMaxim);

        int posx = rand.nextInt(costat);
        int posy = rand.nextInt(costat);
        coordenadaAux.x = posx;
        coordenadaAux.y = posy;
        conjuntGeneratPos.add(coordenadaAux);
        taulerGenerat[posx][posy] = 1;
        posInicial = new int[]{posx, posy}; //posicio del 1

        posx = rand.nextInt(costat);
        posy = rand.nextInt(costat);
        

        while (taulerGenerat[posx][posy] != 0) { //Posicio del numero maxim
                posx = rand.nextInt(costat);
                posy = rand.nextInt(costat);
            }
        taulerGenerat[posx][posy] = numMaxim;
        coordenadaAux.x = posx;
        coordenadaAux.y = posy;
        conjuntGeneratPos.add(coordenadaAux);

        
        for (int i=0; i<numInicials-2; ++i) {
        	int numRandom;
        	/*
            int numRandom = rand.nextInt(numMaxim -1) + 1;
            while (conjuntGenerat.contains(numRandom)) {
                numRandom = rand.nextInt(numMaxim -1) + 1;
            }*/
            //Ara mirarem si el numero generat random es a prop de cualsevol dels ya posats
            int dist[][] = new int [costat][costat];
            int vis[][] = new int [costat][costat];
	
            //fin pruebas
            boolean correcte;
            int numComp;
            do{
            	numRandom = rand.nextInt(numMaxim -1) + 1;
                while (conjuntGenerat.contains(numRandom)) {
                    numRandom = rand.nextInt(numMaxim -1) + 1;
                }
            	correcte = true;
            	posx = rand.nextInt(costat);
                posy = rand.nextInt(costat);
                if(taulerGenerat[posx][posy] != 0) correcte = false;
                else{
                	init(dist,vis);
                	bfs(posx,posy,dist,taulerGenerat,vis);
                	
                	for(int j = 0; j < conjuntGenerat.size(); ++j){
                		int numAux = conjuntGenerat.get(j);
                		Coord coordAux2 = conjuntGeneratPos.get(j);
                		if(numRandom > numAux) numComp = numRandom - numAux;
                    	else numComp = numAux - numRandom;
                    	if(numComp < dist[coordAux2.x][coordAux2.y]){
                    		correcte = false;
                    		System.out.println("jhokaaa?");
                    		//para que conjunt propers?
                    	}
                    }
                }

            }while(!correcte);
            
            coordenadaAux.x = posx;
            coordenadaAux.y = posy;
            conjuntGeneratPos.add(coordenadaAux);
            
            taulerGenerat[posx][posy] = numRandom;
            conjuntGenerat.add(numRandom);
            
        }

        Collections.sort(conjuntGenerat);
        numDonats = new int[conjuntGenerat.size()];
        for (int i = 0; i < numDonats.length; i++)
            numDonats[i] = conjuntGenerat.get(i);
        tauler = taulerGenerat;
    }
    
    public static void init(int[][] dist,int[][] vis){
    	for(int it = 0; it < dist.length; ++it){
        	for(int it2 = 0; it2 < dist[0].length; ++it2){
        		dist[it][it2] = -1;
        		vis[it][it2] = 0;
        	}
        }
    	
    }
    
    //devolver mejor vector con las distancias de todos?

	public static void bfs(int c1, int c2, int[][] dist, int [][] taulerGen, int [][] taulerVis){ //Coordenadas del nuevo numero

    	
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
            }*/ if(taulerGen[p.x][p.y] >= 0 && taulerVis[p.x][p.y] == 0){
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
    // ARREGLAR CON PARAMETROS CORRECTOS
    public static void bfs_aux(int i, int j, int d ,Queue<Coord> q, int [][] taulerGen, int[][] dist){
    	Coord aux2 = new Coord();
    	aux2.x = i;
    	aux2.y = j;
    	
    	if(i >= 0 && i < taulerGen.length && j >= 0 && j < taulerGen[0].length){
            if(taulerGen[i][j] >= 0){
            	q.add(aux2);
                dist[i][j] = d+1;
            }
        }
    	
    }
    

}