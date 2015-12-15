/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;

import Domini.Controlador.ControladorDomini;

/**
 *
 * @author xavi
 */
public class ControladorVistes extends javax.swing.JFrame {

    
    ControladorDomini controladorDomini;
    VistaMenu  vistaMenu;
    VistaJugar vistJugar;
    VistaInici vistaInici;
    VistaGeneraHidato vistaGeneraHidato;
    MenuJugar menuJugar;
    
    public ControladorVistes(ControladorDomini contDom) {
        controladorDomini = contDom;
        initComponents();
        this.setTitle("Hidato");
        initVistes();
        this.setVisible(true);
    }
    
    public void initVistes() {
        //this.vistaMenu = new VistaMenu().setVisible(false);
        vistaInici = new VistaInici(controladorDomini, this);
        vistaMenu  = new VistaMenu(controladorDomini, this);
        vistaGeneraHidato = new VistaGeneraHidato(controladorDomini, this);
        menuJugar = new MenuJugar(controladorDomini, this);
        vistJugar = new VistaJugar(controladorDomini, this);
        this.setContentPane(vistaInici);
        this.pack();
 
    }
    
    public void mostraVista(String desti) {
        switch(desti) {
            case "Inici":
                this.getContentPane().removeAll();
                this.setContentPane(vistaInici);
                this.pack();
                break;
                
            case "Menu":
                this.getContentPane().removeAll();
                this.setContentPane(vistaMenu);
                this.pack();
                break;
            
            case "menuJugar":
                this.getContentPane().removeAll();
                this.setContentPane(menuJugar);
                this.pack();
                break;
                
            case "GeneraHidato":
                this.getContentPane().removeAll();
                this.setContentPane(vistaGeneraHidato);
                this.pack();
                break;
                
            case "vistaJugar":
                this.getContentPane().removeAll();
                this.setContentPane(vistJugar);
                vistJugar.setMatriu();
                vistJugar.createBoard();
                this.pack();
                break;
        }
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 903, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents



    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
