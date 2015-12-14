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
public class SerialitzadorDades extends Serialitzador {

    // Les direccions a passar son:
    //      Dades/Rankings/
    //      Dades/Estadistiques/
    //      Dades/Taulers/
    //      Dades/Usuaris/
    
    /**
     * Funcio encarregada de destruir fitxers de la BD. Utilitza funcions de la superclasse.
     * @param name Nom del fitxer a destruir
     * @param dir Path del directori on hi ha el fitxer
     * @return True en cas de que el fitxer es destrueixi correctament, false en cas contrari
     */
    public boolean destruir(String name, String dir) {
        return super.destruirObjecte(name, dir);
    }
    
    /**
     * Funcio encarregada de guardar objectes a la BD. Utilitza funcions de la superclasse.
     * @param obj Objecte que sera guardat a la BD
     * @param name Nom del objecte
     * @param dir Path del directori on es guardara el objecte
     * @return  True en cas de que el objecte es guardi correctament, false en cas contrari
     */
    public boolean guardar(Object obj, String name, String dir) {
        return super.serialitzarObjecte(obj, name, dir);
    }
    
    /**
     * Funcio encarregada de carergar objectes de la BD. Utilitza funcions de la superclasse.
     * @param name Nom del fitxer a carregar
     * @param dir Path del directori on hi ha el fitxer a carregar
     * @return Objecte de tipus generic amb la informacio demanada, Objecte de tipus generic buit en cas de error
     */
    public Object carregar(String name, String dir) {
        return super.deserialitzarObjecte(name, dir);
    }
}