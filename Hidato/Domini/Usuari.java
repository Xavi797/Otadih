/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/**
 *
 * @author xavi
 */
public class Usuari extends UsuariCompartit{
    
    private String nom; 
    private String password;
    private String codi;

    /**
     * Constructor. L'usuari té el nom, password i codi inicialitzats.
     * @param nom Nom de l'usuari
     * @param password Password de l'usuari
     * @param codi Codi de l'usuari
     */
    public Usuari(String nom, String password, String codi) { 
       this.nom = nom;
       this.password = password;
       this.codi = codi;
    }

    /**
     * Getter encarregat d'obtenir el nom de l'usuari.
     * @return Retorna un String que conté el nom de l'usuari
     */
    public String getNom() {
        return nom;
    }

    /**
     * Setter encarregat de canviar el nom de l'usuari.
     * @param nom Nou nom de l'usuari
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Getter encarregat d'obtenir el password de l'usuari.
     * @return Retorna un String que conté el password de l'usuari
     */
    public String getPassword() {
        return password;
    }

    /**
     * Setter encarregat de canviar el password de l'usuari.
     * @param password Nou password de l'usuari
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Getter encarregat d'obtenir el codi de l'usuari.
     * @return Retorna un String que conté el codi de l'usuari
     */
    public String getCodi() {
        return codi;
    }

    /**
     * Setter encarregat de canviar el codi de l'usuari.
     * @param codi Nou codi de l'usuari
     */
    public void setCodi(String codi) {
        this.codi = codi;
    }
}