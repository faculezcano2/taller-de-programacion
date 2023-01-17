/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

/**
 *
 * @author Facu
 */
/*
Del director se 
conoce el nombre, DNI, edad y la antigüedad (un número entero). De los coristas se conoce 
el nombre, DNI, edad y el tono fundamental (un número entero).
*/
public class Persona {
    private String nombre;
    private int dni;
    private int edad;
    private int entero;

    public Persona(String nombre, int dni, int edad, int entero) {
        this.nombre = nombre;
        this.dni = dni;
        this.edad = edad;
        this.entero = entero;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDni() {
        return dni;
    }

    public int getEdad() {
        return edad;
    }

    public int getEntero() {
        return entero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setEntero(int entero) {
        this.entero = entero;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + this.getNombre() + ", dni=" + this.getDni() + ", edad=" + this.getEdad();
    }
    
    
}
