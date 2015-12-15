/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.io.Serializable;

/**
 * Classe que conte un Tauler en les seves tres formes possibles, inicial, a mitges i solucionat.
 * @author jaume.guell
 */
public class Hidatos implements Serializable {
    private Tauler taulerJocInic;
    private Tauler taulerJocModi;
    private Tauler taulerJocSolu;
    
    /**
     * Constructor basic.
     */
    public Hidatos() {
        taulerJocInic = new Tauler();
        taulerJocModi = new Tauler();
        taulerJocSolu = new Tauler();
    }
    
    /**
     * Constructora parametritzada.
     * @param inic Tauler inicial
     * @param modi Tauler a mitges
     * @param solu Tauler solucionat
     */
    public Hidatos(Tauler inic, Tauler modi, Tauler solu) {
        taulerJocInic = inic;
        taulerJocModi = modi;
        taulerJocSolu = solu;
    }

    /**
     * Funcio encarregada de obtenir el tauler inicial.
     * @return Tauler amb les condicions inicials
     */
    public Tauler getTaulerJocInic() {
        return taulerJocInic;
    }

    /**
     * Funcio encarregada de modificar el tauler inicial.
     * @param taulerJocInic Tauler amb les condicions inicials utilitzat
     */
    public void setTaulerJocInic(Tauler taulerJocInic) {
        this.taulerJocInic = taulerJocInic;
    }

    /**
     * Funcio encarregada de obtenir el tauler a mitges.
     * @return Tauler a mitges
     */
    public Tauler getTaulerJocModi() {
        return taulerJocModi;
    }

    /**
     * Funcio encarregada de modificar el tauler a mitges.
     * @param taulerJocModi Tauler a mitges utilitzat
     */
    public void setTaulerJocModi(Tauler taulerJocModi) {
        this.taulerJocModi = taulerJocModi;
    }

    /**
     * Funcio encarregada de obtenir el tauler solucionat.
     * @return Tauler solucionat
     */
    public Tauler getTaulerJocSolu() {
        return taulerJocSolu;
    }

    /**
     * Funcio encarregada de modificar el tauler solucionat.
     * @param taulerJocSolu Tauler solucionat utiltzat
     */
    public void setTaulerJocSolu(Tauler taulerJocSolu) {
        this.taulerJocSolu = taulerJocSolu;
    }
    
    
}
