/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

/**
 * Classe contenidora d'informació. Cada usuari, teoricament, representa a una persona física que té accés a l'aplicació.
 * @author jaume
 */
public class Usuari {
    private String nom = "user";
    private String password = "123";
    private String codi = "123";
    private Estadistiques estadistica;

    /**
     * getEstadistica() retorna les propies Estadistiques.
     * @return Retorna les Estadistiques del usuari sobre el que s'ha fet la crida a la funció
     */
    public Estadistiques getEstadistica() {
        return estadistica;
    }

    /**
     * Constructor bàsic. Les variables estan inicialitzades a 'user' (nom) i '123' (password i codi)
     */
    public Usuari() {}
    
    /**
     * Constructor. L'usuari té el nom inicialitzat i el password (i codi) definits com a '123'
     * @param nom Nom de l'usuari
     */
    public Usuari(String nom) {
        this.nom = nom;
    }
    
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

