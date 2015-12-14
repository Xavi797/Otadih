/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador;

import Domini.Clases.Tauler;

/**
 *
 * @author Carlo
 */
public class ControladorDomini {
           /*Controla totes les operacions de la taula: Soluciona tauler, genera etc..
        */
            private ControladorJuga cJuga;
            private ControladorCrea cCrea;
            private ControladorSoluciona cSol;
            private ControladorGenera cGen;
            
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

            private int min; /* Minim de caselles posbiles a posar en el tauler */
            
           /**
            * Contructora que inicialitza els taulers i tots els controladors de les funcions
            * que necesitara.
            */
            public ControladorDomini(){
                tauler = new Tauler();
                solucion = new Tauler();
                cJuga = new ControladorJuga();
                cCrea = new ControladorCrea();
                cSol = new ControladorSoluciona();
                cGen = new ControladorGenera();
            }
            
            /**
             * Funcio que cridara al controlador TaulerCreat per a crear al tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void creaTauler(){
                cCrea.crea();
                tauler = cCrea.getTaulerCreat();
                if(cSol.soluciona(tauler)){
                    numDonats = cCrea.getNumDonats();
                    posInicial = cCrea.getPosInicial();
                    solucion = cSol.getSolucio().clonar();
                }
                else{
                    System.out.println("Tauler no valid!!!!");
                    tauler = null;
                }
            }
            
             /**
             * Funcio que cridara al controlador Controladorjuga per a jugar al tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void juga(){
                cJuga.juga(tauler,solucion);
                tauler_partida = cJuga.getTauler_partida();
            }
            
            /**
             * Funcio que cridara al controlador ControladorGenera per a generar un tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void generaTauler(int costat, int numInicials, int forats){
                cGen.generaTauler(costat, numInicials,forats);
                tauler = cGen.getTauler();
                solucion = cGen.getSolucion();
                nSols = cGen.getnSols();
                maxCas = cGen.getMaxCas();
                
            }
            
            /**
             * Funcio que cridara al controlador ControladorSoluciona per a solucionar el tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler solucionat.
             */
            public void soluciona(){
                cSol.soluciona(tauler);
                
            }
            
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
            
            public Tauler getTablero(){
		return tablero;
	    }
            
            public void setTablero(Tauler t){
                tablero = t; //cambiar esto tardara mucho si copio todo el rato
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
            
            
            public int getMaxCas() {
                return maxCas;
            }

            public void setMaxCas(int maxCas) {
                this.maxCas = maxCas;
            }
}
