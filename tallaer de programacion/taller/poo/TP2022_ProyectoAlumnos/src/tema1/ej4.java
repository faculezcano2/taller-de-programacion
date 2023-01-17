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

public class ej4 {
    public static void main(String[] args) {
        int [][] tabla = new int [8][4];
        
        int i,j;
        //pongo en 0 todas las posiciones de la matriz
        for (i=0;i<8;i++){
            for(j=0;j<4;j++){
                tabla[i][j]=0;
            }
        }
        
        //leo persona que entra al edificio y sumo 
        System.out.println("num piso");
        int piso = Lector.leerInt();
        System.out.println("num ofi");
        int ofi = Lector.leerInt();
        while(piso != 9){
            tabla[piso][ofi] = tabla[piso][ofi] + 1;
            System.out.println("num piso");
            piso = Lector.leerInt();
            System.out.println("num ofi");
            ofi = Lector.leerInt();
        }
        
        
        for(i=0;i<8;i++){
            for(j=0;j<4;j++){
                System.out.print(tabla[i][j]+ " ");
            }
            System.out.println();
        }
        
        
        
        
        
        
    }
}
