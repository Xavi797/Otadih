/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;
import  Domini.Controlador.ControladorDomini;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author xavi
 */
public class VistaGeneraHidato extends javax.swing.JPanel {

    ControladorDomini controladorDomini;
    ControladorVistes controladorVistes;
    
    /**
     * Constructora que inicialitza els components i els controladors que li 
     * passen
     * @param contD
     * @param contV 
     */
    public VistaGeneraHidato(ControladorDomini contD, ControladorVistes contV) {
        initComponents();
        controladorDomini = contD;
        controladorVistes = contV;
        initBoxes();
        

        
    }
    
    /**
     * Inicialitza els boxes amb els items corresponents.
     */
    private void initBoxes() {
        
        boxDificultat.removeAllItems();
        boxDificultat.addItem("Fàcil");
        boxDificultat.addItem("Intermedi");
        boxDificultat.addItem("Difícil");
        boxDificultat.setSelectedItem("Fácil");
        
        boxTopologia.removeAllItems();
        boxTopologia.addItem("Trival");
        boxTopologia.addItem("Piramide");
        boxTopologia.addItem("Creu");
        boxTopologia.addItem("Sense Forats");
        boxTopologia.addItem("Amb forats");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botoGenera = new javax.swing.JButton();
        boxTamany = new javax.swing.JComboBox();
        boxTopologia = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        boxDificultat = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        numInicials = new javax.swing.JTextField();
        BotoTornar = new javax.swing.JButton();

        jLabel1.setText("Tamany");

        jLabel3.setText("Topologia");

        botoGenera.setText("Genera!");
        botoGenera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoGeneraActionPerformed(evt);
            }
        });

        boxTamany.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        boxTopologia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Dificultat");

        boxDificultat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        boxDificultat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxDificultatItemStateChanged(evt);
            }
        });
        boxDificultat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxDificultatActionPerformed(evt);
            }
        });

        jLabel5.setText("Num inicials");

        numInicials.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numInicialsActionPerformed(evt);
            }
        });

        BotoTornar.setText("Tornar");
        BotoTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoTornarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(numInicials, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(boxDificultat, 0, 91, Short.MAX_VALUE)
                            .addComponent(boxTamany, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(boxTopologia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(botoGenera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotoTornar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(boxDificultat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(boxTamany, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boxTopologia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(numInicials, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(botoGenera)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BotoTornar)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxDificultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDificultatActionPerformed

    }//GEN-LAST:event_boxDificultatActionPerformed

    /**
     * Event que al modificar el box de dificultat canvien el tamany del tauler
     * disponible
     * @param evt 
     */
    private void boxDificultatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxDificultatItemStateChanged
        String itemName =(String) boxDificultat.getSelectedItem();
        if (itemName == "Fàcil") {
            boxTamany.removeAllItems();
            numInicials.setText("3");
            boxTamany.addItem("3");
            boxTamany.addItem("4");
            boxTamany.addItem("5");
        } else if (itemName == "Intermedi"){
            boxTamany.removeAllItems();
            numInicials.setText("6");
            boxTamany.addItem("6");
            boxTamany.addItem("7");
        } else {
            boxTamany.removeAllItems();
            numInicials.setText("8");
            boxTamany.addItem("8");
            boxTamany.addItem("9");
        }
    }//GEN-LAST:event_boxDificultatItemStateChanged

    /**
     * Event que genera la vista Jugar amb el tauler creat
     * @param evt 
     */
    private void botoGeneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoGeneraActionPerformed
        String costat = (String)boxTamany.getSelectedItem();
        String num = numInicials.getText();
        if (num == "") num = "0";
        int numIni = Integer.parseInt(num);
        String topologia = (String)boxTopologia.getSelectedItem();
        if (topologia == "Amb forats") {
            
            int tamany = Integer.parseInt(costat);
            int[][] matriu = new int[tamany][tamany];
            JFrame frame = new JFrame();
            VistaForats vistaForats = new VistaForats(matriu, numIni, controladorDomini, controladorVistes, frame);
        
            int width  = 40;
            int height = 40;
            int x   = 15;
            int y   = 15;
            int files  = matriu.length;
            int columnes = matriu[0].length;
            vistaForats.setPreferredSize(new Dimension(files*45 + 150, files*45 + 100));
            frame.setPreferredSize(new Dimension(files*45 + 150, files*45 + 100));
            frame.setContentPane(vistaForats);
            frame.pack();
            frame.setVisible(true);


            JTextField[][] tauler = new JTextField[files][columnes];
            for (int i = 0;i < files; ++i) {
                x = 15;
                for (int j = 0;j <columnes; ++j) {
                    tauler[i][j] = new JTextField();
                    tauler[i][j].addMouseListener(new AccioClick(i,j,matriu,tauler));
                    vistaForats.add(tauler[i][j]);
                    tauler[i][j].setBounds(x+45, y+45, width, height);                    
                    x +=45;
                }
                y += 45;
            }
            JButton botoGeneraForats = new JButton();
            botoGeneraForats.setText("Genera Hidato");
            vistaForats.add(botoGeneraForats);


        } else {
            controladorDomini.generaTauler(Integer.parseInt(costat), numIni, topologia);
            controladorVistes.mostraVista("vistaJugar");
        }
    }//GEN-LAST:event_botoGeneraActionPerformed

    private class AccioClick implements MouseListener {
        
        int x;
        int y;
        int[][] matriu;
        JTextField[][] tauler;
        
        public AccioClick(int i, int j, int[][] mat, JTextField[][] tau) {
            x = i;
            y = j;
            matriu = mat;
            tauler = tau;
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            if (matriu[x][y] == 0) {
                matriu[x][y] = -1;
                tauler[x][y].setBackground(Color.black);
            }
            else{
                matriu[x][y] = 0;
                tauler[x][y].setBackground(Color.white);
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }
    }
    private void numInicialsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numInicialsActionPerformed
        // TODO add your handling code here:
        try{
           int n = Integer.parseInt(numInicials.getText());
        }
        catch (Exception e1){
            numInicials.setText("");
        }
    }//GEN-LAST:event_numInicialsActionPerformed

    private void BotoTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoTornarActionPerformed
       controladorVistes.mostraVista("Menu");
    }//GEN-LAST:event_BotoTornarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoTornar;
    private javax.swing.JButton botoGenera;
    private javax.swing.JComboBox boxDificultat;
    private javax.swing.JComboBox boxTamany;
    private javax.swing.JComboBox boxTopologia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField numInicials;
    // End of variables declaration//GEN-END:variables
}
