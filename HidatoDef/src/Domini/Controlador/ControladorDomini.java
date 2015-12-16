/*
 * To change this license header, choose License Headers in Project Properties.
 * To change         wjoebdwjebcwecbw            this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini.Controlador;

import Domini.Clases.*;
import Persistencia.Controlador.ControladorPersistencia;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Carlo
 */
public class ControladorDomini {
           /*Controla totes les operacions de la taula: Soluciona tauler, genera etc..*/
            private final ControladorJuga cJuga;
            private final ControladorCrea cCrea;
            private final ControladorSoluciona cSol;
            private final ControladorGenera cGen;
            private final ControladorPersistencia cPers;
            
	    private Tauler tauler;/* Contindra el tauler sense solucionar */
            private Tauler tauler_partida;
	    private int[] numDonats, posInicial;/* dos vectors que utilitzara soluciona_aux sapiguer on começa i quins estan posats */
            
            private Usuari usuari;
            private Partida partida;
            private Hidatos hidatos;
	    
	    private Tauler tablero; /* tablero sobre el que buscaremos la solucion */
	    private Tauler solucion; /* tablero donde guardaremos la solucion */
	    private int nSols; /* numero de soluciones encontradas (como mucho dos) */
	    private int nRest; /* numero de casillas que me quedan por poner */
	    private boolean usado[]; /* usado[i] nos dice si el numero i + 1 esta colocado */
	    private int n; /* anchura del tablero */
	    private int m; /* altura del tablero */
	    private int maxCas; /* numero de la casilla mas grande */
            private final ControladorTaula controladorTaula;
            private int min; /* Minim de caselles posbiles a posar en el tauler */
            
            private List<Integer> conjuntUsats;
            private List<Integer> propers;
            
           /**
            * Contructora que inicialitza els taulers i tots els controladors de les funcions
            * que necesitara.
            */
            public ControladorDomini(){
                tauler = new Tauler();
                usuari = new Usuari();
                partida = new Partida();
                hidatos = new Hidatos();
                solucion = new Tauler();
                cJuga = new ControladorJuga();
                cCrea = new ControladorCrea();
                cSol = new ControladorSoluciona();
                cGen = new ControladorGenera();
                cPers = new ControladorPersistencia();
                controladorTaula = new ControladorTaula();
            }
            
            /**
             * Funcio que cridara al controlador TaulerCreat per a crear al tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void creaTauler(){
                cCrea.crea();
                tauler = cCrea.getTaulerCreat();
                if(cSol.soluciona(tauler)){
                    numDonats = cCrea.getNumDonats();
                    posInicial = cCrea.getPosInicial();
                    solucion = cSol.getSolucio().clonar();
                }
                else{
                    System.out.println("Tauler no valid!!!!");
                    tauler = null;
                }
            }
            
             /**
             * Funcio que cridara al controlador Controladorjuga per a jugar al tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void juga(){
                cJuga.juga(tauler,solucion);
                tauler_partida = cJuga.getTauler_partida();
            }
            
            /**
             * Funcio que cridara al controlador ControladorGenera per a generar un tauler.
             * @param costat
             * @param numInicials
             * @param forats
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void generaTauler(int costat, int numInicials, String topo){
                cGen.generaTauler(costat, numInicials ,topo);
                tauler = cGen.getTauler();
                solucion = cGen.getSolucion();
                nSols = cGen.getnSols();
                maxCas = cGen.getMaxCas();
                
            }
            
            public int[][] getTaulerPerVista() {
                return controladorTaula.transformar(tauler);
            }
            public int[][] getTaulerSolucionatPerVista() {
                soluciona();
                return controladorTaula.transformar(solucion);
            }
            
            /**
             * Funcio que cridara al controlador ControladorSoluciona per a solucionar el tauler. 
             * Despres fara els sets y getters per tenir aqui el tauler solucionat.
             */
            public void soluciona(){
                cSol.soluciona(tauler);
                solucion = cSol.getSolucio();     
            }
            
            /**
             * Registra un nou usuari a la base de dades.
             * @param user Nom de usuari
             * @param pass Password de el usuari
             * @param codi Codi de recuperacio
             * @return True si sha creat correctament el usuari
             */
            public boolean registrarUsuari(String user,String pass, String codi){
                if(cPers.comprovaUser(user)) {
                    return false;
                }
                else {
                    usuari = new Usuari(user,pass,codi);
                    return cPers.guardaUser((Object)usuari, user);
                }
            }
            
            /**
             * Funcio encarregada de comprovar si la relacio user-password existeix
             * @param user Nom del usuari
             * @param pass Contrassenya del usuari
             * @return Retorna true si el usuari existeix i te el password corresponent, false en cas contrari
             */
            public boolean logInUsuari(String user,String pass){
                usuari = (Usuari) cPers.carregaUser(user);
                if (usuari == null) return false;
                return usuari.getPassword().equals(pass);
                
            }
            
            /**
             * Funcio encarregada de recuperar el password de un usuari donat el seu codi de recuperacio.
             * @param user Nom del usuari
             * @param codi Codi de recuperacio
             * @return String que conte el password recuperat en cas de exit, string amb valor null en cas contrari
             */
            public String restauraPassword(String user, String codi) {
                usuari = (Usuari) cPers.carregaUser(user);
                if (usuari == null) return null;
                if (usuari.getCodi().equals(codi)) {
                    String resposta = usuari.getPassword();
                    return resposta;
                }
                return null;
            }
            
            public void novaPartida(){
                tauler_partida = tauler.clonar();
                conjuntUsats = new ArrayList<Integer>();
                propers = new ArrayList<Integer>();
                maxCas = controladorTaula.getMax(tauler);
                cJuga.iniciaUsados(tauler_partida, conjuntUsats);
                cJuga.ajudaPropers(tauler_partida, conjuntUsats, propers, maxCas);
                //actualizar lista posibles
            }
            
