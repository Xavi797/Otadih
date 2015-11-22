/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author jaume.guell
 */
public class Estadistiques {
    private int nPartides;
    private int puntacioMitja;
    
    public Estadistiques() {
        nPartides = 0;
        puntacioMitja = 0;
    }

    public int getnPartides() {
        return nPartides;
    }

    public void setnPartides(int nPartides) {
        this.nPartides = nPartides;
    }

    public int getPuntacioMitja() {
        return puntacioMitja;
    }

    public void setPuntacioMitja(int puntacioMitja) {
        this.puntacioMitja = puntacioMitja;
    }
    
    
}
