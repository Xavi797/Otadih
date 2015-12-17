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
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

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
    int [][] matriu_aux;
    JTextField[][] tauler;
    /**
     * Creates new form vistaJugar
     */
    
    public VistaJugar(ControladorDomini contD, ControladorVistes contV) {
        
        initComponents();
        controladorDomini = contD;
        controladorVistes = contV;
        plataformaCeles = new JPanel();
        
        Border border = BorderFactory.createLineBorder(Color.BLACK, 3);
        HelpLabel.setBorder(border);
        HelpLabel.setVisible(false);
       
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
        HelpLabel = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jButton1.setText("Soluciona");
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Activa ajudes");
        jToggleButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guarda partida");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        TimeLabel.setBackground(Color.WHITE);

        botoSortir.setText("Sortir");
        botoSortir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoSortirActionPerformed(evt);
            }
        });

        HelpLabel.setBackground(new java.awt.Color(255, 250, 250));
        HelpLabel.setFont(new java.awt.Font("Droid Sans", 0, 14)); // NOI18N

        jButton3.setText("Acaba");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Check Caselles");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(HelpLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 525, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botoSortir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGap(34, 34, 34))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(15, 15, 15)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jToggleButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 125, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(botoSortir)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(HelpLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        matriu = controladorDomini.getTaulerSolucionatPerVista();
        for (JTextField[] ts : tauler)
                for (JTextField t : ts)
                    this.remove(t);
        createBoard();
        JOptionPane.showMessageDialog(null,"Rendicio!!","Information",JOptionPane.INFORMATION_MESSAGE);
        //HelpLabel.setText("");
        surt();
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
        if (resposta == 0) {
            for (JTextField[] ts : tauler)
                for (JTextField t : ts)
                    this.remove(t);
            HelpLabel.setText("");
            controladorVistes.mostraVista("Menu");

        }
        //VistaPopUp vistaPop = new VistaPopUp(controladorDomini, controladorVistes);
        //vistaPop.setVisible(true);
        //this.add(vistaPop);
    }//GEN-LAST:event_botoSortirActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        
        if (!HelpLabel.isVisible())
            HelpLabel.setVisible(true);
        else  HelpLabel.setVisible(false);
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String inputValue = JOptionPane.showInputDialog("Possa un nom a la partida");
        if (inputValue != null) {
            
            boolean sobreescriure = false;
            String anteriorNom = inputValue;
            boolean resultatGuardar = controladorDomini.guardarPartida(inputValue, sobreescriure);
            
            while (!resultatGuardar) {
                inputValue = JOptionPane.showInputDialog("La partida ja existeix. Per sobreescriure posa el mateix nom");
                if (inputValue == null) break;
                
                if (inputValue.equals(anteriorNom)) sobreescriure = true;
                else {
                    anteriorNom = inputValue;
                }
                resultatGuardar = controladorDomini.guardarPartida(inputValue, sobreescriure);
            }
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if(controladorDomini.acabat()){
                if(controladorDomini.bensolucionat()){
                    JOptionPane.showMessageDialog(null,"Hidato resolt correctament!!!","Information",JOptionPane.INFORMATION_MESSAGE);
                    controladorDomini.actualitzaRanking();
                    //controladorDomini.guardaPuntuacio();
                    surt();
                }
                else{
                    JOptionPane.showMessageDialog(null,"Hidato mal solucionat :( !!!","Information",JOptionPane.INFORMATION_MESSAGE);
                    surt();
                    //Pop up de mal solucionat!!!!
                    
                }
                
            }
        else
            JOptionPane.showMessageDialog(null,"Encara no s'ha completat","Information",JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ArrayList<Integer> llista = new ArrayList();
        if(controladorDomini.checkTauler(llista)){
            JOptionPane.showMessageDialog(null,"Totes les caselles correctes!!!","Information",JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null,"Tens caselles mal colocades!","Information",JOptionPane.INFORMATION_MESSAGE);
            for(int i = 0; i < tauler.length; ++i){
                for(int j = 0; j < tauler.length; ++j){
                    String num = tauler[i][j].getText();
                    int n;
                    if (num.isEmpty()){
                        n = 0;

                    } else {
                        n=Integer.parseInt(num);
                    }
                    if (llista.contains(n) && n!=0) {
                        tauler[i][j].setBackground(Color.red);
                    }
                }
            }
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed
   
    public void setMatriu() {
        matriu = controladorDomini.getTaulerPerVista();
        matriu_aux = controladorDomini.getTaulerPartidaPerVista();
        if (matriu.length >= 8)
        jToggleButton1.setVisible(false);

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
            
            List<Integer> numsLabel;
            ArrayList<Integer> numsAjuda = new ArrayList();
            String resultat= "";
            numsLabel = controladorDomini.getPropers();
            int[] dirHorit ={1,1,1,0,0,-1,-1,-1};
            int[] dirVerti ={1,0,-1,1,-1,1,0,-1};
            int novaPosX;
            int novaPosY;
            if (matriu[x][y] > 0) {
                HelpLabel.setText("Nombre ben colocat");
                return;
            }
                    
            controladorDomini.numsPosibles(x, y, numsAjuda);
            for(int aux = 0; aux < numsAjuda.size(); ++aux){
                resultat += numsAjuda.get(aux) + " ";
            }
            
            if (resultat.isEmpty()) HelpLabel.setText("Cap nombre possible!");
            else HelpLabel.setText(resultat);
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
         
            
            boolean setCorrect = controladorDomini.setCela(x, y, n);
            if (!setCorrect && n!=0) {
                tauler[x][y].setBackground(Color.red);
            } else {
                tauler[x][y].setBackground(Color.white);
                matriu[x][y] = n;
            }     
        }   
    }
    
    public void surt(){
        for (JTextField[] ts : tauler)
                for (JTextField t : ts)
                    this.remove(t);
            HelpLabel.setText("");
            controladorVistes.mostraVista("Menu");
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
                    if(matriu_aux[i][j] != 0) tauler[i][j].setText(Integer.toString(matriu_aux[i][j]));
                    tauler[i][j].addFocusListener(new ActionVistaCela(i, j));
                }
                //System.out.print(matriu[i][j]);

                tauler[i][j].setBounds(x, y, width, height);
                this.add(tauler[i][j]);
                x +=45;
            }
            y += 45;
        }

        this.setPreferredSize(new Dimension(files*45 + 220, files*45 + 80));
        controladorVistes.pack();
        
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel HelpLabel;
    private javax.swing.JLabel TimeLabel;
    private javax.swing.JButton botoSortir;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables
}
