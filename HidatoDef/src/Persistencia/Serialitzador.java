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
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Classe 'mare' encarregada del guardat i carrega de fitxers.
 * @author jaume.guell
 */
public class Serialitzador {
  
    private String logerror;    /* String encarregat de capturar els missatges de error */
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
    
    /**
     * Funcio encarregada de destruir fitxers de la BD.
     * @param name Nom del fitxer a destruir
     * @param path Direccio del fitxer a destruir
     * @return Retorna true en cas de que el fitxer es destrueixi correctament, false en cas contrari 
     */
    public boolean destruirObjecte(String name, String path) {
        if (existeixObjecte(name, path)) {
            String objectiu = path + name;
            File f = new File(objectiu);
            f.delete();
            return true;
        }
        else {
            //error
            return false;
        }
    }
    
    /**
     * Funcio encaregada de comprovar l'existencia del fitxer amb nom name.
     * @param name Nom del fitxer
     * @param path Direccio del fitxer a buscar
     * @return Retorna true en cas de que el nom del objecte a guardar ja existeixi, false en cas contrari
     */
    public boolean existeixObjecte(String name, String path) {
        File f = new File(path);
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
     * @param name Nom del objecte a guardar
     * @param path Direccio on es guardara el objecte
     * @return Retorna un valor boolea que indica si s'ha efectuat correctament el proces de guardat
     */
    public boolean serialitzarObjecte (Object obj, String name, String path) {
        /* int ordre = 0;
        while (existeixObjecte(name, path) && ordre == 0) {
            System.out.println("El fitxer '"+name+"' ja exiseix. Vols sobreescriure'l?" );
            System.out.println("0 --> NO, canviar el nom // 1 --> SI, sobreescriure");
            
            ordre = in.nextInt();
            
            if (ordre == 0) {
                System.out.println("Escriu el nou nom:");
                name = in.next();
            }
        } */
        
        try {
            String objectiu = path + name;
            ObjectOutputStream escriptorOb;
            escriptorOb = new ObjectOutputStream(new FileOutputStream(objectiu));
            escriptorOb.writeObject(obj);
            escriptorOb.close();
            return true;
        }
        catch (Exception ex) {
            this.logerror = ex.getMessage();
            System.out.println(logerror);
            return false;
        }
    }
    
    /**
     * Funcio encarregada de carregar objectes desde els fitxers.
     * @param name Nom del fitxer a carregar
     * @param path Direccio del fitxer a carregar
     * @return Retorna un objecte de tipus generic que conte les dades carregades, esta buit en cas de error
     */
    public Object deserialitzarObjecte (String name, String path) {
        if (!existeixObjecte(name, path)) {
            Object obj = null;
            return obj;    //Si hi ha error retornem un Objecte buit
        }
        
        try {
            String objectiu = path + name;
            File f = new File(objectiu);
            ObjectInputStream lectorOb;
            lectorOb = new ObjectInputStream(new FileInputStream(f));
            Object obj;
            obj = lectorOb.readObject();
            return obj;
        }
        catch (IOException | ClassNotFoundException ex) {
            this.logerror = ex.getMessage();
            System.out.println(logerror);
            Object obj = null;
            return obj;    //Si hi ha error retornem un Objecte buit
        }
    }
    
    /**
     * Funcio encarregada de llistar tots els objectes de un directori en concret de la BD.
     * @param path Direccio del directori de on es llistaran els fitxers
     * @return Retorna una llista de Strings amb els noms de tots els fitxers del directori
     */
    public List<String> llistaObjectes(String path) {
        List<String> list = new ArrayList<String>();
        File f = new File(path);
        File[] files = f.listFiles();
        
        if (files != null) {
            for (File fil : files) {
                if (fil.isDirectory() == false && !fil.isHidden()) {
                    list.add(fil.getName());
                }
            }
        }
        return list;
    }
}