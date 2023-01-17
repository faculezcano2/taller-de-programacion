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
4- Se realizará un casting para un programa de TV. El casting durará a lo sumo 5 días y en
cada día se entrevistarán a 8 personas en distinto turno.
a) Simular el proceso de inscripción de personas al casting. A cada persona se le pide
nombre, DNI y edad y se la debe asignar en un día y turno de la siguiente manera: las
personas primero completan el primer día en turnos sucesivos, luego el segundo día y así
siguiendo. La inscripción finaliza al llegar una persona con nombre “ZZZ” o al cubrirse los
40 cupos de casting.
Una vez finalizada la inscripción:
b) Informar para cada día y turno el nombre de la persona a entrevistar.
NOTA: utilizar la clase Persona y pensar en la estructura de datos a utilizar.
*/

import PaqueteLectura.Lector;

public class ej3 {
    public static void main(String[] args){

        int dimD = 5;
        int dimE = 8;
        Persona tabla [][] = new Persona [dimD][dimE];
        
        System.out.println("ingrese el nombre: ");
        String nombre = Lector.leerString();
        int dia = 0;
        int castN = 0;
        
        while((dia<dimD) && (!nombre.equals("zzz"))){
            while((castN<dimE) && (!nombre.equals("zzz"))){
                tabla[dia][castN] = new Persona();
                
                tabla[dia][castN].setNombre(nombre);
                System.out.println("Ingrese el dni");
                int dni = Lector.leerInt();
                tabla[dia][castN].setDNI(dni);
                System.out.println("Ingrese edad: ");
                int edad = Lector.leerInt();
                tabla[dia][castN].setEdad(edad);
                
                castN++;
                System.out.println("ingrese el nombre: ");
                nombre = Lector.leerString();
            }
            dia++;
            castN = 0;
            
        }
        
        int diai=0;
        int castNi=0;
        while((diai<dimD)&&(!tabla[diai][castNi].getNombre().equals("zzz"))){
            System.out.println("Dia num: "+ diai);
            while((castNi<dimE)&&(!tabla[diai][castNi].getNombre().equals("zzz"))){
                System.out.println("casting num: "+ castNi);
                System.out.println("Persona a entrevistar: "+tabla[diai][castNi].getNombre());
                castNi++;
            }
            castNi=0;
            diai++;
        }
        
    }
}
