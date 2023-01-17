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
De cada habitación conoce costo por noche, si está
ocupada y, en caso de estarlo, guarda el cliente que la reservó (nombre, DNI y edad).
*/

public class Habitacion {
    private double costo;
    private boolean ocupada;
    private Persona per;

    public Habitacion(double costo, boolean ocupada, Persona per) {
        this.costo = costo;
        this.ocupada = ocupada;
        this.per = per;
    }
    
    public Habitacion(){
    }

    public double getCosto() {
        return costo;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public Persona getPer() {
        return per;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }

    public void setPer(Persona per) {
        this.per = per;
    }

    @Override
    public String toString() {
        return "Habitacion{" + "costo=" + costo + ", ocupada=" + ocupada + ", per=" + per + '}';
    }
    
    
    
    
}
