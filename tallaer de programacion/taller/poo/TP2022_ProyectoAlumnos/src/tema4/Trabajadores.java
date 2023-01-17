/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Facu
 */
public class Trabajadores extends Persona{
    
    private String trabajo;

    public Trabajadores(String trabajo, String nombre, int DNI, int edad) {
        super(nombre, DNI, edad);
        this.trabajo = trabajo;
    }

    public String getTrabajo() {
        return trabajo;
    }

    public void setTrabajo(String trabajo) {
        this.trabajo = trabajo;
    }

    @Override
    public String toString() {
        return super.toString() + " y mi trabajo es " + trabajo + '.';
    }
    
    
    
}
