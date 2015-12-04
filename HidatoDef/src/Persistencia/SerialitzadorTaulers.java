/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Classe encarregada del guardat i carregat especific de taulers
 * @author jaume.guell
 */
public class SerialitzadorTaulers extends Serialitzador {
    private final String direccio = "Dades/Taulers/";
    
    /**
     * Funcio encaregada de comprovar l'existencia del fitxer amb nom 'name'
     * @param name Nom del fitxer
     * @param user Valor null, utilitzat en una altra subclasse de Serialitzador
     * @return Retorna true en cas de que el nom del fitxer a guardar ja existeixi, false en cas contrari
     */
    @Override
    public boolean existenciaObjecte(String name, String user) {
        
        String dirAux = direccio;
        name = name + ".taul";
        
        File f = new File(dirAux);
        File[] list = f.listFiles();
        if (list != null) {
            for (File fil : list) {
                if (fil.getName().equals(name)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * Funcio encarregada de destruir fitxers de la BD
     * @param name Nom del fitxer a destruir
     * @param user Valor null, utilitzat en una altra subclasse de Serialitzador
     * @return Retorna true en cas de que el fitxer es destrueixi correctament, false en cas contrari 
     */
    @Override
    public boolean destrueixObjecte(String name, String user) {
        
        String objectiu = direccio + name + ".taul";
          
        if (existenciaObjecte(name, null)) {
            File f = new File(objectiu);
            f.delete();
            return true;
        }
        else {
            System.out.println("El fitxer demanat no existeix");
            return false;
        }
    }
    
    /**
     * Funcio encarregada de guardar objectes com a fitxers en diferents localitzacions.
     * @param obj Objecte a guardar
     * @param name Nom del objecte a guardar
     * @param user Valor null, utilitzat en una altra subclasse de Serialitzador
     * @return Retorna un valor boolea que indica si s'ha efectuat correctament el proces de guardat
     */
    @Override
    public boolean serialitzarObjecte (Object obj, String name, String user) {
        
        int ordre = 0;
        while (existenciaObjecte(name, null) && ordre == 0) {
            System.out.println("El fitxer '"+name+"' ja exiseix. Vols sobreescriure'l?" );
            System.out.println("0 --> NO, canviar el nom // 1 --> SI, sobreescriure");
            
            ordre = in.nextInt();
            
            if (ordre == 0) {
                System.out.println("Escriu el nou nom:");
                name = in.next();
            }
        }
        
        String dirAux = direccio + name + ".taul";
        try {
            escriptorOb = new ObjectOutputStream(new FileOutputStream(dirAux));
            escriptorOb.writeObject(obj);
            escriptorOb.close();
            return true;
        } catch (Exception ex) {
            this.logerror = ex.getMessage();
            System.out.println("Error al guardar");
            return false;
        }
    }
    
    /**
     * Funcio encarregada de carregar taulers desde els fitxers.
     * @param name Nom del fitxer a carregar
     * @param user Valor null, utilitzat en una altra subclasse de Serialitzador
     * @return Retorna un objecte de tipus generic que conte les dades carregades, esta buit en cas de error
     */
    @Override
    public Object deserialitzarObjecte (String name, String user) {

        if (!existenciaObjecte(name, null)) {
            System.out.println("El fitxer demanat no existeix");
            return new Object();    //Si hi ha error retorna un objecte buit
        }
        String dirAux = direccio + name + ".taul";
        try{     
            File f = new File(dirAux);
            lectorOb = new ObjectInputStream(new FileInputStream(f));
            Object obj;
            obj = lectorOb.readObject();
            return obj;
            
        } catch (IOException | ClassNotFoundException ex) {
            this.logerror = ex.getMessage();
            System.out.println("Error al carregar");
            return new Object();    //Si hi ha error retorna un objecte buit 
        }
    }
}
