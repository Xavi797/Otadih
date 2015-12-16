/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.io.Serializable;

/**
 *
 * @author jaume.guell
 */
public class Partida implements Serializable {
    /**
     * Parametres:
     * -user es correspon amb el usuari que juga la partida
     * -hidatos conte el tauler de la partida en els seus 3 estats possibles: inicial, a mitges i solucionat
     * -temps es el temps que porta el usuari resolent el problema
     * -numChecks es el nombre de ajudes que ha utilitzat el usuari
     * -solve es un boolea que contempla si el usuari a solucionat la partida utilitzant la maquina o no.
     */
    private Usuari user;
    private Hidatos hidatos;
    private int temps; //provisional.buscar funcio de clock
    private int numChecks;
    private boolean solve;

    public Usuari getUser() {
        return user;
    }

    public void setUser(Usuari user) {
        this.user = user;
    }

    public Hidatos getHidatos() {
        return hidatos;
    }

    public void setHidatos(Hidatos hidatos) {
        this.hidatos = hidatos;
    }

    public int getTemps() {
        return temps;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public int getNumChecks() {
        return numChecks;
    }

    public void setNumChecks(int numChecks) {
        this.numChecks = numChecks;
    }

    public boolean isSolve() {
        return solve;
    }

    public void setSolve(boolean solve) {
        this.solve = solve;
    }
    
    
}