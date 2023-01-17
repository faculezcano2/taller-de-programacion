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
Los coros poseen 
un nombre y están formados por un director y una serie de coristas.
*/
public abstract class Coro {
    private String nombre;
    private Persona director;

    public Coro(String nombre, Persona director) {
        this.nombre = nombre;
        this.director = director;
    }

    public String getNombre() {
        return nombre;
    }

    public Persona getDirector() {
        return director;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDirector(Persona director) {
        this.director = director;
    }
    
    public abstract void agregarCorista(Persona per);
    
    public abstract boolean estaLLeno();
    public abstract boolean estaOrdenado();

    @Override
    public String toString() {
        return "Coro{" + "nombre=" + nombre + ", director=" + director.toString() +", antiguedad director: "+ director.getEntero() + '}';
    }
    
    
}
