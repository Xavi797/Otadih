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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import java.util.List;

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
    JTextField[][] tauler;
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
        botoSortir = new javax.swing.JButton();

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

        botoSortir.setText("Sortir");
        botoSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoSortirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(569, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(TimeLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jToggleButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(botoSortir, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(34, 34, 34))))
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
                .addGap(18, 18, 18)
                .addComponent(botoSortir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        matriu = controladorDomini.getTaulerSolucionatPerVista();
        createBoard();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botoSortirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoSortirActionPerformed
        Object[] options = {"Sortir",
                    "Cancelar"};
        int resposta = JOptionPane.showOptionDialog(controladorVistes,
        "Estàs segur que vols sortir de la partida actual",
        "Confrimació",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,     
        options,  
        options[0]);
        if (resposta == 0) controladorVistes.mostraVista("Menu");
        //VistaPopUp vistaPop = new VistaPopUp(controladorDomini, controladorVistes);
        //vistaPop.setVisible(true);
        //this.add(vistaPop);
    }//GEN-LAST:event_botoSortirActionPerformed
   
    public void setMatriu() {
        matriu = controladorDomini.getTaulerPerVista();
    }
    
    private class ActionVistaCela implements FocusListener {

        int x;
        int y;
        
        public ActionVistaCela(int i, int j) {
            x = i;
            y = j;
        }

        @Override
        public void focusGained(FocusEvent e) {
            
        }

        @Override
        public void focusLost(FocusEvent e) {
 
            String num = tauler[x][y].getText();
            int n;
            if (num.isEmpty()){
                n = 0;
                
            } else {
                n=Integer.parseInt(num);
            }
            
            List<Integer> propers = controladorDomini.getPropers();
            //printa els propers en un layout
            
            boolean setCorrect = controladorDomini.setCela(x, y, n); // Controlar que no pongan letra
            if (!setCorrect && n!=0) {
                tauler[x][y].setBackground(Color.red);
            } else {
                tauler[x][y].setBackground(Color.white);
            }
            
            if(controladorDomini.acabat()){
                if(controladorDomini.bensolucionat()){
                    //Pop up de correcte ben solucionat!!!
                }
                else{
                    //Pop up de mal solucionat!!!!
                    
                }
                
            }
        }
    
    }
    
    public void createBoard ()
    {

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
                if (matriu[i][j] == -1) {
                    tauler[i][j].setEditable(false);
                    tauler[i][j].setBackground(Color.BLACK);
                }
                else if (matriu[i][j] != 0) {
                    tauler[i][j].setEditable(false);
                    tauler[i][j].setText(Integer.toString(matriu[i][j]));
                    tauler[i][j].setBackground(Color.GRAY);
                } else {
                    tauler[i][j].addFocusListener(new ActionVistaCela(i, j));
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
    private javax.swing.JButton botoSortir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
