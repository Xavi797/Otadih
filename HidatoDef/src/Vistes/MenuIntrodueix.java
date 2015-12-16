/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;

import Domini.Controlador.ControladorDomini;
import java.awt.Color;
import java.awt.Dimension;
import static java.lang.Integer.parseInt;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author xavi
 */
public class MenuIntrodueix extends VistaGenerica {

    /**
     * Creates new form MenuIntrodueix
     */
    ControladorDomini controladorDomini;
    ControladorVistes controladorVistes;
    int[][] matriu;
    JTextField[][] tauler;
    
    /**
     * Constructora que inicialitza els components, agafa els Controladors i 
     * crea la taula per introduir els numeros.
     * @param contDomini
     * @param contVistes 
     */
    public MenuIntrodueix(ControladorDomini contDomini , ControladorVistes contVistes) {
        initComponents();
        controladorDomini = contDomini;
        controladorVistes = contVistes;
        
        jComboBox1.removeAllItems();
        jComboBox1.addItem("3");
        jComboBox1.addItem("4");
        jComboBox1.addItem("5");
        jComboBox1.addItem("6");
        jComboBox1.addItem("7");
        jComboBox1.addItem("8");
        jComboBox1.addItem("9");
        jComboBox1.setSelectedItem("3");
        
        createBoard(3);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        BotoValidar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Selecciona tamany");

        BotoValidar.setText("Validar");
        BotoValidar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotoValidarActionPerformed(evt);
            }
        });

        jButton1.setText("Sortir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 373, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BotoValidar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotoValidar))
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(268, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox1ActionPerformed
    
    /**
     * Event que es crida en cas de que es modifiqui el comboBox del tamany.
     * @param evt 
     */
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        if (tauler != null){
            for (JTextField[] ts : tauler)
                for (JTextField t : ts)
                    this.remove(t);
            String result = jComboBox1.getSelectedItem().toString();
            createBoard(parseInt(result));
        }
        
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    
    /**
     * Event que es crida en cas de que es premi el boto valida, llavors crida 
     * a controladorDomini per a que li validi. En cas de que es validi et
     * pregunta si el vols guardar
     * @param evt 
     */
    private void BotoValidarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotoValidarActionPerformed
        if (tauler != null){
            String num;
            int[][] conjuntTauler;
            conjuntTauler = new int[tauler.length][tauler.length];
            int i= 0;
            int j= 0;
            for (JTextField[] ts : tauler) {
                for (JTextField t : ts) {
                   num = t.getText();
                   if (num.isEmpty()) num = "0";
                   conjuntTauler[i][j] = Integer.parseInt(num);
                   ++i;
                }
                i = 0;
                ++j;
            }
            boolean resposta = controladorDomini.validaTablero(conjuntTauler);
            if (resposta) {
                Object[] options = {"Guardar",
                    "Cancelar"};
                int res = JOptionPane.showOptionDialog(controladorVistes,
                "Hidato vàlid, vols guardar?",
                "Confrimació",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,     
                options,  
                options[0]);
                
                if (res == 0) {
                    String inputValue = JOptionPane.showInputDialog("Possa el nom del Hidato");
                    if (inputValue != null) {
                        boolean resultatGuardar = controladorDomini.guardarTauler(inputValue);
                        while (!resultatGuardar) {
                            inputValue = JOptionPane.showInputDialog("Ja existeix un Hidato amb aquest nom. Posa'n un altre");
                            if (inputValue == null) break;
                            resultatGuardar = controladorDomini.guardarTauler(inputValue);
                        }
                    }
                }
                
            } else {
                JOptionPane.showMessageDialog(null, "Hidato incorrecte", "Incorrecte", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_BotoValidarActionPerformed
    /**
     * Event que canvia a la vista Menu en premer el boto sortir
     * @param evt 
     */
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controladorVistes.mostraVista("Menu");
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * Crea la taula a la vista per a que el usuari pugui posar els numeros
     * @param tamany 
     */
    public void createBoard (int tamany)
    {
        matriu = new int[tamany][tamany];
        
        int width  = 40;
        int height = 40;
        int x   = 15;
        int y   = 15;
        int files  = matriu.length;
        int columnes = matriu[0].length;
        tauler = new JTextField[files][columnes];
        for (int i = 0;i < files; ++i) {
            x = 15;
            for (int j = 0;j <columnes; ++j) {
                tauler[i][j] = new JTextField();
                tauler[i][j].setBounds(x+50, y+100, width, height);
                this.add(tauler[i][j]);
                x +=45;
            }
            y += 45;
        }
        this.setPreferredSize(new Dimension(files*45 + 250, files*45 + 200));
        controladorVistes.pack();
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotoValidar;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
