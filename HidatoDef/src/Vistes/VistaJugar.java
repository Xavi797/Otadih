/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;
import java.awt.Color;
import Domini.Controlador.ControladorDomini;
import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPanel;

/**
 *
 * @author xavi
 */
public class VistaJugar extends VistaGenerica {

    /**
     * Creates new form VistaJugar
     */
    ControladorVistes controladorVistes;
    JPanel plataformaCeles;
    ControladorDomini controladorDomini;
    int [][] matriu;
    /**
     * Creates new form vistaJugar
     */
    
    public VistaJugar(ControladorDomini contD, ControladorVistes contV) {
        
        initComponents();
        controladorDomini = contD;
        controladorVistes = contV;
        plataformaCeles = new JPanel();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jButton2 = new javax.swing.JButton();
        TimeLabel = new javax.swing.JLabel();

        jButton1.setText("Soluciona");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Activa ajudes");
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        jButton2.setText("Guarda partida");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        TimeLabel.setBackground(Color.WHITE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        matriu = controladorDomini.getTaulerSolucionatPerVista();
        createBoard();
    }//GEN-LAST:event_jButton1ActionPerformed
   
    public void setMatriu() {
        matriu = controladorDomini.getTaulerPerVista();
    }
    
    public void createBoard ()
    {

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
                x +=45;
            }
            y += 45;
        }
        this.setPreferredSize(new Dimension(files*45 + 220, files*45 + 50));
        controladorVistes.pack();
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
