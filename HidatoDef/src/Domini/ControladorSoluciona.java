/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author Carlo
 */
public class ControladorSoluciona {
    
    ControladorTaula cT;
    Tauler solucio;
    private int[] numDonats, posInicial;
         /**
              * Funcio publica encarregadar de cridar a la funcio soluciona_aux per resoldre l'hidato
              * PRE: -- 
              * @param cT Li passa el controlador taula per tenir el mateix tauler
              * @return Retorna un bolea si te solucio
              */
	    public boolean soluciona(ControladorTaula cT){
                this.cT = cT;
                solucio = cT.getSolucio();
                solucio = cT.getTauler().clonar();
                
                this.numDonats = cT.getNumDonats();
                this.posInicial = cT.getPosInicial();
	    	if(soluciona_aux(posInicial[0], posInicial[1], 1, 0)){
                    cT.escriuTauler(solucio);
                    return true;
                }
                return false;
	    }
             /* POST: Troba la solucio, s'hi te, i la guarda a solucion */

            
              /**
              * Soluciona_aux, la idea es que partint de la posicio inicial(on esta l'1), fa crides recursives ficant 
              * el seguent valor valid, fins l'emplena, sempre que aquest numero estigui
              * @param valor TÃ© per valor un nombre natural
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
	    /* POST: Troba la solucio, o diu que no te solucio en cas de que no la tingui */
    
}
