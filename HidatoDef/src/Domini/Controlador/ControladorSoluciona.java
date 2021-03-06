/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador;

import Domini.Clases.Tauler;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Controlador encarregat de solucionar un tauler donat.
 * @author Carlos
 */
public class ControladorSoluciona {
    
    ControladorTaula cT;
    Tauler solucio;
    private int[] numDonats, posInicial;
    
    public Tauler getSolucio() {
        return solucio;
    }

    public void setSolucio(Tauler solucio) {
        this.solucio = solucio;
    }

    public int[] getNumDonats() {
        return numDonats;
    }

    public void setNumDonats(int[] numDonats) {
        this.numDonats = numDonats;
    }

    public int[] getPosInicial() {
        return posInicial;
    }

    public void setPosInicial(int[] posInicial) {
        this.posInicial = posInicial;
    }

            /**
              * Funcio publica encarregadar de cridar a la funcio soluciona_aux per resoldre l'hidato.
              * S'ecarrega de preparar les dades sobre el tauler per resoldre.
              * PRE: -- 
              * @param t Tauler que se l'hi passa per resoldre
              * @return Retorna un bolea si el tauler es pot resoldre.
            */
	    public boolean soluciona(Tauler t){
                cT = new ControladorTaula();
                solucio = t.clonar();
                List<Integer> conjuntGenerats = new ArrayList<Integer> ();
           
                posInicial = new int[2];
                int max = 0;
                //this.numDonats = cT.getNumDonats();
                for (int i = 0; i < solucio.sizeTauler(); ++i) {
                    for (int j = 0; j < solucio.sizeTauler(); ++j) {
                        if (solucio.getTipus(i,j) >= 1) {
                            int aux = solucio.getCela(i,j);
                            if (aux == 1) posInicial = new int[] {i,j};
                            conjuntGenerats.add(aux);
                            ++max;
                        }
                    }
                }
                Collections.sort(conjuntGenerats);

                numDonats = new int [max];

                for (int i = 0; i < max; ++i) {
                    numDonats[i] = conjuntGenerats.get(i);
                }

                    //this.posInicial = cT.getPosInicial();
                    if(soluciona_aux(posInicial[0], posInicial[1], 1, 0)) {
                        //cT.escriuTauler(solucio);
                        return true;
                    }
                    return false;
	    }
             /** POST: Si te solucio, al tauler solucio es guarda el tauler resolt.
              * 
              */

            
              /**
              * Soluciona_aux, la idea es que partint de la posicio inicial(on esta l'1), 
              * fa crides recursives ficant el seguent valor valid, 
              * fins l'emplena, sempre que aquest numero no estigui ja possat.
              * @param fila Posicio de la fila (0....tamany tauler -1)
              * @param col Posicio de la columna (0....tamany tauler -1)
              * @param n Valor a ficar en la posicio(fila,col)
              * @param seguent Index que indica el seguent numero ficat a la taula que encara no hem arribat.
              * @return Retorna un valor booleÃ  que indica si s'ha trobat la solucio o no
              * PRE: -- 
              */
	    private boolean soluciona_aux(int fila, int col, int n, int seguent) {
	         int dimensioTauler = solucio.sizeTauler();
                 
                  if (n > numDonats[numDonats.length - 1]) // si es mas grande que el utlimo sale ya lleno tablero9
	             return true;
	         
	         if (fila<0 || col<0 || fila>dimensioTauler-1 || col>dimensioTauler-1)//si es fora del tauler surt
	             return false;
	         
	         if (solucio.getCela(fila, col) != 0 && solucio.getCela(fila, col) != n)//si ya esta agafada la posicio i no es el nou numero surt
	             return false;

	         if (solucio.getCela(fila, col) == 0 && numDonats[seguent] == n)//si no hi ha cap numero pero ya esta ficat a la taula
	             return false;
	         

	         int numRetorn = solucio.getCela(fila,col);
	         if (numRetorn == n) //si el del tauler es igual al que poso incremento numdonats
	             seguent++;

	         solucio.setCela(fila, col, n);
	         int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
	         int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
	         for (int i = 0; i < direccioVertical.length; ++i)
	             if (soluciona_aux(fila + direccioHoritzontal[i], col + direccioVertical[i], n + 1, seguent))
	                 return true;

	         solucio.setCela(fila, col, numRetorn);
	         return false;
	     }
	    /** POST: Al tauler solucio esta el tauler t solucionat si retorna true;
             * 
             */
    
}
