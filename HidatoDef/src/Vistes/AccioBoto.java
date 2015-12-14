/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author xavi
 */
public class AccioBoto implements ActionListener {
    private VistaGenerica origen;
    private VistaGenerica desti;
    
    public AccioBoto(VistaGenerica or, VistaGenerica dest) {
        this.origen = or;
        this.desti = dest;
    }
    
    public void actionPerformed(ActionEvent e) {
        this.origen.setVisible(false);
        this.desti.setVisible(true);
    }
    
}
