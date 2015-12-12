/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

/**
 *
 * @author jaume.guell
 */
public class Estadistiques {
    private int nPartides;
    private int nPartidesGuanyades;
    private int percentatgeGuanyades;
    
    private int puntuacioMaxima;
    private int puntuacioMitja;
    
    private int totalPuntuacio; /* Aquest parametre no es mostra a la vista */
    
    /**
     * Constructor basic, inicialitza tots els parametres a 0.
     */
    public Estadistiques() {
        nPartides = 0;
        nPartidesGuanyades = 0;
        percentatgeGuanyades = 0;
        puntuacioMaxima = 0;
        puntuacioMitja = 0;
        totalPuntuacio = 0;
    }
    
    /**
     * Funcio encarregada de afegir una nova partida iniciada i recalcular els parametres necessaris.
     */
    public void afegeixPartida() {
        nPartides += 1;
        if (nPartidesGuanyades != 0) percentatgeGuanyades = nPartides / nPartidesGuanyades;
        else nPartidesGuanyades = 0;
    }
    
    /**
     * Funcio encarregada de afegir una nova partida acavada i recalcular els parametres necessaris.
     * @param guanyada Boolea que indica si afegim una partida guanyada o no
     */
    public void afegeixPartidaGuanyada(boolean guanyada) {
        if (guanyada) {
            nPartidesGuanyades += 1;
        }
        if (nPartidesGuanyades != 0) percentatgeGuanyades = nPartides / nPartidesGuanyades;
        else percentatgeGuanyades = 0;
    }
    
    /**
     * Funcio encarregada de afegir una nova puntuacio i recalcular els parametres necesaris.
     * @param punts Quantitat de punts a afegir
     */
    public void afegeixPuntuacio(int punts) {
        if (punts > puntuacioMaxima) {
            puntuacioMaxima = punts;
        }
        totalPuntuacio += punts;
        puntuacioMitja = totalPuntuacio / nPartides;
    }

    /**
     * Funcio encarregada de obtenir el nombre de partides jugades.
     * @return Retorna el nombre de partides
     */
    public int getnPartides() {
        return nPartides;
    }

    /**
     * Funcio encarregada de modificar el nombre de partides jugades.
     * @param nPartides Nombre de partides
     */
    public void setnPartides(int nPartides) {
        this.nPartides = nPartides;
    }

    /**
     * Funcio encarregada de obtenir el nombre de partides guanyades.
     * @return Retorna el nombre de partides guanyades
     */
    public int getnPartidesGuanyades() {
        return nPartidesGuanyades;
    }
    
    /**
     * Funcio encarregada de modificar el nombre de partides guanyades.
     * @param nPartidesGuanyades Nombre de partides guanyades
     */
    public void setnPartidesGuanyades(int nPartidesGuanyades) {
        this.nPartidesGuanyades = nPartidesGuanyades;
    }

    /**
     * Funcio encarregada de obtenir el percentatge de partides guanyades.
     * @return Retorna el percentatge de partides guanyades
     */
    public int getPercentatgeGuanyades() {
        return percentatgeGuanyades;
    }

    /**
     * Funcio encarregada de modificar el percentatge de partides guanyades.
     * @param percentatgeGuanyades Percentatge de partides guanyades
     */
    public void setPercentatgeGuanyades(int percentatgeGuanyades) {
        this.percentatgeGuanyades = percentatgeGuanyades;
    }

    /**
     * Funcio encarregada de obtenir la puntuacio maxima.
     * @return Retorna la puntuacio maxima
     */
    public int getPuntuacioMaxima() {
        return puntuacioMaxima;
    }

    /**
     * Funcio encarregada de modificar la puntuacio maxima.
     * @param puntuacioMaxima Puntuacio maxima
     */
    public void setPuntuacioMaxima(int puntuacioMaxima) {
        this.puntuacioMaxima = puntuacioMaxima;
    }
    
    /**
     * Funcio encarregada de obtenir la puntuacio mitja.
     * @return Retorna la puntuacio mitja
     */
    public int getPuntuacioMitja() {
        return puntuacioMitja;
    }

    /**
     * Funcio encarregada de modificar la puntuacio mitja.
     * @param puntuacioMitja Puntuacio mitja
     */
    public void setPuntuacioMitja(int puntuacioMitja) {
        this.puntuacioMitja = puntuacioMitja;
    }

    /**
     * Funcio encarregada de obtenir la puntuacio acumulada en totes les partides.
     * @return Retorna la puntuacio total acumulada entre totes les partides
     */
    public int getTotalPuntuacio() {
        return totalPuntuacio;
    }

    /**
     * Funcio encarregada de modificar la puntuacio acumulada en totes les partides.
     * @param totalPuntuacio Puntuacio total acumulada en totes les partides
     */
    public void setTotalPuntuacio(int totalPuntuacio) {
        this.totalPuntuacio = totalPuntuacio;
    }
}
