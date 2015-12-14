/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.io.Serializable;

/**
 * Classe contenidora dels parametres necessaris per al ranking.
 * @author jaume.guell
 */
public class UsuariPuntuacio implements Serializable {
    private String user;    /* Nom el usuari */
    private int punts;      /* Punts que ha fet el usuari en una partida determinada */

    /**
     * Constructora basica.
     */
    public UsuariPuntuacio() { 
        user = "";
        punts = 0;
    }
    
    /**
     * Constructora amb valors inicialitzats.
     * @param user
     * @param punts 
     */
    public UsuariPuntuacio(String user, int punts) {
        this.user = user;
        this.punts = punts;
    }
    
    /**
     * Funcio encarregada de obtenir el nom del usuari
     * @return String que conte el nom del usuari
     */
    public String getUser() {
        return user;
    }

    /**
     * Funcio encarregada de modificar el nom del usuari
     * @param user Nom del usuari en questio
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * Funcio encarregada de obtenir els punts que ha fet el usuari.
     * @return Int equivalent als punts
     */
    public int getPunts() {
        return punts;
    }

    /**
     * Funcio encarregada de modificar els punts que ha fet el usuari.
     * @param punts Punts en questio
     */
    public void setPunts(int punts) {
        this.punts = punts;
    }
    
    
}
