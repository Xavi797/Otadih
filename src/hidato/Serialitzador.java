/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hidato;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe encarregada del guardat i càrrega de fitxers. 
 * @author jaume
 */
public class Serialitzador {
  
    private String logerror;
    private ObjectOutputStream escriptorOb;
    private ObjectInputStream lectorOb;

    /**
     * Getter encarregat d'obtenir logerror.
     * @return Retorna un String que conté el error produit
     */
    public String getLogerror() {
        return logerror;
    }

    /**
     * Setter encarregat de modificar el paràmetre logerror.
     * @param logerror És un String que conté l'error produït (en cas necessari)
     */
    public void setLogerror(String logerror) {
        this.logerror = logerror;
    }
    
    /**
     * Funció encarregada de guardar objectes com a fitxers en diferents localitzacions.
     * @param obj Objecte a guardar
     * @param name Path (que també conté el nom del fitxer a crear) on es guardarà el objecte
     * @return Retorna un valor booleà que indica si s'ha efectuat correctament el procés de guardat
     */
    public boolean SerialitzarObjecte (Object obj, String name) {
        try {
            escriptorOb = new ObjectOutputStream(new FileOutputStream(name));
            escriptorOb.writeObject(obj);
            escriptorOb.close();
            return true;
        } catch (Exception ex) {
            this.logerror = ex.getMessage();
            return false;
        }
    }
    
    /**
     * Funció encarregada de carregar objectes desde fitxers.
     * @param archiu Path (que també conté el nom) del fitxer a carregar
     * @return Retorna un objecte que conté les dades carregades
     */
    public Object DeserialitzarObjecte (String archiu) {
        try{
            File f = new File(archiu);
            lectorOb = new ObjectInputStream(new FileInputStream(f));
            Object obj;
            obj = lectorOb.readObject();
            return obj;
        }catch (Exception ex) {
            this.logerror = ex.getMessage();
            return new Object();    //Si hi ha error retorna un objecte buit
        }
    }
}
