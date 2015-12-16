/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.File;
import java.util.List;

/**
 * Classe encarregada del guardat i carregat especific de partides
 * @author jaume.guell
 */
public class SerialitzadorPartides extends Serialitzador {
    private final String direccio = "../Dades/Partides/";   /* Conte el path de la carpeta on es guardaran les partides */
    
    /**
     * Funcio encarregada de destruir fitxers de la BD, utilitza funcions de la superclasse.
     * @param name Nom del fitxer a destruir
     * @param user Nom del usuari que esta realitzant la operacio
     * @return True en cas de que el fitxer es destrueixi correctament, false en cas contrari
     */
    public boolean destruirPartida(String name, String user) {
        String dirAux = direccio + user + "/";
        return super.destruirObjecte(name, dirAux);
    }
    
    /**
     * Funcio encarregada de destruir totes les partides del usuari amb nom name.
     * @param user Nom del usuari del que es destruiran totes les seves partides
     */
    public void destruirTotesPartides(String user) {
        String dirAux = direccio + user + "/";
        
        File f = new File(dirAux);
        File[] list = f.listFiles();
        while (list != null) {
            for (File fil : list) {
                if (fil.isDirectory() == false) fil.delete();
            }
        }
        
        f.delete(); //Elimina carpeta
    }
    
    /**
     * Funcio encarregada de guardar objectes a la BD, utilitza funcions de la superclasse.
     * @param obj Objecte que sera guardat a la BD
     * @param name Nom del objecte
     * @param user Nom del usuari que esta realitzant la operacio
     * @return  True en cas de que el objecte es guardi correctament, false en cas contrari
     */
    public boolean guardarPartida(Object obj, String name, String user) {
        String dirAux = direccio + user + "/";
        File f = new File(dirAux);
        f.mkdir();  //Creacio nou folder, si ja existia no fa res
        return super.serialitzarObjecte(obj, name, dirAux);
    }
    
    /**
     * Funcio encarregada de carergar objectes de la BD, utilitza funcions de la superclasse.
     * @param name Nom del fitxer a carregar
     * @param user Nom del usuari que esta realitzant la operacio
     * @return Objecte de tipus generic amb la informacio demanada, Objecte de tipus generic buit en cas de error
     */
    public Object carregarPartida(String name, String user) {
        String dirAux = direccio + user + "/";
        return super.deserialitzarObjecte(name, dirAux);
    }
    
    /**
     * Funcio encarregada de carregar en una llista tots els noms de les partides a mitges de un usuari, utilitza funcions de la superclasse.
     * @param user Nom del Usuari a aconseguir el nom de les seves partides
     * @return Llista de Strings amb el nom de les seves partides, llista buida en cas de no ternir-ne cap
     */
    public List<String>aconsegueixLlista(String user) {
        String dirAux = direccio + user + "/";
        File f = new File(dirAux);
        f.mkdir();  //Per evitar errors
        return super.llistaObjectes(dirAux);
    }
    
    /**
     * Funcio encarregada de comprovar si la partida name de user ja existeix a la BD.
     * @param name Nom del usuari
     * @param user Nom de la partida
     * @return True en cas de que ja existeixi, false en cas contrari
     */
    public boolean comprovaPartida(String name, String user) {
        String dirAux = direccio + user + "/";
        return super.existeixObjecte(name, dirAux);
    }
}