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
 * Classe encarregada de gestionar qualsevol dels 3 Rankings i puntuacions del sistema.
 * @author jaume.guell
 */

public class Rankings implements Serializable {
    
    private int nivellDificultat;   /* Indica el nivell de dificultat de la partida i per tant ranking a utilitzar */
    private List<String> taulaUsuaris; /* Llista que conte el ranking de noms de usuari de una determinada dificultat */
    private List<Integer> taulaPuntuacions; /* Llista que conte le ranking de puntuacions de una determinada dificultat */
    
    /**
     * Constructor que inicialitza totes les primeres posicions amb valors Dummy amb 0 punts.
     * @param dificultat 
     */
    public Rankings(int dificultat) {
        nivellDificultat = dificultat;
        taulaUsuaris = new ArrayList<String>();
        taulaPuntuacions = new ArrayList<Integer>();
        for (int i = 0; i < 11; ++i) {
            taulaUsuaris.add("DUMMY");
            taulaPuntuacions.add(600);
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
     * Funcio encarregada de afegir un nou UsuariPuntuacio al ranking i ordenarlo.
     * @param user Nom del usuari
     * @param punts Punts que ha fet el usuari
     */
    public void afegeix(String user, int punts) {
        taulaUsuaris.add(taulaUsuaris.size()-1, user);
        taulaPuntuacions.add(taulaPuntuacions.size()-1, punts);
        ordenar();
        retallar();
    }
    
    /**
     * Funcio encarregada d'ordenar una llista de UsuariPuntuacio, si la llista te mida mes gran que 10 elimina els ultims.
     */
    public void ordenar() {
        ListIterator<String> itU = taulaUsuaris.listIterator(taulaUsuaris.size()-1);
        ListIterator<String> itP = taulaUsuaris.listIterator(taulaUsuaris.size()-1);
        int index = taulaUsuaris.size() - 1;
        
        while (itU.hasPrevious() && itP.hasPrevious()) {
            itU.previous();    //retrocedim el index 1 posicio
            itP.previous();
            
            int punts1 = taulaPuntuacions.get(index);
            int ind1 = index;
            --index;
            int punts2 = taulaPuntuacions.get(index);
            int ind2 = index;
            
            if (punts1 < punts2 || "DUMMY".equals(taulaUsuaris.get(index))) {
                Collections.swap(taulaPuntuacions, ind1, ind2);
                Collections.swap(taulaUsuaris, ind1, ind2);
            }
        }
    }
    
    /**
     * Funcio encarregada de mantenir les llistes amb 10 posicions, es queda amb les 10 primeres posicions.
     */
    public void retallar() {
        while (taulaPuntuacions.size() > 10) {
            taulaPuntuacions.remove(taulaPuntuacions.size()-1);
            taulaUsuaris.remove(taulaUsuaris.size()-1);
        }
    }
    
    /**
     * Funcio encarregada de retornar la mida dels rankings.
     * @return Int amb les posicions del ranking
     */
    public int mida() {
        return taulaUsuaris.size();
    }
    
    /**
     * Funcio encarregada de obtenir el nom de usuari de una posicio del ranking.
     * @param index Posicio del ranking a consultar
     * @return String que conte el nom del usuari demanat
     */
    public String getUsuari(int index) {
        return taulaUsuaris.get(index);
    }
    
    /**
     * Funcio encarregada de obtenir els punts de un usuari de una posicio del ranking.
     * @param index Posicio del ranking a consultar
     * @return Int que conte els punts del usuari de la posicio demanada
     */
    public int getPunts(int index) {
        return taulaPuntuacions.get(index);
    }
}
