/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Clases;

import java.io.Serializable;

/**
 *
 * @author jaume.guell
 */
public class Partida implements Serializable {
    private Usuari user;
    private Rankings ranking;
   // private Hidato hidato;
    private static int ultimId = 1;
    private int idPartida;// buscar com fer unica
    private int temps; //provisional.buscar funcio de clock
    private int numChekcs;
    private boolean solve;
}