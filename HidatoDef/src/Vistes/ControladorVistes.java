/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistes;
import Domini.Controlador.ControladorDomini;
import Vistes.VistaInici;
import Vistes.vistaJugar;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.event.*;
/**
 *
 * @author xavi
 */
public class ControladorVistes extends javax.swing.JFrame{
    ControladorDomini controladorDomini;
    VistaMenu  vistaMenu;
    vistaJugar vistJugar;
    VistaInici vistaInici;
    
    public ControladorVistes(ControladorDomini contDom) {
        controladorDomini = contDom;
    }
    
    public void initVistes() {
        //this.vistaMenu = new VistaMenu().setVisible(false);
        this.vistaInici = new VistaInici();
        this.add(this.vistaInici);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                initVistes();
                vistaInici.setVisible(true);
                
                //int[][] matriu = controTaula.transformar(controlador.getTauler());
            //vistaJugar.createBoard(matriu);
            }
        });
    }
    
    public void vistaDesti(String desti) {
        switch(desti) {
            case "Inici": 
                this.vistaInici.setVisible(true); 
        }
    }
    
    

}
