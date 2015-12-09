/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author jaume.guell
 */

public class Rankings {
    private class UsuariPuntuacio { /* Conte el nom del usuari i la seva puntuacio en una partida determinada */
        private String user;
        private int puntuacio;
    }
    private int nivellDificultat;   /* Indica el nivell de dificultat de la partida i per tant ranking a utilitzar */
    private List<UsuariPuntuacio> taulaRanking = new ArrayList<UsuariPuntuacio>(); /* Llista que conte el ranking de una determinada dificultat */
    
    /**
     * 
     * @return 
     */
    public int getNivellDificultat() {
        return nivellDificultat;
    }

    /**
     * 
     * @param nivellDificultat 
     */
    public void setNivellDificultat(int nivellDificultat) {
        this.nivellDificultat = nivellDificultat;
    }

    /**
     * 
     * @return 
     */
    public List<UsuariPuntuacio> getTaulaRanking() {
        return taulaRanking;
    }

    /**
     * 
     * @param taulaRanking 
     */
    public void setTaulaRanking(List<UsuariPuntuacio> taulaRanking) {
        this.taulaRanking = taulaRanking;
    }
    
    /**
     * Funcio encarregada de afegir un nou UsuariPuntuacio al ranking.
     * @param up UsuariPuntuacio que sera afegit al ranking
     */
    public void afegeix(UsuariPuntuacio up) {
        taulaRanking.add(up);
    }
    
    /**
     * Funcio encarregada d'ordenar una llista de UsuariPuntuacio, si la llista te mida mes gran que 10 elimina els ultims.
     */
    public void ordenar() {
       /* taulaRanking.sort(UsuariPuntuacio, new Comparator<UsuariPuntuacio>() {
            @Override
            public int compare(UsuariPuntuacio up1, UsuariPuntuacio up2) {
                return up2.puntuacio.compareTo(up1.puntuacio);
            }
        });
        //Eliminem els ultims elements fins a quedarnos amb els 10 primers
        while (taulaRanking.size() > 10) {
            taulaRanking.remove(taulaRanking.size() - 1);
        }*/
    }
}
