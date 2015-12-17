/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author jaume.guell
 */

public class Rankings implements Serializable {
    
    private int nivellDificultat;   /* Indica el nivell de dificultat de la partida i per tant ranking a utilitzar */
    private List<UsuariPuntuacio> taulaRanking; /* Llista que conte el ranking de una determinada dificultat */
    
    /**
     * Constructor que inicialitza totes les primeres posicions amb valors Dummy amb punts ascendents.
     * @param dificultat 
     */
    public Rankings(int dificultat) {
        nivellDificultat = dificultat;
        taulaRanking = new ArrayList<UsuariPuntuacio>();
        for (int i = 0; i < 11; ++i) {
            UsuariPuntuacio up = new UsuariPuntuacio();
            up.punts = 0;
            up.user = "DUMMY";
            taulaRanking.add(up);
        }
    }
    
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
     * Funcio encarregada de afegir un nou UsuariPuntuacio al ranking i ordenarlo.
     * @param user Nom del usuari
     * @param punts Punts que ha fet el usuari
     */
    public void afegeix(String user, int punts) {
        UsuariPuntuacio up = new UsuariPuntuacio();
        up.user = user;
        up.punts = punts;
        taulaRanking.add(taulaRanking.size()-1, up);
        ordenar();
        retallar();
    }
    
    /**
     * Funcio encarregada d'ordenar una llista de UsuariPuntuacio, si la llista te mida mes gran que 10 elimina els ultims.
     */
    public void ordenar() {
        ListIterator<UsuariPuntuacio> it = taulaRanking.listIterator(taulaRanking.size()-1);
        int index = taulaRanking.size() - 1;
        
        while (it.hasPrevious()) {
            it.previous();    //retrocedim el index 1 posicio
            
            UsuariPuntuacio up1 = taulaRanking.get(index);
            int i1 = index;
            --index;
            UsuariPuntuacio up2 = taulaRanking.get(index);
            int i2 = index;
            
            if (up1.punts> up2.punts) {
                Collections.swap(taulaRanking, i1, i2);
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
    
    /**
     * Funcio encarregada de retornar la mida del ranking.
     * @return Int amb les posicions del ranking
     */
    public int mida() {
        return taulaRanking.size();
    }
    
    /**
     * Funcio encarregada de obtenir el nom de usuari de una posicio del ranking.
     * @param index Posicio del ranking a consultar
     * @return String que conte el nom del usuari demanat
     */
    public String getUsuari(int index) {
        return taulaRanking.get(index).user;
    }
    
    /**
     * Funcio encarregada de obtenir els punts de un usuari de una posicio del ranking.
     * @param index Posicio del ranking a consultar
     * @return Int que conte els punts del usuari de la posicio demanada
     */
    public int getPunts(int index) {
        return taulaRanking.get(index).punts;
    }
}
