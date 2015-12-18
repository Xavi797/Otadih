package Domini.Controlador;


import Domini.Clases.Tauler;

/**
 * Controlador encarregat de gestionar la informacio dels taulers, cada cela pren un valor i es d'un tipus determinat.
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
	     /** POST: Retorna matriu inicialitzada
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
             /** POST: Retorna un tauler de ints, traduit del de celas,
              * on cada casella conte el valor.
             */

              /**
             * Obte el maxim numero del tauler t
             * @param t  l'hi passa un tauler t
             * @return Retorna el numero maxim (max) del tauler t
             * PRE: --
             */
             public int getMax (Tauler t){
                 int max = 0;
                 for(int i = 0; i < t.sizeTauler(); ++i)
                     for(int j = 0; j < t.sizeTauler(); ++j)
                          if(max < t.getCela(i, j)) max = t.getCela(i, j);
                 return max;
             }
             /** POST: Retorna el numero maxim (max) del tauler t
              *
              */

             /**
             * Obte el maxim numero teoric d'un tauler buit, que conta 
             * totes les caselles buides sense tenir en compte els forats
             * @param t  l'hi passa un tauler t
             * @return Retorna el maxim teoric del tauler t
             * PRE: --
             */
             public int getMaxPossible(Tauler t){
                 int max = 0;
                 for(int i = 0; i < t.sizeTauler(); ++i)
                     for(int j = 0; j < t.sizeTauler(); ++j)
                          if(t.getCela(i, j) != -1) max++;
                 return max;
             }
             
             /**
             * Transforma una matriu de ints en un tauler per defecte 
             * @param mat  matriu a transformar
             * @return Retorna el tauler t
             * PRE: --
             */
             public Tauler transformarInversa (int [][] mat){
                int tam = mat.length;
                Tauler t = new Tauler(mat.length);
                
                for(int i = 0; i < tam; ++i)
                    for(int j = 0; j < tam; ++j)
                        t.setCela(i, j, mat[i][j]);
                return t;
             }
     
}