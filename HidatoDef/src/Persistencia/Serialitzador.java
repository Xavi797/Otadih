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
import java.util.Scanner;
import java.util.List;

/**
 * Classe encarregada del guardat i carrega de fitxers. 
 * @author jaume
 */
public class Serialitzador {
  
    private String logerror;
    private ObjectOutputStream escriptorOb;
    private ObjectInputStream lectorOb;
    
    Scanner in = new Scanner(System.in);

    /**
     * Getter encarregat d'obtenir logerror.
     * @return Retorna un String que conte el error produit
     */
    public String getLogerror() {
        return logerror;
    }

    /**
     * Setter encarregat de modificar el parametre logerror.
     * @param logerror Es un String que conté l'error produit (en cas necessari)
     */
    public void setLogerror(String logerror) {
        this.logerror = logerror;
    }
    
    public boolean existenciaObjecte(String name, String tipus) {
        
        String directori = "";
        if (tipus == "Tauler") {
            directori = "Dades/Taulers/";
            name = name + ".taul";
        }
        //Ampliable per futurs guardats diferents
        
        File f = new File(directori);
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
     * Funcio encarregada de guardar objectes com a fitxers en diferents localitzacions.
     * @param obj Objecte a guardar
     * @param name Nom del document a guardar
     * @return Retorna un valor boolea que indica si s'ha efectuat correctament el proces de guardat
     */
    public boolean SerialitzarObjecte (Object obj, String name, String tipus) {
        
        int ordre = 0;
        while (existenciaObjecte(name, tipus) && ordre == 0) {
            System.out.println("El fitxer '"+name+"' ja exiseix. Vols sobreescriure'l?" );
            System.out.println("0 --> NO, canviar el nom // 1 --> SI, sobreescriure");
            
            ordre = in.nextInt();
            
            if (ordre == 0) {
                System.out.println("Escriu el nou nom:");
                name = in.next();
            }
        }
        
        try {
            String directori = "";
            if (tipus == "Tauler") {
                directori = "Dades/Taulers/" + name + ".taul";
            }
            //Ampliable per futurs guardats diferents
            
            escriptorOb = new ObjectOutputStream(new FileOutputStream(directori));
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
     * Funcio encarregada de carregar objectes desde fitxers.
     * @param archiu Nom del document a carregar
     * @return Retorna un objecte que conte les dades carregades
     */
    public Object DeserialitzarObjecte (String archiu, String tipus) {
        try{
            String direccio = "";
            if (tipus == "Tauler") {
                direccio = "Dades/Taulers/" + archiu + ".taul";
            }
            //Ampliable per futurs carregats diferents
            
            File f = new File(direccio);
            lectorOb = new ObjectInputStream(new FileInputStream(f));
            Object obj;
            obj = lectorOb.readObject();
            return obj;
        }catch (Exception ex) {
            this.logerror = ex.getMessage();
            System.out.println("Error al carregar");
            return new Object();    //Si hi ha error retorna un objecte buit i treu un missatge per pantalla
        }
    }
}