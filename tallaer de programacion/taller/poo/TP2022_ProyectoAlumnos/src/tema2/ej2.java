/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema2;

/**
 *
 * @author Facu
 */
/*
2- Utilizando la clase Persona. Realice un programa que almacene en un vector a lo sumo
15 personas. La información (nombre, DNI, edad) se debe generar aleatoriamente hasta
obtener edad 0. Luego de almacenar la información:
 - Informe la cantidad de personas mayores de 65 años.
 - Muestre la representación de la persona con menor DNI.
 */
import PaqueteLectura.GeneradorAleatorio;

public class ej2 {

    public static void main(String[] args) {
        int dimF = 15;
        int dimL = 0;
        int cant = 0;
        Persona[] vec = new Persona[dimF];
        Persona per = new Persona();

        int pos = 0;
        int min = 99999;

        GeneradorAleatorio.iniciar();

        System.out.println("Ingrese la edad: ");
        int edad = GeneradorAleatorio.generarInt(90);
        System.out.println(edad);

        while ((edad != 0)&&(dimL < dimF)) {
            System.out.println("Ingrese el nombre: ");
            String nombre = GeneradorAleatorio.generarString(10);
            System.out.println(nombre);
            System.out.println("ingrese el dni de la persona: ");
            int dni = GeneradorAleatorio.generarInt(200);
            System.out.println(dni);

            per = new Persona(nombre,dni,edad);
           
            vec[dimL] = per;

            dimL++;
            
            System.out.println("Ingrese la edad: ");
            edad = GeneradorAleatorio.generarInt(90);
            System.out.println(edad);
        }

        for(int i = 0; i<dimF; i++){
            if (vec[i].getEdad() > 65) {
              cant++;
            }

            if (vec[i].getDNI() < min) {
                min = vec[i].getDNI();
                pos = i;
            }
        }
        
        
        System.out.println(vec[pos].toString());
        System.out.println("La cantidad de mayores a 65 es de: "+ cant);

    }

}