            public boolean setCela(int i, int j, int val){
                //mirar si posible ponerlo benColocat
                //if benColocat modificaCela y actualiza NUmeros a poner
                if(benColocat(i, j, val)){
                    int aux = tauler_partida.getCela(i, j);
                    if(aux > 0) conjuntUsats.remove(aux);
                    conjuntUsats.add(val);
                    tauler_partida.ModificaCela(i, j, val);
                    cJuga.ajudaPropers(tauler_partida, conjuntUsats, propers, maxCas);
                    return true;
                }
                else return false;
            }
            
            public boolean acabat(){
                return cJuga.acabat(tauler_partida);
                
            }
            
            public boolean bensolucionat(){
                return cJuga.bensolucionat(tauler_partida, solucion);
            }
            
            public boolean benColocat(int i, int j, int val){
                return cJuga.bencolocat(i, j, val, tauler_partida,conjuntUsats);
            }
            
            public boolean celaCorrecte(int i, int j){
                return cJuga.celaCorrecta(i, j, tauler_partida, solucion);
            }

            public List<Integer> getConjuntUsats() {
                return conjuntUsats;
            }

            public void setConjuntUsats(List<Integer> conjuntUsats) {
                this.conjuntUsats = conjuntUsats;
            }

            public List<Integer> getPropers() {
                return propers;
            }

            public void setPropers(List<Integer> propers) {
                this.propers = propers;
            }
            
            /**
             * Funcio encarregada de fer la crida per guardar una partida a mitges
             * @param name Nom de la partida a guardar
             * @param user Nom del usuari que guarda la partida
             * @return Cert en cas de exit, false en cas contrari
             */
            public boolean guardarPartida(String name, String user) {
                partida.setHidatos(hidatos);
                partida.setUser(usuari);
                Object obj = (Object) partida;
                
                if(cPers.comprovaPartida(name, user)) {
                    //Ja existeix una partida amb aquest nom. Sobreescriure?
                    return false;
                }
                else {
                    return cPers.guardaPartida(obj, name, user);
                }
            }
            
            
            /**
             * Funcio encarregada de fer la crida per a carregar una partida.
             * @param user Nom del usuari que vol carregar la partida
             * @param name Nom de la partida a carregar
             */
            public void carregarPartida(String name, String user) {
                partida = (Partida) cPers.carregaPartida(name, user);
                
                hidatos = partida.getHidatos();
                usuari = partida.getUser();
            }
            
            /**
             * Funcio que demana a la BD el llistat de partides a mitges que te el usuari 'user'.
             * @param user Nom del usuari
             * @return Llista de Strings que conte el nom de les partides a mitges
             */
            public List<String> llistatPartides(String user) {
                List<String> list = new ArrayList<String>();
                list = cPers.llistaPartides(user);
                return list;
            }
            
            /**
             * Funcio encarregada de enviar un tauler a la BD per a que es guardi.
             * @param name Nom amb que es guardara el tauler
             * @return Cert en cas de exit, false en cas contrari
             */
            public boolean guardarTauler(String name) {
                hidatos.setTaulerJocInic(tauler);
                hidatos.setTaulerJocModi(tauler_partida);
                hidatos.setTaulerJocSolu(solucion);
                Object obj = (Object) hidatos;
                
                if(cPers.comprovaTauler(name)) {
                    return false;
                }
                else {
                    return cPers.guardaTauler(obj, name);
                }
            }
            
            /**
             * Funcio encarregada de fer la crida per carregar de la BD un tauler demanat.
             * @param name Nom del tauler a carregar
             */
            public void carregarTauler(String name) {
                hidatos = (Hidatos) cPers.carregaTauler(name);
                
                tauler = hidatos.getTaulerJocInic();
                tauler_partida = hidatos.getTaulerJocModi();
                solucion = hidatos.getTaulerJocSolu();
            }
            
            /**
             * Funcio que demana a la BD el llistat de tots els taulers que te el sistema.
             * @return Llista de Stings que conte el nom dels taulers del sistema
             */
            public List<String> llistatTaulers() {
                List<String> list = new ArrayList<String>();
                list = cPers.llistaTaulers();
                return list;
            }
            
            /**
              * getSolucio, Retorna el tauler solucionat solucion
              * @return Retorna el tauler solucionat
              * PRE: --
              */
	    public Tauler getSolucio(){
			return solucion;
	    }
            
             /**
              * getSolucio, Retorna el tauler per omplir
              * @return Retorna el tauler
              * PRE: --
              */
	    public Tauler getTauler(){
			return tauler;
	    }
            
             /**
              * Set de tauler
              * @param t  l'hi passa un tauler t
              * PRE: --
              */
            public void setTauler(Tauler t){
                tauler = t.clonar(); 
            }
            
            public Tauler getTablero(){
		return tablero;
	    }
            
            public void setTablero(Tauler t){
                tablero = t; //cambiar esto tardara mucho si copio todo el rato
            }
            
            public Tauler getPartida(){
                return tauler_partida;
            }
            
            public void setPartida(Tauler t){
                tauler_partida = t.clonar(); 
            }
            
            public int[] getNumDonats(){
                return numDonats;
            }
            
	    public int[] getPosInicial(){
                return posInicial;
            }
            
            public void setNumDonats(int []numDonats){
                this.numDonats = numDonats;
            }
            
	    public void setPosInicial(int []posInicial){
                this.posInicial = posInicial;
            }
            
            
            public int getMaxCas() {
                return maxCas;
            }

            public void setMaxCas(int maxCas) {
                this.maxCas = maxCas;
            }
            
            public String getNomUsuari() {
                return usuari.getNom();
            }
}