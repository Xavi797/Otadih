package Domini.Clases;

import Domini.Controlador.*;
import Vistes.ControladorVistes;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * Main del programa.
 * @author jaume.guell
 */
public class Main {
    public static void main(String args[]) {
        final ControladorDomini controlador = new ControladorDomini();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ControladorVistes controladorVistes = new ControladorVistes(controlador);
            }
        }); 
                    
    }
}

