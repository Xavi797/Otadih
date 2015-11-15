
package hidato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xavi
 */
public class controladorDominio {
    
    controladorTauler controlTauler; 
    
    public Tauler generaTauler(int costat, int numInicials) {
        return controlTauler.generaTauler(costat, numInicials);
    }
    
    public Tauler soluciona() {
        controlTauler.soluciona();
        return controlTauler.estat();
    }
    
    public boolean comprovar() {
        controlTauler.comprovarSolucio();
    }
    
    public boolean insertNum(int x, int y, int numero) {
        Coord cord= new Coord(x, y);
        return controlTauler.insertNum(cord, numero);
        
    }
    
    public boolean borrarNum(int x, int y) {
        Coord cord= new Coord(x, y);
        return estatTauler.borrarNum(cord);
    }
    
}
