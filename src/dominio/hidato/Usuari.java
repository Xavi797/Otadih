/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

/**
 *
 * @author jaume.guell
 */
public class Usuari {
   private String nom;
   private String password;
   private String codi;
   private Estadistiques estadistica;

    public Estadistiques getEstadistica() {
        return estadistica;
    }

   public Usuari(String nom, String password, String codi) { 
       this.nom = nom;
       this.password = password;
       this.codi = codi;
   }
   
   
}

