/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia.Controlador;

import Persistencia.SerialitzadorDades;
import Persistencia.SerialitzadorPartides;
import java.util.List;

/**
 * Controlador encarregat de comunicar la capa de persistencia amb les capa de domini, gestiona les crides que el domini l'hi fa alhora d'accedir a la BD.
 * @author jaume.guell
 */
public class ControladorPersistencia {
    
    /* Serialitzadors encarregats de fer les operacions*/
    private final SerialitzadorDades SDades;          /* Utilitzat per a tot menys partides */
    private final SerialitzadorPartides SPartides;
    
    public ControladorPersistencia() {
        SDades = new SerialitzadorDades();
        SPartides = new SerialitzadorPartides();
    }
    
    /**
     * Funcio encarregada de fer la crida per guardar un Usuari.
     * @param user Usuari en questio
     * @param name Nom del usuari
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean guardaUser(Object user, String name) {
        return SDades.guardar(user, name, "../Dades/Usuaris/");
    }
    
    /**
     * Funcio encarregada de fer la crida per carregar un Usuari.
     * @param name Nom del usuari
     * @return Objecte amb les dades del usuari en cas de exit, objecte buit en cas contrari
     */
    public Object carregaUser(String name) {
        Object obj;
        return obj = SDades.carregar(name, "../Dades/Usuaris/");
    }
    
    /**
     * Funcio encarregada de fer la crida per destruir un Usuari.
     * @param name Nom del usuari
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean destrueixUser(String name) {
        return SDades.destruir(name, "../Dades/Usuaris/");
    }
    
    /**
     * Funcio encarregada de fer la crida per comprovar si ja existeix un Usuari amb nom name.
     * @param name Nom del que es vol comprovar la seva existencia
     * @return Cert en cas de que ja existeixi, false en cas contrari
     */
    public boolean comprovaUser(String name) {
        return SDades.existeixObjecte(name, "../Dades/Usuaris/");
    }
    
    /**
     * Funcio encarregada de fer la crida per guardar un Ranking.
     * @param rank Ranking en questio
     * @param name Nom del ranking
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean guardaRanking(Object rank, String name) {
        return SDades.guardar(rank, name, "../Dades/Rankings/");
    }
    
    /**
     * Funcio encarregada de fer la crida per carregar un Ranking.
     * @param name Nom del ranking
     * @return Objecte amb les dades del ranking en cas de exit, objecte buit en cas contrari
     */
    public Object carregaRanking(String name) {
        Object obj;
        return obj = SDades.carregar(name, "../Dades/Rankings/");
    }
    
    /**
     * Funcio encarregada de fer la crida per destruir un Ranking.
     * @param name Nom del ranking
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean destrueixRanking(String name) {
        return SDades.destruir(name, "../Dades/Rankings/");
    }
    
    /**
     * Funcio encarregada de fer la crida per comprovar si ja existeix un Ranking amb nom name.
     * @param name Nom del ranking
     * @return Cert en cas de que ja existeixi, false en cas contrari
     */
    public boolean comprovaRanking(String name) {
        return SDades.existeixObjecte(name, "../Dades/Rankings");
    }
    
    /**
     * Funcio encarregada de fer la crida per guardar una Estadistica.
     * @param stat Estadistica en questio
     * @param name Nom de la estadistica
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean guardaEstadistica(Object stat, String name) {
        return SDades.guardar(stat, name, "../Dades/Estadistiques/");
    }
    
    /**
     * Funcio encarregada de fer la crida per carregar una Estadistica.
     * @param name Nom de la estadistica
     * @return Objecte amb les dades de la estadistica en cas de exit, objecte buit en cas contrari
     */
    public Object carregaEstadistica(String name) {
        Object obj;
        return obj = SDades.carregar(name, "../Dades/Estadistiques/");
    }
    
