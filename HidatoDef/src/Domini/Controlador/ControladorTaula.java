package Domini.Controlador;

import Domini.Clases.Coord;
import Domini.Clases.Tauler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
/**
 * Classe contenidora d'informaciÃ³. Cada celÂ·la pren un valor i Ã©s d'un tipus determinat.
 * 
 * @author Carlos
 */
public class ControladorTaula {
	/*Controla totes les operacions de la taula: Soluciona tauler, genera etc..
        */
    
	    private Tauler tauler;/* Contindra el tauler sense solucionar */
            private Tauler tauler_partida;
	    private int[] numDonats, posInicial;/* dos vectors que utilitzara soluciona_aux sapiguer on começa i quins estan posats */
                                        
                                                        

	    
	    private Tauler tablero; /* tablero sobre el que buscaremos la solucion */
	    private Tauler solucion; /* tablero donde guardaremos la solucion */
	    private int nSols; /* numero de soluciones encontradas (como mucho dos) */
	    private int nRest; /* numero de casillas que me quedan por poner */
	    private boolean usado[]; /* usado[i] nos dice si el numero i + 1 esta colocado */
	    private int n; /* anchura del tablero */
	    private int m; /* altura del tablero */
	    private int maxCas; /* numero de la casilla mas grande */
            
           
            public ControladorTaula(){
                tauler = new Tauler();
                solucion = new Tauler();
            }
             /**
              * Escriu el tauler que se li pasa per parametre a consola. El punt '.' es un forat,
              * '_' una casella emplenable i altrament el numero de la casella
              * @param taulerCreat Tauler que volem escriure per consola
              * PRE: Se li passa un tauler no buit
              */
	    public void escriuTauler(Tauler taulerCreat) {     // S'ha de refer escriure per quan tinguem les classes cel·la i tauler
	        for (int i = 0; i < taulerCreat.sizeTauler(); ++i) {
	            for (int j = 0; j < taulerCreat.sizeTauler(); ++j) {
	                if (taulerCreat.getCela(i, j) == -1)
	                    System.out.print(" . ");
	                else
	                    System.out.printf(taulerCreat.getCela(i, j) > 0 ? "%2d " : "__ ", taulerCreat.getCela(i, j));
	            }
	            System.out.println();
	        }
	    }
	    /* POST: El tauler creat es guarda a la variable tauler */
            
            /**
              * Busca el numero de solucions que conte el 'tauler'
              * @param anchura conte la amplada del tauler
              * @param altura cont l'alçada del tauler
              * PRE: --
              */
	    public void BuscarSolucion(int anchura, int altura) {
	        n = anchura;
	        m = altura;
	        tablero = tauler.clonar();
	        solucion = null;
	        nSols = nRest = maxCas = 0;
	        usado = new boolean[altura*anchura];

	        for (int i = 0; i < altura*anchura; ++i)
	            usado[i] = false;

	        for (int i = 0; i < n; ++i) {
	            for (int j = 0; j < m; ++j) {
	                if (tablero.getCela(i, j) > 0) usado[tablero.getCela(i, j) - 1] = true;
	                else if (tablero.getCela(i, j) == 0) ++nRest;
	                maxCas = Math.max(maxCas, tablero.getCela(i, j));
	            }
	        }

	        backtrack();
	    }
             /* POST: S'actualitzen els diferents parametres com solucion que conte la solucio del hidato
            * i nSols que contindra el numero de solucions.
            */
	    
             /**
              * La idea es que en cada crida a bactraking, seleccionem la casella que te menys veins
              * buits i probem a ficarl-hi tots els posibles valors comprobant que es pugui resoldre. Quan nRest == 0,
              * augmentem el numero de solucions. Si en algun moment nRest == 2, parem l'execucio
              * ja que hem trobat que l'Hidato te mes d'una solucio.
              * PRE: --
              */
	    private void backtrack() {
	        if (nRest == 0) {
	            solucion = tablero.clonar();
	            ++nSols;
	        }
	        else {
	            int minI = 0;
	            int minJ = 0;
	            int minPosats = 10;

	            for (int i = 0; i < n; ++i) {
	                for (int j = 0; j < m; ++j) {
	                    if (tablero.getCela(i, j) == 0) {
	                        int nVolt = 0;
	                        int k1 = Math.max(0, i - 1);
	                        int k2 = Math.min(n - 1, i + 1);
	                        int s1 = Math.max(0, j - 1);
	                        int s2 = Math.min(m - 1, j + 1);

	                        for (int k = k1; k <= k2; ++k)
	                            for (int s = s1; s <= s2; ++s)
	                                if (tablero.getCela(k, s) == 0)
	                                    ++nVolt;

	                        if (nVolt < minPosats) {
	                            minPosats = nVolt;
	                            minI = i;
	                            minJ = j;
	                        }
	                    }
	                }
	            }

	            --nRest;
	            for (int k = 1; (nSols < 2) && (k < maxCas - 1); ++k) {
	                if(!usado[k]) {
	                    usado[k] = true;
	                    tablero.setCela(minI, minJ, k+1);

	                    if (fastCheck(minI, minJ) && deepCheck()) backtrack();

	                    tablero.setCela(minI, minJ, 0);
	                    usado[k] = false;
	                }
	            }
	            ++nRest;
	        }
	    }
	    /* POST: Intenta trobar mes d'una posible solucio per l'hidato
            */
            
