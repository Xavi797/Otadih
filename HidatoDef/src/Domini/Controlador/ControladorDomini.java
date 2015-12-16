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
                    Usuari userF = new Usuari(user,pass,codi);
                    return cPers.guardaUser((Object)userF, user);
                }
            }
            
            /**
             * Funcio encarregada de comprovar si la relacio user-password existeix
             * @param user Nom del usuari
             * @param pass Contrassenya del usuari
             * @return Retorna true si el usuari existeix i te el password corresponent, false en cas contrari
             */
            public boolean logInUsuari(String user,String pass){
                Usuari userF = (Usuari) cPers.carregaUser(user);
                if (userF == null) return false;
                return userF.getPassword().equals(pass);
                
            }
            
            /**
             * Funcio encarregada de recuperar el password de un usuari donat el seu codi de recuperacio.
             * @param user Nom del usuari
             * @param codi Codi de recuperacio
             * @return String que conte el password recuperat en cas de exit, string amb valor null en cas contrari
             */
            public String restauraPassword(String user, String codi) {
                Usuari userF = (Usuari) cPers.carregaUser(user);
                if (userF == null) return null;
                if (userF.getCodi().equals(codi)) {
                    String resposta = userF.getPassword();
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
                int aux = tauler_partida.getCela(i, j);
                for(int auxint = 0; auxint < propers.size(); ++auxint) System.out.printf(" " + propers.get(auxint));
                System.out.println(""); 
                for(int auxint = 0; auxint < conjuntUsats.size(); ++auxint) System.out.printf(" " + conjuntUsats.get(auxint));
                System.out.println(""); 
                System.out.println(""); 
                 System.out.println("rly man?");
                if(val == aux) return true;
                System.out.println("aqui?");
                if(val > maxCas || val < 0 || conjuntUsats.contains(val) || !propers.contains(val)) return false;
                System.out.println("burraca?");
                if(val == 0){
                    if(aux != 0){
                        tauler_partida.ModificaCela(i, j, val);
                        for(int auxUsats = 0; auxUsats < conjuntUsats.size(); ++auxUsats)
                        if(conjuntUsats.get(auxUsats) == aux) conjuntUsats.remove(auxUsats);
                    }
                    cJuga.ajudaPropers(tauler_partida, conjuntUsats, propers, maxCas);
                    return true;
                }
                System.out.println("pruebaaaaaa");
                if(benColocat(i, j, val)){
                    System.out.println("yaaaaaaaaas");
                    if(aux > 0){
                        for(int auxUsats = 0; auxUsats < conjuntUsats.size(); ++auxUsats)
                        if(conjuntUsats.get(auxUsats) == aux) conjuntUsats.remove(auxUsats);
                    }
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
             * Funcio encarregada de guardar una partida a mitges
             * @param user
             * @param name
             * @return 
             */
           /* public boolean guardarPartida(String name) {
                Partida p = new Partida();
                Hidatos h = new Hidatos(tauler, tauler_partida, solucion);
                
                
                
                return cPers.guardaPartida(obj, name, user);
            }*/
            
            
            /**
             * Funcio encarregada de fer la crida per a carregar una partida.
             * @param user Nom del usuari que vol carregar la partida
             * @param name Nom de la partida a carregar
             * @return Partida demanada
             */
            public Partida carregarPartida(String name, String user) {
                Partida p = new Partida();
                return p = (Partida) cPers.carregaPartida(name, user);
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
                Hidatos h = new Hidatos();
                h.setTaulerJocInic(tauler);
                h.setTaulerJocModi(tauler_partida);
                h.setTaulerJocSolu(solucion);
                Object obj = (Object) h;
                return cPers.guardaTauler(obj, name);
            }
            
            /**
             * Funcio encarregada de fer la crida per carregar de la BD un tauler demanat.
             * @param name Nom del tauler a carregar
             */
            public void carregarTauler(String name) {
                Hidatos h = new Hidatos();
                h = (Hidatos) cPers.carregaTauler(name);
                
                tauler = h.getTaulerJocInic();
                tauler_partida = h.getTaulerJocModi();
                solucion = h.getTaulerJocSolu();
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
}