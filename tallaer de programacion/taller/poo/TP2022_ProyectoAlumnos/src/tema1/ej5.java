/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

/**
 *
 * @author Facu
 */

import PaqueteLectura.Lector;

public class ej5 {
    public static void main(String[] args) {
        int [][] tabla = new int[5][4];
        
        
        int i,j;
        for(i=0;i<5;i++){
            System.out.println("Cliente "+(i+1));
            System.out.println("Ingrese puntaje (del 1 al 10) para la atencion al cliente: ");
            int atCli = Lector.leerInt();
            tabla[i][0]= atCli;
            System.out.println("Ingrese puntaje (del 1 al 10) para la calidad de la comida: ");
            int caliCom = Lector.leerInt();
            tabla[i][1]= caliCom;
            System.out.println("Ingrese puntaje (del 1 al 10) para la calidad del precio: ");
            int caliPre = Lector.leerInt();
            tabla[i][2]= caliPre;
            System.out.println("Ingrese puntaje (del 1 al 10) para la calidad del ambiente: ");
            int caliAmb = Lector.leerInt();
            tabla[i][3]= caliAmb;
        }
        
        for(i=0;i<5;i++){
            for(j=0;j<4;j++){
                System.out.print(tabla[i][j]+" ");
            }
            System.out.println();
        }
        
        
        for(j=0;j<4;j++){
            double suma=0;
            for(i=0;i<5;i++){
                suma = suma + tabla[i][j];
            }
            System.out.println("Promedio aspecto "+ j + ": " +suma/4);
        }
        
    }
    
}
