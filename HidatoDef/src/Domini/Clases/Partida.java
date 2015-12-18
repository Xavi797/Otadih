/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.io.Serializable;

/**
 * Classe encarregada de mantenir tota la informacio rellevant per a gestionar una partida dins el sistema.
 * @author jaume.guell
 */
public class Partida implements Serializable {
    /**
     * Parametres:
     * -user es correspon amb el usuari que juga la partida
     * -hidatos conte el tauler de la partida en els seus 3 estats possibles: inicial, a mitges i solucionat
     * -temps es el temps que porta el usuari resolent el problema
     * -numChecks es el nombre de ajudes que ha utilitzat el usuari.
     */
    private Usuari user;
    private Hidatos hidatos;
    private Rankings ranking;
    private long temps = 0;
    private int numChecks = 0;

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

    public Rankings getRanking() {
        return ranking;
    }

    public void setRanking(Rankings ranking) {
        this.ranking = ranking;
    }

    public long getTemps() {
        return temps;
    }

    public void setTemps(long temps) {
        this.temps = temps;
    }

    public int getNumChecks() {
        return numChecks;
    }

    public void setNumChecks(int numChecks) {
        this.numChecks = numChecks;
    }    
}