             /* S'acaba de modificar la posicio (i,j) per tant ara hem de comprobar que aquesta sigui valida.
            * Es a dir, hem de mirar si el seu seguent i anterior siguin adjacens a ell en cas de que totes les 
            * del seu voltant siguin plenes. Tambe mira si, en cas de que tingui caselles lliures al seu voltant,
            * mira si el seu seguent esta ja a la taula, per tant false.
            * @param i posicio x en la taula
            * @param j posicio y en la taula
            /* PRE: Pos(i,j) es valida */
	    private boolean fastCheck(int i, int j) {

	        for (int k = Math.max(0, i - 1); k <= Math.min(n - 1, i + 1); ++k) {
	            for (int s = Math.max(0, j - 1); s <= Math.min(m - 1, j + 1); ++s) {
	                if (tablero.getCela(k,s) > 0) {
	                    boolean antFound = false;
	                    boolean sigFound = false;
	                    int nBuits = 0;

	                    int t1 = Math.max(0, k - 1);
	                    int t2 = Math.min(n - 1, k + 1);
	                    int r1 = Math.max(0, s - 1);
	                    int r2 = Math.min(m - 1, s + 1);

	                    for (int t = t1; t <= t2; ++t) {
	                        for (int r = r1; r <= r2; ++r) {
	                            if (tablero.getCela(t,r) == 0) ++nBuits;
	                            else if (tablero.getCela(t,r) == tablero.getCela(k,s) - 1)
	                                antFound = true;
	                            else if (tablero.getCela(t,r) == tablero.getCela(k,s) + 1)
	                                sigFound = true;
	                        }
	                    }

	                    if (nBuits == 1 && tablero.getCela(k,s) > 1 && tablero.getCela(k,s) < maxCas &&
	                      !antFound && !sigFound) return false;
	                    else if (nBuits == 0) {
	                        if (tablero.getCela(k,s) == 1) {
	                            if (!sigFound) return false;
	                        }
	                        else if (tablero.getCela(k,s) == maxCas) {
	                            if (!antFound) return false;
	                        }
	                        else if (!sigFound || !antFound) return false;
	                    }
	                    if (!antFound && tablero.getCela(k,s) > 1 && usado[tablero.getCela(k,s) - 2])
	                        return false;
	                    if (!sigFound && tablero.getCela(k,s) < maxCas && usado[tablero.getCela(k,s)])
	                        return false;
	                }
	            }
	        }
	        return true;
	    }
	    /* POST: Retorna true si es un valor valid en la posicio(i,j) en cas contrari retorna false.
            */
            
            
             /** Es un dfs per mirar si la distancia entre els numeros es mes gran que la permesa(es a dir,
              * si el 9 i el 7 son a mes distacia de 2 retorna false.
              * 
              * PRE: --
              */
	    private boolean deepCheck() {
	        int dist[][] = new int[n][m];

	        int ant = 0;
	        for (int k = 1; k < maxCas; ++k) {
	            if (usado[k]) {
	                Queue<Integer> cola = new LinkedList<Integer>();
	                int pos = 0;
	                for (int i = 0; i < n; ++i) {
	                    for (int j = 0; j < m; ++j) {
	                        if (tablero.getCela(i,j) == ant + 1) {
	                            pos = i*m + j;
	                            dist[i][j] = 0;
	                        }
	                        else dist[i][j] = n + m;
	                    }
	                }
	                cola.add(pos);
	                boolean ok = true;
	                while (ok && !cola.isEmpty()) {
	                    int val = cola.poll().intValue();
	                    int x = val/m;
	                    int y = val%m;
	                    int nuevaDist = 1 + dist[x][y];
	       
	                    for (int s = Math.max(0, x - 1); ok && s <= Math.min(n - 1, x + 1); ++s) {
	                        for (int t = Math.max(0, y - 1); ok && t <= Math.min(m - 1, y + 1); ++t) {
	                            if (tablero.getCela(s,t) == k + 1) {
	                                if (nuevaDist > k - ant) return false;
	                                ok = false;
	                            }
	                            else if ((tablero.getCela(s,t) == 0) && (nuevaDist < dist[s][t])) {
	                                dist[s][t] = nuevaDist;
	                                cola.add(s*m + t);
	                            }
	                        }
	                    }
	                }
	                if (ok) return false;
	                ant = k;
	            }
	        }
	        return true;
	    }
            /* POST: Retorna true si en el dfs totes les distancies entre els numeros son valides, altrament false;
            */
            
