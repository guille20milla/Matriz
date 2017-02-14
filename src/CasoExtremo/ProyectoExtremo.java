/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CasoExtremo;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Guillermo Veintemilla
 * Clase ProyectoExtremo que extiende de Thread
 */
public class ProyectoExtremo extends Thread {

    private int[][] matriz;
    private int[][] matriz1;
    private int[][] mult;

    /**
     * Constructor de la clase
     * @param m matriz aleatoria
     * @param m1 matriz aleatoria
     * @param mut resultadi de la multiplicacion
     */
    public ProyectoExtremo(int[][] m, int[][] m1, int[][] mut) {
        this.matriz = m;
        this.matriz1 = m1;
        this.mult = mut;
    }

    /**
     * Metodo run que ejecuta el Thread donde se llama a otro Thread
     */
    public void run() {
        for (int fila = 0; fila < getMult().length; fila++) {
            ProyectoExtremo1 p = new ProyectoExtremo1(matriz, matriz1, mult, fila);
            Thread hilo = new Thread(p);
            hilo.start();
            mult = p.getMult1();
        }

    }

    /**
     * @return the mult
     */
    public int[][] getMult() {
        return mult;
    }

    /**
     * Clase ProyectoExtremo1 que extiende de Thread
     */
    public class ProyectoExtremo1 extends Thread {

        private int[][] matriz;
        private int[][] matriz1;
        private int[][] mult;
        int fila;

        /**
         * Constructor de la clase
         * @param m matriz aleatoria
         * @param m1 matriz aleatoria
         * @param mut resultado de la multiplicacion
         * @param f fila que vamos a multiplicar
         */
        public ProyectoExtremo1(int[][] m, int[][] m1, int[][] mut, int f) {
            this.matriz = m;
            this.matriz1 = m1;
            this.mult = mut;
            this.fila = f;
        }

        /**
         * Metodo run que ejecuta el Thread donde se llama a otro Thread
         */
        public void run() {
            for (int columna = 0; columna < getMult().length; columna++) {
                ProyectoExtremo2 p = new ProyectoExtremo2(matriz, matriz1, mult, fila,columna);
                Thread hilo = new Thread(p);
                hilo.start();
                mult = p.getMult2();
            }
        }

        /**
         * 
         * @return resultado de la multiplicacion
         */
        public int[][] getMult1() {
            return mult;
        }
    }

    /**
     * Clase ProyectoExtremo2 que extiende de Thread
     */
    public class ProyectoExtremo2 extends Thread {

        private int[][] matriz;
        private int[][] matriz1;
        private int[][] mult;
        int fila;
        int columna;

        /**
         * Constructor de la clase
         * @param m matriz aleatoria
         * @param m1 matriz aleatoria
         * @param mut resultado de la multiplicacion
         * @param f fila en la que multiplicamos
         * @param c columna en la que multiplicamos
         */
        public ProyectoExtremo2(int[][] m, int[][] m1, int[][] mut, int f, int c) {
            this.matriz = m;
            this.matriz1 = m1;
            this.mult = mut;
            this.fila = f;
            this.columna = c;
        }

        /**
         * Metodo run que ejecuta el Thread donde se implementa la multiplicacion
         */
        public void run() {
            for (int z = 0; z < getMult().length; z++) {
                mult[fila][columna] += matriz[fila][z] * matriz1[z][columna];
            }
        }

        /**
         * 
         * @return resultado de la multiplicacion
         */
        public int[][] getMult2() {
            return mult;
        }
    }

    /**
     * Clase main del programa
     * @param args 
     */
    public static void main(String[] args) {
        InterfazExtrema i = new InterfazExtrema();
    }

}
