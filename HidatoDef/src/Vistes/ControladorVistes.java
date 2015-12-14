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
        initVistes();
    }
    
    public void initVistes() {
        //this.vistaMenu = new VistaMenu().setVisible(false);
        vistaInici = new VistaInici(controladorDomini, this);
        vistaMenu  = new VistaMenu(controladorDomini, this);
        this.add(this.vistaInici);
        
        vistaInici.setVisible(true);
                

           
    }
    
    public void mostraVista(String desti) {
        switch(desti) {
            case "Inici": 
                this.vistaInici.setVisible(true); 
                break;
            case "Menu":
                vistaMenu.setVisible(true);
                break;
        }
    }
    
    

}