            /**
              * Genera un Tauler, utilitzant el metode de "kings path", consisteix en partir desde una posicio a l'atzar i
              * anar ficant els seguents numeros en el vei amb menys caselles lliures. En cas d'empat, s'agafa a l'atzar.
              * Si falla, torna a començar en una altre posicio a l'atzar. Despres crida a una altre funcio per buidar caselles
              * @param costat Tamany del tauler
              * @param numInicials Numero de numerus que l'usuari vol
              * @param forats Numero de forats que l'usuari vol
              * PRE: -- 
              */
	    
	    public void generaTauler(int costat, int numInicials, int forats) {
	    	 int numMaxim = costat*costat - forats;
	    	 Coord posInicialProvisional = new Coord();
	         Coord coordenadaAux = new Coord();
	         List<Coord> conjuntGeneratPos = new ArrayList<Coord>();
	         List<Integer> conjuntGenerat = new ArrayList<Integer>();
	         Tauler taulerGenerat = new Tauler(costat);
	         Tauler taulerGeneratAux = new Tauler(costat);
	        
	         Random rand = new Random();
	         int veins[][] = new int [costat][costat];
	         int num_posar = 0;

	         //FER FORATS
	         boolean tauler_correcte = false;
	         while(!tauler_correcte){
		         //do while....
	        	 taulerGeneratAux = taulerGenerat.clonar();
	        	 conjuntGenerat.clear();
		         init_matriu(veins, 0);
		         init_veins(veins,taulerGeneratAux); // inicialitza numero de veis de cada numero
		         int posx, posy;
			     do{
			         posx = rand.nextInt(costat);
			         posy = rand.nextInt(costat);
			         coordenadaAux.x = posx;
			         coordenadaAux.y = posy;
			     }while(taulerGeneratAux.getCela(posx, posy) != 0 && !conjuntGeneratPos.contains(coordenadaAux));
			     
		         conjuntGeneratPos.add(coordenadaAux);
		         posInicialProvisional.x = posx; //posicio del 1
		         posInicialProvisional.y = posy;
		         
		         num_posar = 1;
		         boolean pathing = true;
		         
		         while(pathing){
		        	 taulerGeneratAux.setCela(coordenadaAux.x, coordenadaAux.y, num_posar);
		        	 conjuntGenerat.add(num_posar);
		        	 if(veins_accesibles(coordenadaAux.x,coordenadaAux.y,taulerGeneratAux) || num_posar == numMaxim) pathing = false;
		        	 else{
		        		 conjuntGeneratPos.clear();
		        		 act_veins(coordenadaAux.x,coordenadaAux.y,veins,taulerGeneratAux,conjuntGeneratPos);
		        		 int aux_Random = rand.nextInt(conjuntGeneratPos.size());
		        		 coordenadaAux = conjuntGeneratPos.get(aux_Random);
		        		 ++num_posar;
		        	 }
		        
		         }
		         if(num_posar == numMaxim) tauler_correcte = true; //Tauler correcte, pasem a treure numeros.
		         
	         }//fi while
	         posInicial = new int[]{posInicialProvisional.x, posInicialProvisional.y};
	         //TREURE NUMEROS fins NUMINICIALS SI ES POT O FINS QUE TROBEN MES DE 1 SOLUCIO*/
	         
	         quita_nums2(numInicials, num_posar, numMaxim,taulerGeneratAux);
	         
	         Collections.sort(conjuntGenerat);
                 /*
	         numDonats = new int[conjuntGenerat.size()];
	         for (int i = 0; i < numDonats.length; i++)
	             numDonats[i] = conjuntGenerat.get(i);
                 */
	         tauler = taulerGeneratAux;
                 escriuTauler(tauler);
	         
	    }
	     /* POST: tauler conte el nou tauler generat amb les caselles buides
            */
	    
