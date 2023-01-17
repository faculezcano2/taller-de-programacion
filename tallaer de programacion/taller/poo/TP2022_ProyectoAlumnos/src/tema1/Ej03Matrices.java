/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema1;

//Paso 1. importar la funcionalidad para generar datos aleatorios
import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ej03Matrices {

    public static void main(String[] args) {
	//Paso 2. iniciar el generador aleatorio     
        GeneradorAleatorio.iniciar();
        //Paso 3. definir la matriz de enteros de 5x5 e iniciarla con nros. aleatorios 
        int [][] tabla = new int [5][5];
        int i,j;

        for (i=0;i<5;i++){
            for (j=0;j<5;j++){
                tabla[i][j] = GeneradorAleatorio.generarInt(31);
            }
        }
        //Paso 4. mostrar el contenido de la matriz en consola
        for (i=0;i<5;i++){
            for(j=0;j<5;j++){
                System.out.print(/*"fila "+i+" columna "+j+" su numero: "+*/ tabla[i][j]+" ");
            }
            System.out.println();
        }
        //Paso 5. calcular e informar la suma de los elementos de la fila 1
        int fila=1, suma=0;
        for(j=0;j<5;j++){
            suma=suma+tabla[fila][j];
        }
        System.out.println("la suma de los elementos de la fila 1: "+suma);
        
        //Paso 6. generar un vector de 5 posiciones donde cada posición j contiene la suma de los elementos de la columna j de la matriz. 
        //        Luego, imprima el vector.
        int [] vec = new int[6];
        for(i=0;i<5;i++){
            suma=0;
            for(j=0;j<5;j++){
                suma=suma+tabla[j][i];
            }
            vec[i] = suma;
        }
        
        for(i=0;i<5;i++){
            System.out.println("posicion vector "+i+" "+vec[i]);
        }
        
        //Paso 7. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        int fil = 9, columna = 9;
        System.out.print("ingrese un numero a buscar: ");
        int num = Lector.leerInt();
        for(i=0;i<5;i++){
            for(j=0;j<5;j++){
                if(tabla[i][j] == num){
                    fil = i;
                    columna = j;
                }
            }
        }
        if((fil != 9) && (columna != 9)){
            System.out.println("se encontro el numero su posicion es: fila: "+fil+". Columna: "+columna);
        }else{
            System.out.println("No se encontró el elemento");
        }

    }
}
