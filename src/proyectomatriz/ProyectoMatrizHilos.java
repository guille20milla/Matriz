/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectomatriz;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo Veintemilla
 * Clase que extiende de Thread
 */
public class ProyectoMatrizHilos extends Thread {

    private int[][] matriz;
    private int[][] matriz1;
    private int[][] mult;
    private int desde;
    private int hasta;

    /**
     * Constructor de la clase
     * @param m matriz aleatoria
     * @param m1 matriz aleatoria
     * @param mut resultado de la multiplicacion
     * @param desde fila desde la que calculamos
     * @param hasta fila hasta la que calculamos
     */
    public ProyectoMatrizHilos(int[][] m, int[][] m1, int[][] mut, int desde, int hasta) {
        this.matriz = m;
        this.matriz1 = m1;
        this.mult = mut;
        this.desde = desde;
        this.hasta = hasta;
    }

    /**
     * Metodo run donde implementamos la multiplicacion
     */
    public void run() {
        for (int d = desde; d <= hasta; d++) {
            for (int columna = 0; columna < mult.length; columna++) {
                for (int z = 0; z < mult.length; z++) {
                    mult[d][columna] += matriz[d][z] * matriz1[z][columna];
                }
            }
        }

    }

    /**
     * Clase main
     * @param args 
     */
    public static void main(String[] args) {
        InterfazMatrizHilos i = new InterfazMatrizHilos();
    }

}