             /**
              * Quita_nums treu els numeros que pot, triats a l'atzar, comprobant sempre que tingui mennys de dos solucions.
              * 
              * @param costat Tamany del tauler
              * @param numInicials Numero de numerus que l'usuari vol
              * @param num_posats Numero de numeros al tauler
              * @param numMaxim Numero maxim de la tauler
              * @param taulerGenerat Tauler a modificar
              * PRE: -- 
              */
	    private void quita_nums2(int num_inicials, int num_posats, int numMaxim, Tauler taulerGenerat){
	    	int tam = taulerGenerat.sizeTauler();
	    	Random rand = new Random();
	    	Coord auxCoord = new Coord();
	    	int intents = 0;
	    	List<Coord> conjuntGeneratPos = new ArrayList<Coord>();
                List<Integer> conjuntGenerat = new ArrayList<Integer>();
	    	while(num_inicials < num_posats && intents < 10){
	    		int posx, posy;
	    		do{
	    			posx = rand.nextInt(tam);
                                posy = rand.nextInt(tam);
	    			auxCoord.x = posx;
	    			auxCoord.y = posy;
	    			
	    			++intents;
	    		}while((taulerGenerat.getCela(posx, posy) == 1 || taulerGenerat.getCela(posx, posy) == numMaxim || taulerGenerat.getCela(posx, posy)== -1 
	    				|| conjuntGeneratPos.contains(auxCoord)) && (intents < 5 && num_inicials < num_posats));
                        
	    		if(taulerGenerat.getCela(posx, posy) != 1 && taulerGenerat.getCela(posx, posy) != -1 && taulerGenerat.getCela(posx, posy) != numMaxim){
                            int numRetorn = taulerGenerat.getCela(posx, posy);
                            taulerGenerat.setCela(posx, posy, 0);
	    		
                            tauler = taulerGenerat;
                            BuscarSolucion(tam, tam);
                            if(nSols > 1){
                                    taulerGenerat.setCela(posx, posy, numRetorn);
                                    ++intents;
                                    conjuntGeneratPos.add(auxCoord);
                            }
                            else {
                                    num_posats--;
                                    intents = 0;
                            }
                        }
	    	}
                 for(int i = 0; i < taulerGenerat.sizeTauler(); ++i) 
                      for(int j = 0; j < taulerGenerat.sizeTauler(); ++j) 
                           if(tauler.getCela(i, j) > 0 ) conjuntGenerat.add(tauler.getCela(i, j));
                 Collections.sort(conjuntGenerat);
                 
	         numDonats = new int[conjuntGenerat.size()];
	         for (int i = 0; i < numDonats.length; i++)
	             numDonats[i] = conjuntGenerat.get(i);
                 
	    	
	    }
             /* POST: Tauler valid amb les caselles buides corresponents
            */
	    
             /**
              * Veis_accesibles mira els veis a que pot accedir una casella(i,j)
              * 
              * @param i posicio x al tauler
              * @param j posicio y al tauler.
              * @param taulerGenerat Tauler a modificar
              * @return Retorna true si te algun vei accesible, si no false;
              * PRE: 'i' i 'j' son una posiico valida
              */
	    public static boolean veins_accesibles(int i, int j,Tauler taulerGenerat){
	    	int tamany = taulerGenerat.sizeTauler();
	    	int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	        int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
	    
	    	for (int it = 0; it < direccioVertical.length; ++it)
				if(i + direccioVertical[it] < tamany && i + direccioVertical[it] >= 0 &&
				j + direccioHoritzontal[it] < tamany && j + direccioHoritzontal[it] >= 0){
					if(taulerGenerat.getCela(i + direccioVertical[it], j + direccioHoritzontal[it]) == 0) return false;
				}
	    	return true;
	    }
             /* POST: Si no pot accedir a cap, retorna true, en cas contrari false.
            */
	    
             /**
              * Actualitza les distancies dels veis al modificar una posicio(i,j)
              * @param i posicio x al tauler
              * @param j posicio y al tauler.
              * @param taulerGenerat Tauler a modificar
              * @param veins matriu de tots els veins
              * PRE: 'i' i 'j' son una posiico valida
              */
	    
