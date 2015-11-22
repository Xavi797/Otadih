/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistes;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author xavi
 */
public class vistaJugar extends javax.swing.JFrame {



    /**
     * Creates new form vistaJugar
     */
    
    public vistaJugar() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 353, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(69, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    public static void createBoard (int[][] matriu)
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
                jPanel1.add(tauler[i][j]);
                x +=55;
            }
            y += 55;
        }  
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
