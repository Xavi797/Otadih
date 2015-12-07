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