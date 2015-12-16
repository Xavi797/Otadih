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