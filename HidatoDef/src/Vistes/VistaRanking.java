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
public class VistaRanking extends VistaGenerica {

    ControladorDomini controladorDomini;
    ControladorVistes controladorVistes;
    /**
     * Creates new form VistaRanking
     */
    public VistaRanking(ControladorDomini contDomini , ControladorVistes contVistes) {
        initComponents();
        controladorDomini = contDomini;
        controladorVistes = contVistes;
        initLlistes();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BotoTornar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListaDificultat = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        LlistaPuntuacions = new javax.swing.JList();

        BotoTornar.setText("Tornar");
        BotoTornar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoTornarActionPerformed(evt);
            }
        });

        ListaDificultat.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        ListaDificultat.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                ListaDificultatValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(ListaDificultat);

        LlistaPuntuacions.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        LlistaPuntuacions.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                LlistaPuntuacionsValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(LlistaPuntuacions);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 245, Short.MAX_VALUE)
                .addGap(21, 21, 21)
                .addComponent(BotoTornar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotoTornar)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(83, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void BotoTornarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoTornarActionPerformed
        controladorVistes.mostraVista("Menu");
    }//GEN-LAST:event_BotoTornarActionPerformed

    private void LlistaPuntuacionsValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_LlistaPuntuacionsValueChanged

        
    }//GEN-LAST:event_LlistaPuntuacionsValueChanged

    private void ListaDificultatValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_ListaDificultatValueChanged
        int seleccionat = ListaDificultat.getSelectedIndex();
        System.out.println(seleccionat);
        String[] puntuacions = controladorDomini.obteRanking(seleccionat);
        LlistaPuntuacions.setListData(puntuacions);
    }//GEN-LAST:event_ListaDificultatValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoTornar;
    private javax.swing.JList ListaDificultat;
    private javax.swing.JList LlistaPuntuacions;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    private void initLlistes() {
        String[] listData = {"Facil", "Intermedi", "Dificil"};
        ListaDificultat.setListData(listData);
        ListaDificultat.setSelectedIndex(0);
    }
}