    /**
     * Funcio encarregada de fer la crida per destruir una Estadistica.
     * @param name Nom de la estadistica
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean destrueixEstadistica(String name) {
        return SDades.destruir(name, "../Dades/Estadistiques/");
    }
    
    /**
     * Funcio encarregada de fer la crida per guardar un Tauler.
     * @param taul Tauler en questio
     * @param name Nom del tauler
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean guardaTauler(Object taul, String name) {
        return SDades.guardar(taul, name, "../Dades/Taulers/");
    }
    /**
     * Funcio encarregada de carregar de fer la crida per carregar un Tauler.
     * @param name Nom del tauler
     * @return Objecte amb les dades del tauler en cas de exit, objecte buit en cas contrari
     */
    public Object carregaTauler(String name) {
        Object obj;
        return obj = SDades.carregar(name, "../Dades/Taulers/");
    }
    
    /**
     * Funcio encarregada de fer la crida per destruir un Tauler
     * @param name Nom del tauler
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean destrueixTauler(String name) {
        return SDades.destruir(name, "../Dades/Taulers/");
    }
    
    /**
     * Funcio encarregada de fer la crida per comprovar si ja existeix un tauler amb nom name.
     * @param name Nom del tauler
     * @return True en cas de que el tauler ja existeixi, false en cas contrari
     */
    public boolean comprovaTauler(String name) {
        return SDades.existeixObjecte(name, "../Dades/Taulers/");
    }
    
    /**
     * Funcio encarregada de fer la crida a la BD per a aconseguir una llista amb els noms de tots els taulers del sistema.
     * @return Llista de Strings amb els noms de tots el taulers
     */
    public List<String> llistaTaulers() {
        return SDades.aconsegueixLlista("../Dades/Taulers/");
    }
    
    /**
     * Funcio encarregada de fer la crida per carregar el fitxer importable
     * @param name Nom del importable
     * @return String amb les dades del importable
     */
    /*public String carregaImportable(String name) {
        return SDades.carregarString("import");
    }*/
    
    /**
     * Funcio encarregada de fer la crida per guardar una Partida.
     * @param part Partida en questio
     * @param name Nom de la partida
     * @param user Nom del usuari que fa la operacio
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean guardaPartida(Object part, String name, String user) {
        return SPartides.guardarPartida(part, name, user);
    }
    
    /**
     * Funcio encarregada de fer la crida per carregar una Partida.
     * @param name Nom de la partida
     * @param user Nom del usuari que fa la operacio
     * @return Objecte amb les dades de la partida en cas de exit, objecte buit en cas contrari
     */
    public Object carregaPartida(String name, String user) {
        Object obj;
        return obj = SPartides.carregarPartida(name, user);
    }
    
    /**
     * Funcio encarregada de fer la crida per destruir una Partida.
     * @param name Nom de la partida
     * @param user Nom del usuari que fa la operacio
     * @return Cert en cas de exit, false en cas contrari
     */
    public boolean destrueixPartida(String name, String user) {
        return SPartides.destruirPartida(name, user);
    }
    
    /**
     * Funcio encarregada de fer la crida per destruir totes les partides de un Usuari.
     * @param user Nom del usuari
     */
    public void destrueixTotesPartides(String user) {
        SPartides.destruirTotesPartides(user);
    }
    
    /**
     * Funcio encarregada de fer la crida per aconseguir una llista amb els noms de totes les partides de usuari.
     * @param user Nom del usuari
     * @return Llista de Strings amb els noms de totes les partides del usuari
     */
    public List<String> llistaPartides(String user) {
        return SPartides.aconsegueixLlista(user);
    }
    
    /**
     * Funcio encarregada de fer la crida per comprovar si ja existeix una partida de user amb nom name.
     * @param name Nom de la partida
     * @param user Nom del usuari
     * @return True en cas de que la partida ja existeixi, false en cas contrari
     */
    public boolean comprovaPartida(String name, String user) {
        return SPartides.comprovaPartida(name, user);
    }
}
