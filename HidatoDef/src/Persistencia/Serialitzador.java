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
    
    /**
     * Funcio encarregada de destruir fitxers de la BD
     * @param name Nom del objecte a destruir
     * @param tipus Tipus del objecte a destruir
     * @return Retorna true en cas de que el objecte es destrueixi correctament, false en cas contrari 
     */
    public boolean destrueixObjecte(String name, String tipus) {
        try{
            String objectiu = "";
            if ("Tauler".equals(tipus)) {
                objectiu = "Dades/Taulers/" + name + ".taul";
            }
            else if ("Usuari".equals(tipus)) {
                objectiu = "Dades/Usuaris/" + name + ".usur";
            }
            else if ("Partida".equals(tipus)) {
                objectiu = "Dades/Partides/" + name + ".part";
            }
            else if ("Ranking".equals(tipus)) {
                objectiu = "Dades/Rankings/" + name + ".rank";
            }
            else if ("Estadistica".equals(tipus)) {
                objectiu = "Dades/Estadistiques/" + name + ".stat";
            }
            //Ampliable per futures destruccions diferents
            
            if (existenciaObjecte(name, tipus)) {
                File f = new File(objectiu);
                f.delete();
                return true;
            }
            else {
                System.out.println("El fitxer demanat no existeix");
                return false;
            }
    	   
    	} catch (Exception ex) {
            this.logerror = ex.getMessage();
            System.out.println("Error al destruir el objecte");
            return false;
    	}
    }
    
    /**
     * Funcio encaregada de comprovar l'existencia del fitxer de nom i tipus donats
     * @param name Nom del objecte a guardar
     * @param tipus Tipus del objecte a guardar
     * @return Retorna true en cas de que el nom del objecte a guardar ja existeixi, false en cas contrari
     */
    public boolean existenciaObjecte(String name, String tipus) {
        
        String directori = "";
        if ("Tauler".equals(tipus)) {
            directori = "Dades/Taulers/";
            name = name + ".taul";
        }
        else if ("Usuari".equals(tipus)) {
            directori = "Dades/Usuaris/";
            name = name + ".usur";
        }
        else if ("Partida".equals(tipus)) {
            directori = "Dades/Partides/";
            name = name + ".part";
        }
        else if ("Ranking".equals(tipus)) {
            directori = "Dades/Rankings/";
            name = name + ".rank";
        }
        else if ("Estadistica".equals(tipus)) {
            directori = "Dades/Estadistiques/";
            name = name + ".stat";
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
     * @param name Nom del objecte a guardar
     * @param tipus Defineix el tipus d'objecte que s'esta guardant
     * @return Retorna un valor boolea que indica si s'ha efectuat correctament el proces de guardat
     */
    public boolean serialitzarObjecte (Object obj, String name, String tipus) {
        
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
            if ("Tauler".equals(tipus)) {
                directori = "Dades/Taulers/" + name + ".taul";
            }
            else if ("Usuari".equals(tipus)) {
                directori = "Dades/Usuaris/" + name + ".usur";
            }
            else if ("Partida".equals(tipus)) {
                directori = "Dades/Partides/" + name + ".part";
            }
            else if ("Ranking".equals(tipus)) {
                directori = "Dades/Rankings/" + name + ".rank";
            }
            else if ("Estadistica".equals(tipus)) {
                directori = "Dades/Estadistiques/" + name + ".stat";
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
     * Funcio encarregada de carregar objectes desde els fitxers.
     * @param name Nom del objecte a carregar
     * @param tipus Defineix el tipus d'objecte que s'esta carregant
     * @return Retorna un objecte que conte les dades carregades
     */
    public Object deserialitzarObjecte (String name, String tipus) {
        try{
            String direccio = "";
            if ("Tauler".equals(tipus)) {
                direccio = "Dades/Taulers/" + name + ".taul";
            }
            else if ("Usuari".equals(tipus)) {
                direccio = "Dades/Usuaris/" + name + ".usur";
            }
            else if ("Partida".equals(tipus)) {
                direccio = "Dades/Partides/" + name + ".part";
            }
            else if ("Ranking".equals(tipus)) {
                direccio = "Dades/Rankings/" + name + ".rank";
            }
            else if ("Estadistica".equals(tipus)) {
                direccio = "Dades/Estadistiques/" + name + ".stat";
            }
            //Ampliable per futurs carregats diferents
            
            if (existenciaObjecte(name, tipus)) {
                File f = new File(direccio);
                lectorOb = new ObjectInputStream(new FileInputStream(f));
                Object obj;
                obj = lectorOb.readObject();
                return obj;
            }
            else {
                System.out.println("El fitxer demanat no existeix");
                return new Object();    //Si hi ha error retorna un objecte buit i treu un missatge per pantalla
            }
        } catch (IOException | ClassNotFoundException ex) {
            this.logerror = ex.getMessage();
            System.out.println("Error al carregar");
            return new Object();        //Si hi ha error retorna un objecte buit i treu un missatge per pantalla
        }
    }
}