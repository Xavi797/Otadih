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
            
            private long startTime;//variables de temps per fer els corresponents timeouts
            private final long timeout = 8000;                                   
            private long elapsed;
            
	    private Tauler tauler;/* Contindra el tauler sense solucionar */
            private Tauler tauler_partida;
	    private int[] numDonats, posInicial;/* dos vectors que utilitzara soluciona_aux sapiguer on começa i quins estan posats */
            
            private Usuari usuari;
            private Partida partida;
            private Hidatos hidatos;
            private Rankings rankings;
            private Estadistiques estadistiques;
	    
	    private Tauler solucion; /* tablero donde guardaremos la solucion */
	    private int maxCas; /* numero de la casilla mas grande */
            private final ControladorTaula controladorTaula;
            
            private List<Integer> conjuntUsats;
            private List<Integer> propers;
            
           /**
            * Contructora que inicialitza els taulers i tots els controladors de les funcions
            * que necesitara.
            */
            public ControladorDomini(){
                tauler = new Tauler();
                tauler_partida = new Tauler();
                usuari = new Usuari();
                partida = new Partida();
                hidatos = new Hidatos();
                rankings = new Rankings();
                estadistiques = new Estadistiques();
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
             * @param costat tamany d'un costat del tauler
             * @param numInicials Numeros inicials que l'usuari vol
             * @param topo Indica topologia de forats del tauler.
             * Despres fara els sets y getters per tenir aqui el tauler.
             */
            public void generaTauler(int costat, int numInicials, String topo){
                cGen.generaTauler(costat, numInicials ,topo);
                tauler = cGen.getTauler();
                tauler_partida = tauler.clonar();
                solucion = cGen.getSolucion();
                maxCas = cGen.getMaxCas();
                
            }
            
            /**
             * Retorna el tauler_partida transformat a matriu de ints per a la 
             * utilitzacio de les vistes
             * @return Retorna solucio en matriu de ints
             */
            public int[][] getTaulerPartidaPerVista(){
                return controladorTaula.transformar(tauler_partida);
            }
            
            /**
             * Retorna el tauler inicial transformat a matriu de ints per a la 
             * utilitzacio de les vistes.
             * @return Retorna el tauler en matriu de ints
             */
            public int[][] getTaulerPerVista() {
                return controladorTaula.transformar(tauler);
            }
            
            /**
             * Retorna el tauler solucionat transformat a matriu de ints per a la 
             * utilitzacio de les vistes.
             * @return Retorna el tauler solucionat en matriu de ints
             */
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
             * Crea una nova partida per poder jugar al tauler previament creat
             * o carregat. Tambe s'utilitza per retomar una partida.
             */
            public void novaPartida() {
               // tauler_partida = tauler.clonar();
                startTime = System.currentTimeMillis();
                elapsed = partida.getTemps();
                conjuntUsats = new ArrayList<Integer>();
                propers = new ArrayList<Integer>();
                maxCas = controladorTaula.getMax(tauler);
                cJuga.iniciaUsados(tauler_partida, conjuntUsats);
                cJuga.ajudaPropers(tauler_partida, conjuntUsats, propers, maxCas);
                //actualizar lista posibles
            }
            /**
            * Comproba que la cela que es vol posar, comprobant que es 
            * compleixin les regles del joc
            * @param i posicio de la fila a comprobar i posar
            * @param j posicio de la columna a comprobar i posar
            * @param val Valor de la nova cela que es vol posar
            * @return Cert en cas de que s'insereixi correctament la cela
            */
            public boolean setCela(int i, int j, int val){
                int aux = tauler_partida.getCela(i, j);
                if(val == aux) return true;
                if(val > maxCas || val < 0 || conjuntUsats.contains(val) || !propers.contains(val)) return false;
                if(val == 0){
                    if(aux != 0){
                        tauler_partida.ModificaCela(i, j, val);
                        for(int auxUsats = 0; auxUsats < conjuntUsats.size(); ++auxUsats)
                        if(conjuntUsats.get(auxUsats) == aux) conjuntUsats.remove(auxUsats);
                    }
                    cJuga.ajudaPropers(tauler_partida, conjuntUsats, propers, maxCas);
                    return true;
                }
                if(benColocat(i, j, val)){
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
            
            /**
             * Comproba que el tauler estigui tot ple de numeros.
             * @return Retorna cert si el tauler es ple.
             */
            public boolean acabat(){
                return cJuga.acabat(tauler_partida);
                
            }
            
            /**
             * Comproba que el tauler esta ben solucionat, comparant amb la 
             * solucio.
             * @return Retorna cert si el tauler de la partida es igual al de 
             * la solucio
             */
            public boolean bensolucionat(){
                return cJuga.bensolucionat(tauler_partida, solucion);
            }
            
            /**
             * Comproba que la nova cela posada compleix les regles del joc
             * @param i posicio de la fila a comprobar
             * @param j posicio de la columna a comprobar
             * @param val Valor de la nova cela que es vol posar
             * @return Retorna cert si la compleix les regles del joc
             */
            public boolean benColocat(int i, int j, int val){
                return cJuga.bencolocat(i, j, val, tauler_partida,conjuntUsats);
            }
            
            /**
             * Comproba si una cela es la correcte, respecte a la solucio final
             * @param i posicio de la fila a comprobar
             * @param j posicio de la columna a comprobar
             * @return Cert en cas de que la mateixa posicio
             * en el tauler soluciona tingui el mateix valor
             */
            public boolean celaCorrecte(int i, int j){
                return cJuga.celaCorrecta(i, j, tauler_partida, solucion);
            }
            
            /**
             * Funcio encarregada de Validar un tauler, utilitzant el algoritme
             * de buscasolucions
             * @param mat Matriu de ints de la vista a validar
             * @return Cert en cas de que tauler sigui valid, false altrament.
             */
            public boolean validaTablero(int [][] mat){
                Tauler t =controladorTaula.transformarInversa(mat);
                cGen.ValidaBusca(t);
                if(cGen.getnSols() == 1){
                    tauler = t.clonar();
                    tauler_partida = t.clonar();
                    solucion = cGen.getSolucion();
                    return true;
                }
                else return false;
            }
            /**
             * Fa un check de tauler que retorna true si totes estan ben colocades
             * fins al moment. La llista conte els numeros mal colocats
             * @param llista
             * @return 
             */
            public boolean checkTauler(List<Integer> llista){
                return cJuga.check(llista, tauler_partida, solucion);
            }
            
            /** Afegeix a llista tots els numeros posibles a colocar per la casella (i,j)
             * 
             * @param i posicio casella files
             * @param j posicio casella columna
             * @param llista llista que contindra els posibles numeros a ficar
             */
            public void numsPosibles(int i, int j,List<Integer> llista){
                for(int aux = 0; aux < propers.size(); ++ aux)
                if(cJuga.bencolocat(i, j,propers.get(aux) , tauler, conjuntUsats))
                    llista.add(propers.get(aux));
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
            
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            ////////////////////////////////////////////////////////////////////
            
            /**** USUARI ****/
            
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
                    estadistiques = new Estadistiques(0, 0, 0, 0);
                    cPers.guardaEstadistica((Object)estadistiques, user);   //Inicialitzem unes estadistiques per al usuari
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
            
            /**
             * Funcio encarregada de esborrar un usuari i totes les seves dades del sistema.
             */
            public void esborraUsuari() {
                cPers.destrueixTotesPartides(usuari.getNom());
                cPers.destrueixEstadistica(usuari.getNom());
                cPers.destrueixUser(usuari.getNom());
            }
            
            /**** RANKING ****/
            
            /**
             * Quan la partida finalitza actualitza el ranking amb nom user
             * + temps nou;
             */
            public void actualitzaRanking() {
                //Envia a ranking l'usuari, dificultat?, temps
                //CALCUL DE LA PUNTUACIO <>
                long temps_total = (System.currentTimeMillis() - startTime) + elapsed;
                //CALCUL DE LA PUNTUACIO </>
                
                //rankings.afegeix(usuari.getNom(), punts); 
                
                cPers.guardaRanking((Object)rankings, usuari.getNom());
            }
            
            /**
             * Funcio encarregada de enviar a la BD un ranking per a guardarlo.
             * @param name Nom del ranking
             */
            public void guardaRanking(String name) {
                Object obj = (Object) rankings; 
                cPers.guardaRanking(obj, name);
            }
            
            /**
             * Funcio encarregada de demanar a la BD de carregar un el ranking anomenat name.
             * @param name Nom del ranking
             */
            public void carregarRanking(String name) {
                rankings = (Rankings) cPers.carregaRanking(name);
            }
            
            /**** ESTADISTIQUES ****/
            
            /**
             * Quan la partida inicia actualitza els camps necessaris de les estadistiques.
             */
            public void actualitzaEstadistiquesInici() {
                estadistiques.afegeixPartida();
                cPers.guardaEstadistica((Object)estadistiques, usuari.getNom());
            }
            
            
            /**
             * Quan la partida acaba actualitza els camps necessaris de les estadistiques.
             * @param guanyada Indica si la partida ha acabat amb victoria o no
             * @param punts Indica la quantitat de punts que ha aconseguit el usuari
             */
            public void actualitzaEstadistiquesFinal(boolean guanyada, int punts) {
                estadistiques.afegeixPartidaGuanyada(guanyada);
                estadistiques.afegeixPuntuacio(punts);
                cPers.guardaEstadistica((Object)estadistiques, usuari.getNom());
            }
            
            /**
             * Funcio encarregada de enviar a la BD un estadistiques per guardar-la.
             */
            public void guardaEstadistiques() {
                Object obj = (Object) estadistiques;
                cPers.guardaEstadistica(obj, usuari.getNom());
            }
            
            /**
             * Funcio encarregada de demanar a la BD de carregar les estadistiques del usuari.
             */
            public void carregaEstadistiques() {
                estadistiques = (Estadistiques) cPers.carregaEstadistica(usuari.getNom());
            }
            
            /**** PARTIDES ****/
            
            /**
             * Funcio encarregada de fer la crida per guardar una partida a mitges.
             * @param name Nom de la partida a guardar
             * @param sobreescriure Indica si la partida es pot sobreescriure (cert) o no
             * @return Cert si la partida es guarda correctament.
             */
            public boolean guardarPartida(String name, boolean sobreescriure) {
                hidatos.setTaulerJocInic(tauler);
                hidatos.setTaulerJocModi(tauler_partida);
                hidatos.setTaulerJocSolu(solucion);
                partida.setHidatos(hidatos);
                partida.setTemps((System.currentTimeMillis() - startTime) + elapsed);
                partida.setUser(usuari);
                
                Object obj = (Object) partida;
                
                if(cPers.comprovaPartida(name, usuari.getNom()) && !sobreescriure) {
                    //Ja existeix una partida amb aquest nom. Sobreescriure?
                    return false;
                }
                else {
                    return cPers.guardaPartida(obj, name, usuari.getNom());
                }
            }
            
            /**
             * Funcio encarregada de fer la crida per a carregar una partida.
             * @param name Nom de la partida a carregar
             */
            public void carregarPartida(String name) {
                partida = (Partida) cPers.carregaPartida(name, usuari.getNom());
                
                hidatos = partida.getHidatos();
                usuari = partida.getUser();
                
                tauler = hidatos.getTaulerJocInic();
                tauler_partida = hidatos.getTaulerJocModi();
                solucion = hidatos.getTaulerJocSolu();
            }
            
            /**
             * Funcio que demana a la BD el llistat de partides a mitges que te el usuari 'user'.
             * @return Llista de Strings que conte el nom de les partides a mitges
             */
            public List<String> llistatPartides() {
                List<String> list = new ArrayList<String>();
                list = cPers.llistaPartides(usuari.getNom());
                return list;
            }
            
            /**
             * Funcio encarregada de fer la crida a la BD per a que destrueixi una partida.
             * @param name Nom de la partida ha destruir
             * @return Cert en cas de exit, false en cas contrari
             */
            public boolean esborraPartida(String name) {
                return cPers.destrueixPartida(name, usuari.getNom());
            }
            
            /**** TAULER ****/
            
            /**
             * Funcio encarregada de enviar un tauler a la BD per a que es guardi.
             * @param name Nom amb que es guardara el tauler
             * @return Cert en cas de exit, false en cas contrari
             */
            public boolean guardarTauler(String name) {
                hidatos.setTaulerJocInic(tauler.clonar());
                hidatos.setTaulerJocModi(tauler.clonar());
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
                
                tauler = hidatos.getTaulerJocInic().clonar();
                tauler_partida = hidatos.getTaulerJocModi().clonar();
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
}
