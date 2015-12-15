/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;
import  Domini.Controlador.ControladorDomini;

/**
 *
 * @author xavi
 */
public class VistaGeneraHidato extends javax.swing.JPanel {

    ControladorDomini controladorDomini;
    ControladorVistes controladorVistes;
    /**
     * Creates new form VistaGeneraHidato
     */
    public VistaGeneraHidato(ControladorDomini contD, ControladorVistes contV) {
        initComponents();
        controladorDomini = contD;
        controladorVistes = contV;
        initBoxes();
        

        
    }
    
    private void initBoxes() {
        
        boxDificultat.removeAllItems();
        boxDificultat.addItem("Fàcil");
        boxDificultat.addItem("Intermedi");
        boxDificultat.addItem("Difícil");
        boxDificultat.setSelectedItem("Fácil");
        
        boxTopologia.removeAllItems();
        boxTopologia.addItem("Amb forats");
        boxTopologia.addItem("Trival");
        boxTopologia.addItem("Piramide");
        boxTopologia.addItem("Creu");
        boxTopologia.addItem("Sense Forats");     
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
                    .addComponent(botoGenera, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 45, Short.MAX_VALUE)
                .addComponent(botoGenera)
                .addGap(29, 29, 29))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void boxDificultatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxDificultatActionPerformed

    }//GEN-LAST:event_boxDificultatActionPerformed

    private void boxDificultatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxDificultatItemStateChanged
        String itemName =(String) boxDificultat.getSelectedItem();
        if (itemName == "Fàcil") {
            boxTamany.removeAllItems();
            boxTamany.addItem("3");
            boxTamany.addItem("4");
            boxTamany.addItem("5");
        } else if (itemName == "Intermedi"){
            boxTamany.removeAllItems();
            boxTamany.addItem("6");
            boxTamany.addItem("7");
        } else {
            boxTamany.removeAllItems();
            boxTamany.addItem("8");
            boxTamany.addItem("9");
        }
    }//GEN-LAST:event_boxDificultatItemStateChanged

    private void botoGeneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoGeneraActionPerformed
        String costat = (String)boxTamany.getSelectedItem();
        int numIni = Integer.parseInt(numInicials.getText());
        String topologia = (String)boxTopologia.getSelectedItem();
        controladorDomini.generaTauler(Integer.parseInt(costat), numIni, topologia);
        controladorVistes.mostraVista("vistaJugar");
    }//GEN-LAST:event_botoGeneraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
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