	    private void act_veins(int i, int j, int veins[][], Tauler taulerGenerat, List<Coord> conjuntGeneratPos){
	    	Coord auxCoord = new Coord();
	    	conjuntGeneratPos.clear();
	    	int valor = 9;
	    	int aux;
	    	int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	        int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
	    	for (int it = 0; it < direccioVertical.length; ++it)
				if(i + direccioVertical[it] < veins.length && i + direccioVertical[it] >= 0 &&
				j + direccioHoritzontal[it] < veins.length && j + direccioHoritzontal[it] >= 0){
					veins[i + direccioVertical[it]][j + direccioHoritzontal[it]] = veins[i + direccioVertical[it]][j + direccioHoritzontal[it]] - 1;
					aux = veins[i + direccioVertical[it]][j + direccioHoritzontal[it]];
					if(veins[i + direccioVertical[it]][j + direccioHoritzontal[it]] < valor 
						&& taulerGenerat.getCela(i + direccioVertical[it], j + direccioHoritzontal[it]) == 0){ //Nomes si mes petit i no ja ha estat visitat
						valor = aux;
						conjuntGeneratPos.clear();
						auxCoord.x = i + direccioVertical[it];
						auxCoord.y = j + direccioHoritzontal[it];
						conjuntGeneratPos.add(auxCoord);
					}
					else if(veins[i + direccioVertical[it]][j + direccioHoritzontal[it]] == valor
						&& taulerGenerat.getCela(i + direccioVertical[it], j + direccioHoritzontal[it]) == 0){ //Nomes si no ja ha estat visitat
							auxCoord.x = i + direccioVertical[it];
							auxCoord.y = j + direccioHoritzontal[it];
							conjuntGeneratPos.add(auxCoord);
						
					}
				}
	    }
               /* POST: Actualitza els veins corresponents, amb -1 de distancia
            */
	    
             /**
              * init_matriu inicialitza una matriu al valor que es vulgui
              * @param matriu Matriu a inicialitzar
              * @param ini numero al que vol inicialitzar
              * PRE: --
              */
	    
	    private void init_matriu(int matriu[][], int ini){
	    	for(int i = 0; i < matriu.length; ++i)
	    		for(int j = 0; j < matriu[0].length; ++j)
	    			matriu[i][j] = ini;
	        
	    }
	     /* POST: Retorna matriu inicialitzada
            */
	    
             /**
              * init_veins Inicialitza tots els veis de la taula Taula_gen amb el numerod e veis que te cada 
              * posicio (i,j) de la taula
              * @param veins Matriu de numero de veins per posicio
              * @param tauler_Gen tauler sobre el cual comptar numerod e veins
              * PRE: --
              */
	    private void init_veins(int [][] veins, Tauler tauler_Gen){
	    	int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	        int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
	        
	    	for(int i = 0; i < veins.length; ++i)
	    		for(int j = 0; j < veins[0].length; ++j)
	    			for (int it = 0; it < direccioVertical.length; ++it)
	    				if(i + direccioVertical[it] < veins.length && i + direccioVertical[it] >= 0 &&
	    					j + direccioHoritzontal[it] < veins.length && j + direccioHoritzontal[it] >= 0)
	    					if(tauler_Gen.getCela(i + direccioVertical[it], j + direccioHoritzontal[it]) == 0) veins[i][j] += 1;
	    		
	    		
	    	
	    }
            
             /* POST: Retorna matriu de veis.
            */
	    
             /**
              * getSolucio, Retorna el tauler solucionat solucion
              * @return Retorna el tauler solucionat
              * PRE: --
              */
	    
	    public Tauler getSolucio(){
			return solucion;
	    }
             /**
              * getSolucio, Retorna el tauler per omplir
              * @return Retorna el tauler
              * PRE: --
              */
	    public Tauler getTauler(){
			return tauler;
	    }
            
             /**
              * Set de tauler
              * @param t  l'hi passa un tauler t
              * PRE: --
              */
            public void setTauler(Tauler t){
                tauler = t.clonar(); 
            }
            
            public Tauler getPartida(){
                return tauler_partida;
            }
            
            public void setPartida(Tauler t){
                tauler_partida = t.clonar(); 
            }
            
            public int[] getNumDonats(){
                return numDonats;
            }
            
	    public int[] getPosInicial(){
                return posInicial;
            }
            
            public void setNumDonats(int []numDonats){
                this.numDonats = numDonats;
            }
            
	    public void setPosInicial(int []posInicial){
                this.posInicial = posInicial;
            }
            
             /**
              * Transforma una tauler en una matriu de ints per a el controlador
              * @param t  l'hi passa un tauler t
              * @return Retorna la matriu de ints del tauler
              * PRE: --
              */
	      public int[][] transformar(Tauler t){
	    	int tam = t.sizeTauler();
	    	int[][] Matriu = new int[tam][tam];
	    	for(int i = 0; i < tam; ++i)
	    		for(int j = 0; j < tam; ++j)
	    			Matriu[i][j] = t.getCela(i, j);
	    	return Matriu;
	    			
	    }
              
          
	    
              
}