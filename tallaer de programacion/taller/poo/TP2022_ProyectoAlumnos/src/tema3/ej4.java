/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Facu
 */

/*
B- Realice un programa que instancie un hotel, ingrese clientes en distintas habitaciones,
muestre el hotel, aumente el precio de las habitaciones y vuelva a mostrar el hotel.
NOTAS: Reúse la clase Persona. Para cada método solicitado piense a qué clase debe
delegar la responsabilidad de la operación
*/



public class ej4 {
    public static void main(String[] args) {
        int habs = 10;
        Hotel hotel = new Hotel(habs);
        Persona persona1 = new Persona("facundo",42027949,22);
        Persona persona2 = new Persona("leandro",40011111,24);
        Persona persona3 = new Persona("isabel",43423392,25);
        Persona persona4 = new Persona("franco",43424323,27);
        Persona persona5 = new Persona("susana",20010210,99);
        
        Habitacion hab1 = new Habitacion(2,true,persona1);
        
        
        hotel.setClienteEnHabitacion(persona1, 0);
        hotel.setClienteEnHabitacion(persona2, 2);
        hotel.setClienteEnHabitacion(persona3, 4);
        hotel.setClienteEnHabitacion(persona4, 6);
        hotel.setClienteEnHabitacion(persona5, 8);
        
        System.out.println("Primera lectura del hotel: ");
        System.out.println( hotel.toString());
        
        hotel.aumentarCostoTodasHabs(9000);
        System.out.println("Segunda lectura del hotel con aumentos: ");
        System.out.println( hotel.toString());
    }
    
}
