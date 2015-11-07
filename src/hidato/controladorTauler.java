package hidato;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.Math;
import java.util.Random;
import java.util.Scanner;



public class controladorTauler {

    private static int[][] tauler;
    private static int[] numDonats, posInicial;

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        int ordre = -1;

        while (ordre != 10) {
            System.out.println("Dona'm ordres:0 =>Predefinit 1 => Genera, 2 => Soluciona, 6 => Crea, 10 => Surt");
            ordre = in.nextInt();

            switch (ordre) {
                case 0: 
                
                case 1:
                    System.out.println("Indica la dimensió del tauler");
                    int costat = in.nextInt();

                    System.out.println("Indica la cuantitat de numero incials de l'hidato, minim 2");
                    int numInicials = in.nextInt();

                    generaTauler(costat, numInicials);
                    escriuTauler(tauler);
                    break;

                case 2:
                    System.out.println("Solucio");
                    soluciona(posInicial[0], posInicial[1], 1, 0);
                    escriuTauler(tauler);
                    break;

                case 6:
		    System.out.println("Creacio d'Hidato: indica la dimensió del tauler")
		    int costat = in.nextInt();
		    crea(costat);
		    escriuTauler(tauler);
		    
                case 10:
                    break;
            }
        }
    }
    
    public static void crea(int costat) {
	int[][] taulerCreat = new int[costat][costat];
	int variable = 0;
	int seguir = 0;
	int escriure = 0;
	
	System.out.println("Primera vegada omplint, acces sequencial");
	System.out.println("Escriu el valor de cada posicio");
	for (int posx = 0; posx < costat; ++posx) {
	    for (int posy = 0; posy < costat; ++posy) {
		taulerCreat[posx][posy] = in.nextInt();
	    }
	}
	
	System.out.println("Estat actual:");
	escriuTauler(taulerCreat);
	
	System.out.println("Canviar alguna cela? 1:SI / 0:NO");
	seguir = in.NextInt();
	while (seguir == 1) {
	
	    System.out.println("Entrar coordenades de la posicio desitjada:");
	    int x = in.NextInt();
	    int y = in.NextInt();
	    System.out.println("La posicio es: " + x + "," + y);
	    
	    System.out.println("Entrar valor desitjat:");
	    taulerCreat[x][y] = in.nextInt();
	    
	    System.out.println("Esriure? 1:SI / 0:NO");
	    if (escriure == 1 ) {
		escriuTauler(taulerCreat);
		escriure = 0;
	    }
	    
	    System.out.println("Seguir? 1:SI / 0:NO");
	    seguir = in.NextInt();
	}
	
	tauler = taulerCreat;
	System.out.println("Resultat final:");
	escriuTauler(tauler);
    }


    public static boolean soluciona(int fila, int col, int n, int seguent) {
        System.out.println("valor n " + n);
        int dimensioTauler = tauler.length;
        if (fila<0 || col<0 || fila>dimensioTauler-1 || col>dimensioTauler-1)//si es fora del tauler surt
            return false;

        if (n > numDonats[numDonats.length - 1]) // si es mas grande que el utlimo sale
            return true;


        if (tauler[fila][col] != 0 && tauler[fila][col] != n)//si ya esta agafada la posicio i no es el nou numero surt
            return false;

        if (tauler[fila][col] == 0 && numDonats[seguent] == n)//si no hi ha cap numero pero ya esta ficat a la taula
            return false;

        int numRetorn = tauler[fila][col];
        if (numRetorn == n) //si el del tauler es igual al que poso incremento numdonats
            seguent++;

        tauler[fila][col] = n;
        int[] direccioVertical = new int[]{-1,-1,-1,0,0,1,1,1};
        int[] direccioHoritzontal = new int[]{-1,0,1,-1,1,-1,0,1};
        for (int i = 0; i < direccioVertical.length; ++i)
            if (soluciona(fila + direccioHoritzontal[i], col + direccioVertical[i], n + 1, seguent))
                return true;

        tauler[fila][col] = numRetorn;
        return false;
    }
    

    public static void escriuTauler(int[][] tauler) {     // S'ha de refer escriure per quan tinguem les classes cel·la i tauler
        for (int[] row : tauler) {
            for (int c : row) {
                if (c == -1)
                    System.out.print(" . ");
                else
                    System.out.printf(c > 0 ? "%2d " : "__ ", c);
            }
            System.out.println();
        }
    }

    public static void generaTauler(int costat, int numInicials) { // S'haura d'optimitzar, a més s'ha d'afegir el nivell dificultat

        int numMaxim = costat*costat;
        int[][] taulerGenerat = new int[costat][costat];
        Random rand = new Random();
        List<Integer> conjuntGenerat = new ArrayList<>(numInicials);
        conjuntGenerat.add(1);
        conjuntGenerat.add(numMaxim);

        int posx = rand.nextInt(costat);
        int posy = rand.nextInt(costat);
        taulerGenerat[posx][posy] = 1;
        posInicial = new int[]{posx, posy};

        posx = rand.nextInt(costat);
        posy = rand.nextInt(costat);


        while (taulerGenerat[posx][posy] != 0) {
                posx = rand.nextInt(costat);
                posy = rand.nextInt(costat);
            }
        taulerGenerat[posx][posy] = numMaxim;


        for (int i=0; i<numInicials-2; ++i) {
            int numRandom = rand.nextInt(numMaxim -1) + 1;
            while (conjuntGenerat.contains(numRandom)) {
                numRandom = rand.nextInt(numMaxim -1) + 1;
            }
            posx = rand.nextInt(costat);
            posy = rand.nextInt(costat);
            while (taulerGenerat[posx][posy] != 0) {
                posx = rand.nextInt(costat);
                posy = rand.nextInt(costat);
            }
            taulerGenerat[posx][posy] = numRandom;
            conjuntGenerat.add(numRandom);
        }

        Collections.sort(conjuntGenerat);
        numDonats = new int[conjuntGenerat.size()];
        for (int i = 0; i < numDonats.length; i++)
            numDonats[i] = conjuntGenerat.get(i);
        tauler = taulerGenerat;
    }

}