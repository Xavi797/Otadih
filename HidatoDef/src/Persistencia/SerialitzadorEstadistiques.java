/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 * Classe encarregada del guardat i carregat especific de estadistiques
 * @author jaume.guell
 */
public class SerialitzadorEstadistiques extends Serialitzador {
    private final String direccio = "/Dades/Estadistiques/";
    
    /**
     * Funcio encarregada de destruir fitxers de la BD. Utilitza funcions de la superclasse.
     * @param name Nom del fitxer a destruir
     * @return True en cas de que el fitxer es destrueixi correctament, false en cas contrari
     */
    public boolean destruir(String name) {
        return super.destruirObjecte(name, direccio);
    }
    
    /**
     * Funcio encarregada de guardar objectes a la BD. Utilitza funcions de la superclasse.
     * @param obj Objecte que sera guardat a la BD
     * @param name Nom del objecte
     * @return  True en cas de que el objecte es guardi correctament, false en cas contrari
     */
    public boolean guardar(Object obj, String name) {
        return super.serialitzarObjecte(obj, name, direccio);
    }
    
    /**
     * Funcio encarregada de carergar objectes de la BD. Utilitza funcions de la superclasse.
     * @param name Nom del fitxer a carregar
     * @return Objecte de tipus generic amb la informacio demanada, Objecte de tipus generic buit en cas de error
     */
    public Object carregar(String name) {
        return super.deserialitzarObjecte(name, direccio);
    }
}
