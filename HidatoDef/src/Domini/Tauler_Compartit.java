/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domini;

/* Classe Taulell per compartir
 * Cluster: 41
 * Equip: Sudoku
 */
public class Tauler_Compartit {
         private int sizeI;
        private int sizeJ;
        private Cela_Compartida  tauler_Compartit[][];
 
        /** Construeix un Tauler_Compartit de mida 0
         *
         */
        public Tauler_Compartit() {
                sizeI = 0;
                sizeJ = 0;
        }
       
        /** Construeix un Tauler_Compartit buit de mida size
         *
         * @param size el tamany del tauler_Compartit que es vol contruir
         * @throws NegativeArraySizeException retorna @see NegativeArraySizeException si size es menor
         * que 0.
         */
        public Tauler_Compartit(int size) throws NegativeArraySizeException {
                if (size >= 0) {
                        this.sizeI = size;
                        this.sizeJ = size;
                        tauler_Compartit = new Cela_Compartida [this.sizeI][this.sizeJ];
                        initializeTauler_Compartit();
                } else
                        throw new NegativeArraySizeException();
        }
 
        /** Construeix un Tauler_Compartit buit de mida sizeI x sizeJ
         *
         * @param sizeI el tamany del tauler_Compartit que es vol contruir
         * @throws NegativeArraySizeException retorna @see NegativeArraySizeException si size es menor
         * que 0.
         */
        public Tauler_Compartit(int sizeI, int sizeJ) throws NegativeArraySizeException {
                if (sizeI >= 0 && sizeJ >= 0) {
                        this.sizeI = sizeI;
                        this.sizeJ = sizeJ;
                        tauler_Compartit = new Cela_Compartida [this.sizeI][this.sizeJ];
                        initializeTauler_Compartit();
                } else
                        throw new NegativeArraySizeException();
        }
 
        /** Retorna un tauler_Compartit a partir del array d'enters. La copia es realitza
         * per columnes.
         *
         * @param tauler_Compartit El tauler_Compartit que es passa.
         */
        public Tauler_Compartit(int tauler_Compartit[][]) {
                sizeI = tauler_Compartit.length;
                if(sizeI > 0) sizeJ = tauler_Compartit[0].length;
                this.tauler_Compartit = new Cela_Compartida [sizeI][sizeJ];
               
                for (int i = 0; i < sizeI; ++i) {
                        for (int j = 0; j < sizeJ; ++j){
                                try {
                                        this.tauler_Compartit[i][j] = new Cela_Compartida();
                                        this.tauler_Compartit[i][j].setValor(tauler_Compartit[i][j]);
                                } catch (Exception e) {
                                        System.out.println("Tauler_Compartit no valid");
                                        e.printStackTrace();
                                }
                        }
                }
        }
       
        /** Constructor de copia
         *
         * @param tauler_Compartit El tauler_Compartit que es vol copiar
         */
        public Tauler_Compartit(Tauler_Compartit tauler_Compartit){
            this.sizeI = tauler_Compartit.getSizeI();
            this.sizeJ = tauler_Compartit.getSizeJ();
                this.tauler_Compartit = new Cela_Compartida [this.sizeI][this.sizeJ];
            for(int i = 0; i < this.sizeI; ++i){
                    for(int j = 0; j < this.sizeJ; ++j){
                        this.tauler_Compartit[i][j] = new Cela_Compartida();
                                this.tauler_Compartit[i][j].setValor(tauler_Compartit.getCela_CompartidaValue(i, j));
                    }
            }  
        }
       
        /** Retorna la mida del tauler_Compartit
         *
         * @return un enter amb la mida de files del tauler_Compartit
         */
        public int getSizeI() {
                return sizeI;
        }
 
        /** Retorna la mida del tauler_Compartit
         *
         * @return un enter amb la mida de columnes del tauler_Compartit
         */
        public int getSizeJ() {
                return sizeJ;
        }
       
        /** Retorna l'enter de la posició
         *
         * @param x Posicio files en el tauler
         * @param y Posicio columnes en el tauler
         * @return enter en la posicio
         * @throws ArrayIndexOutOfBoundsException
         */
        public int getCela_CompartidaValue(int x, int y) throws ArrayIndexOutOfBoundsException {
                if (isInTauler_Compartit(x, y)) {
                        return tauler_Compartit[x][y].getValor ();
                } else
                        throw new ArrayIndexOutOfBoundsException();
        }
       
        /** Retorna la cela de la posició
         *
         * @param x posicio files en el tauler
         * @param y posicio columnes en el tauler
         * @return la cela en x y
         * @throws ArrayIndexOutOfBoundsException
         */
        public Cela_Compartida  getCela_Compartida (int x, int y) throws ArrayIndexOutOfBoundsException {
                if (isInTauler_Compartit(x, y)) {
                        return tauler_Compartit[x][y];
                } else
                        throw new ArrayIndexOutOfBoundsException();
        }
       
        /** modifica l'enter de la posició
         *
         * @param x posicio files en el tauler
         * @param y posicio columnes en el tauler
         * @param value
         * @throws ArrayIndexOutOfBoundsException
         */
        public void setCela_CompartidaValue(int x, int y, int value) throws Exception {
                if (isInTauler_Compartit(x, y)) {
                        tauler_Compartit[x][y].setValor (value);
                } else
                        throw new ArrayIndexOutOfBoundsException();
        }
       
        /** modifica l'enter de la posició i possa 0
         *
         * @param x posicio files en el tauler
         * @param y posicio columnes en el tauler
         * @throws ArrayIndexOutOfBoundsException
         */
        public void deleteCela_CompartidaValue(int x, int y) throws Exception {
                if (isInTauler_Compartit(x, y)) {
                        tauler_Compartit[x][y].setValor (0);
                } else
                        throw new ArrayIndexOutOfBoundsException();
               
        }
 
        /** retorna si la posicio es al tauler
         *
         * @param x
         * @param y
         * @throws ArrayIndexOutOfBoundsException
         */
        private boolean isInTauler_Compartit(int x, int y) {
                return x >= 0 && x < sizeI && y >= 0 && y < sizeJ;
        }
       
        /** possa les caselles del tauler a 0
         * @throws ArrayIndexOutOfBoundsException
         */
        private void initializeTauler_Compartit() {
                for (int i = 0; i < sizeI; ++i) {
                        for (int j = 0; j < sizeJ; ++j)
                                try {
                                        tauler_Compartit[i][j] = new Cela_Compartida();
                                        tauler_Compartit[i][j].setValor(0);
                                } catch (Exception e) {
                                        e.printStackTrace();
                                }
                }
        }
 
}

