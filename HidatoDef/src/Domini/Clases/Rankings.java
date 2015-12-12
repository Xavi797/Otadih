/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

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
    private List<UsuariPuntuacio> taulaRanking; /* Llista que conte el ranking de una determinada dificultat */
    
    /**
     * Funcio encarregada de obtenir el nivell de dificiultat de el Ranking.
     * @return Int que es correspon amb el nivell de dificultat de el ranking
     */
    public int getNivellDificultat() {
        return nivellDificultat;
    }

    /**
     * Funcio encarregada de definir el nivell de dificultat del Ranking.
     * @param nivellDificultat Int corresponent al nivell de dificultat del ranking
     */
    public void setNivellDificultat(int nivellDificultat) {
        this.nivellDificultat = nivellDificultat;
    }

    /**
     * Funcio encarregada d'obtenir la llista de UsuariPuntuacio
     * @return Llista que conte els UsuariPuntuacio ordenats per puntuacio
     */
    public List<UsuariPuntuacio> getTaulaRanking() {
        return taulaRanking;
    }

    /**
     * Funcio encarregada de definir la llista de UsuariPuntuacio
     * @param taulaRanking Llista de UsuariPuntuacio ordenats per puntuacio
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
        ordenar();
        retallar();
    }
    
    /**
     * Funcio encarregada d'ordenar una llista de UsuariPuntuacio, si la llista te mida mes gran que 10 elimina els ultims.
     */
    public void ordenar() {
        ListIterator<UsuariPuntuacio> it = taulaRanking.listIterator(taulaRanking.size()-1);
        while (it.hasPrevious()) {
            UsuariPuntuacio up1 = it.previous();
            UsuariPuntuacio up2 = it.next();
            //it no ha canviat de posicio
            
            if (up1.puntuacio < up2.puntuacio) {
                //Canviem els dos up
                int previ = it.previousIndex();
                it.previous();
                int actual = it.nextIndex();
                //it ha disminuit una posicio cap al inici de la llista
                
                Collections.swap(taulaRanking, previ, actual);
            }
            else {
                //Avancem el punter una posicio endavant
                it.previous();
            }
        }
    }
    
    /**
     * Funcio encarregada de mantenir la llista amb 10 posicions, es queda amb les 10 primeres.
     */
    public void retallar() {
        while (taulaRanking.size() > 10) {
            taulaRanking.remove(taulaRanking.size()-1);
        }
    }
}
