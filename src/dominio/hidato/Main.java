package hidato;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xavi
 */
public class Main {
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new vistaJugar().setVisible(true);
                int [][] matriu = {{-1,2,0,-1},{0,1,0,-1},{6,0,1,-1},{2,0,1,-1}}; 
                vistaJugar.createBoard(matriu);
            }
        });
    }
}
