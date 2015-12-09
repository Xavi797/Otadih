/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.io.File;

/**
 * Classe encarregada del guardat i carregat especific de partides
 * @author jaume.guell
 */
public class SerialitzadorPartides extends Serialitzador {
    private final String direccio = "Dades/Partides/";   /* Conte el path de la carpeta on es guardaran les partides */
    
    /**
     * Funcio encarregada de destruir fitxers de la BD. Utilitza funcions de la superclasse.
     * @param name Nom del fitxer a destruir
     * @param user Nom del usuari que esta realitzant la operacio
     * @return True en cas de que el fitxer es destrueixi correctament, false en cas contrari
     */
    public boolean destruirPartida(String name, String user) {
        String dirAux = direccio + user + "/";
        return super.destruirObjecte(name, dirAux);
    }
    
    /**
     * Funcio encarregada de guardar objectes a la BD. Utilitza funcions de la superclasse.
     * @param obj Objecte que sera guardat a la BD
     * @param name Nom del objecte
     * @param user Nom del usuari que esta realitzant la operacio
     * @return  True en cas de que el objecte es guardi correctament, false en cas contrari
     */
    public boolean guardarPartida(Object obj, String name, String user) {
        String dirAux = direccio + user + "/";
        File f = new File(dirAux);
        f.mkdir();  //Creacio nou folder, si ja existia no fa res
        return super.serialitzarObjecte(obj, name, direccio);
    }
    
    /**
     * Funcio encarregada de carergar objectes de la BD. Utilitza funcions de la superclasse.
     * @param name Nom del fitxer a carregar
     * @param user Nom del usuari que esta realitzant la operacio
     * @return Objecte de tipus generic amb la informacio demanada, Objecte de tipus generic buit en cas de error
     */
    public Object carregarPartida(String name, String user) {
        String dirAux = direccio + user + "/";
        return super.deserialitzarObjecte(name, dirAux);
    }
}