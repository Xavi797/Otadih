/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Vistes;
import Domini.Controlador.ControladorDomini;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Shape;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author xavi
 */
public class VistaInici extends VistaGenerica {

    /**
     * Creates new form VistaInici
     */
    ControladorDomini controladorDomini;
    ControladorVistes controladorVistes;
    Image image;
    /**
     * Constructora principal que inicialitza altres controladors i el propi
     * panel.
     * @param contDomini
     * @param contVistes 
     */
    public VistaInici(ControladorDomini contDomini , ControladorVistes contVistes) {
        initComponents();
        controladorDomini = contDomini;
        controladorVistes = contVistes;
        Font font = new Font("Verdana", Font.BOLD, 14);
        titulLabel.setFont(font);
        image = new ImageIcon(getClass().getResource("japan.jpg")).getImage();
        image = image.getScaledInstance(1050, 600,Image.SCALE_SMOOTH);
        //this.paintComponent(this.getGraphics(), image);
        
    }

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image,0,0,this);
    }
    
    /*public void paintComponent(Graphics g, Image image)
    {
        
        
        if (image != null)
        {
            g.drawImage(image,0,0,null);
          }
        super.paintComponent(g);
    }*/


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        botoLogIn = new javax.swing.JButton();
        botoRegistrar = new javax.swing.JButton();
        usuariLogIn = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        paraulaClau = new javax.swing.JTextField();
        userRegistrar = new javax.swing.JTextField();
        contrasenyaRegistrar = new javax.swing.JPasswordField();
        titulLabel = new javax.swing.JLabel();
        contrasenyaLogIn = new javax.swing.JPasswordField();

        jScrollPane1.setViewportView(jTextPane1);

        botoLogIn.setText("Log In");
        botoLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botoLogInMouseClicked(evt);
            }
        });
        botoLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoLogInActionPerformed(evt);
            }
        });

        botoRegistrar.setText("Registrar-se");
        botoRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botoRegistrarActionPerformed(evt);
            }
        });

        usuariLogIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usuariLogInMouseClicked(evt);
            }
        });
        usuariLogIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuariLogInActionPerformed(evt);
            }
        });

        jLabel1.setText("Usuari");

        jLabel2.setText("Contrasenya");

        jLabel3.setText("Usuari");

        jLabel4.setText("Contrasenya");

        jLabel5.setText("Paraula clau");

        userRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userRegistrarActionPerformed(evt);
            }
        });

        titulLabel.setText("Benvingut al joc hidato, registrat per començar  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userRegistrar)
                            .addComponent(paraulaClau)
                            .addComponent(contrasenyaRegistrar)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuariLogIn)
                            .addComponent(contrasenyaLogIn)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(botoRegistrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botoLogIn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(346, 346, 346))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titulLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuariLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(contrasenyaLogIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botoLogIn)
                .addGap(66, 66, 66)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(contrasenyaRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(paraulaClau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(botoRegistrar)
                .addContainerGap(87, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void usuariLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuariLogInActionPerformed
        
    }//GEN-LAST:event_usuariLogInActionPerformed

    private void usuariLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usuariLogInMouseClicked
        
    }//GEN-LAST:event_usuariLogInMouseClicked

    private void botoLogInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botoLogInMouseClicked
        usuariLogIn.setVisible(true);
    }//GEN-LAST:event_botoLogInMouseClicked
    /**
     * Event de login on comproba si l'usuari esta ja registrat per donar acces
     * o denegarlo en cas contrari o que la contraseña sigui incorrecta.
     * @param evt 
     */
    private void botoLogInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoLogInActionPerformed
        String nomUserLogIn = usuariLogIn.getText();
        String passUserLogIn= contrasenyaLogIn.getText();
        
        boolean resposta = controladorDomini.logInUsuari(nomUserLogIn, passUserLogIn);
        if (!resposta) JOptionPane.showMessageDialog(null, "Usuari o contrasenya incorrectes", "Atenció", JOptionPane.ERROR_MESSAGE);
        else controladorVistes.mostraVista("Menu");
        
    }//GEN-LAST:event_botoLogInActionPerformed
    /**
     * Event que s'encarrega del registre d'usuaris, comprobant la seva existencia
     * i si no es aixi afegintlo
     * @param evt 
     */
    private void botoRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botoRegistrarActionPerformed
        String nomUserRegister = userRegistrar.getText();
        String passUserRegister= contrasenyaRegistrar.getText();
        String paraula = paraulaClau.getText();
        boolean resposta = controladorDomini.registrarUsuari(nomUserRegister, passUserRegister, paraula);
        if (!resposta) JOptionPane.showMessageDialog(null, "Usuari ja registrat", "Atenció", JOptionPane.ERROR_MESSAGE);
        else controladorVistes.mostraVista("Menu");
        //controladorVistes.mostraVista("Menu"); // s'ha de borrar;
    }//GEN-LAST:event_botoRegistrarActionPerformed

    private void userRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userRegistrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userRegistrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botoLogIn;
    private javax.swing.JButton botoRegistrar;
    private javax.swing.JPasswordField contrasenyaLogIn;
    private javax.swing.JPasswordField contrasenyaRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextField paraulaClau;
    private javax.swing.JLabel titulLabel;
    private javax.swing.JTextField userRegistrar;
    private javax.swing.JTextField usuariLogIn;
    // End of variables declaration//GEN-END:variables


        

    
}
