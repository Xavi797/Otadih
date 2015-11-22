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
import java.util.Scanner;

/**
 * @author Carlos
 */
public class ControladorCrea {
 /** @author Carlos */
     ControladorTaula cT;
    private int[] numDonats, posInicial;
    
    public void crea(ControladorTaula cT,int costat){
        this.numDonats = cT.getNumDonats();
        this.posInicial = cT.getPosInicial();
        this.cT = cT;
        crea_aux(costat);
    }
    
     /**
              * La idea es que l'usuari crei el tauler com ell vol, i pot rectificar decisions 
              * @param costat Tamany del tauler
              * PRE: -- 
              */
    private void crea_aux(int costat) {
		Scanner in = new Scanner(System.in);
	    	Tauler taulerCreat = new Tauler(costat);
                List<Integer> conjuntGenerat = new ArrayList<Integer>();
	        int variable = 0;
	        int seguir = 0;
	        int escriure = 0;
	         
	        System.out.println("Primera vegada omplint, acces sequencial");
	        System.out.println("Escriu el valor de cada posicio");
	        for (int posx = 0; posx < costat; ++posx) {
	            for (int posy = 0; posy < costat; ++posy) {
	            	taulerCreat.setCela(posx, posy, in.nextInt());
	            	if(taulerCreat.getCela(posx, posy) == 1){
	            		 posInicial = new int[]{posx, posy};
	            	}
	            }
	        }
	        System.out.println("Estat actual:");
	        cT.escriuTauler(taulerCreat);
	         
	        System.out.println("Canviar alguna cela? 1:SI / 0:NO");
	        seguir = in.nextInt();
	        while (seguir == 1) {
	         
	            System.out.println("Entrar coordenades de la posicio desitjada:");
	            int x = in.nextInt();
	            int y = in.nextInt();
	            System.out.println("La posicio es: " + x + "," + y);
	             
	            System.out.println("Entrar valor desitjat:");
	            taulerCreat.setCela(x, y, in.nextInt()); 
	            if(taulerCreat.getCela(x, y) == 1){
           		 	posInicial = new int[]{x, y};
	            }
	            
	            System.out.println("Esriure? 1:SI / 0:NO");
	            if (escriure == 1 ) {
		            cT.escriuTauler(taulerCreat);
		            escriure = 0;
	            }
	             
	            System.out.println("Seguir? 1:SI / 0:NO");
	            seguir = in.nextInt();
	        }
	         
                 for(int i = 0; i < taulerCreat.sizeTauler(); ++i) 
                      for(int j = 0; j < taulerCreat.sizeTauler(); ++j) 
                           if(taulerCreat.getCela(i, j) > 0 ) conjuntGenerat.add(taulerCreat.getCela(i, j));
                 Collections.sort(conjuntGenerat);
                 
	         numDonats = new int[conjuntGenerat.size()];
	         for (int i = 0; i < numDonats.length; i++)
	             numDonats[i] = conjuntGenerat.get(i);
                
                cT.setNumDonats(numDonats);
                cT.setPosInicial(posInicial);
	        cT.setTauler(taulerCreat);
	        System.out.println("Resultat final:");
	        cT.escriuTauler(taulerCreat);
	        }
    /* POST: El tauler creat es guarda a la variable tauler */
}
