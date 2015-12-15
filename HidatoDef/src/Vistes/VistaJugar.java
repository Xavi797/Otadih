/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;
import java.awt.Color;
import Domini.Controlador.ControladorDomini;
import javax.swing.JTextField;

/**
 *
 * @author xavi
 */
public class VistaJugar extends VistaGenerica {

    /**
     * Creates new form VistaJugar
     */
    ControladorVistes controladorVistes;
    ControladorDomini controladorDomini;
    /**
     * Creates new form vistaJugar
     */
    
    public VistaJugar(ControladorDomini contD, ControladorVistes contV) {
        
        initComponents();
        controladorDomini = contD;
        controladorVistes = contV;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 759, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 438, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
   
    public void createBoard ()
    {
        
        int [][] matriu = controladorDomini.getTaulerPerVista();
        int width  = 40;
        int height = 40;
        int x   = 15;
        int y   = 15;
        int files  = matriu.length;
        int columnes = matriu[0].length;
        JTextField[][] tauler = new JTextField[files][columnes];
        for (int i = 0;i < files; ++i) {
            x = 15;
            for (int j = 0;j <columnes; ++j) {
                tauler[i][j] = new JTextField();
                if (matriu[i][j] == -1) {
                    tauler[i][j].setEditable(false);
                    tauler[i][j].setBackground(Color.BLACK);
                }
                else if (matriu[i][j] != 0) {
                    tauler[i][j].setEditable(false);
                    tauler[i][j].setText(Integer.toString(matriu[i][j]));
                    tauler[i][j].setBackground(Color.GRAY);
                }
                //System.out.print(matriu[i][j]);

                tauler[i][j].setBounds(x, y, width, height);
                this.add(tauler[i][j]);
                x +=55;
            }
            y += 55;
        }  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}