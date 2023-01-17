/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

/**
 *
 * @author Facu
 */
public class Paciente {
    private String nombre;
    private boolean obra;
    private double costo;

    public Paciente(String nombre, boolean obra, double costo) {
        this.nombre = nombre;
        this.obra = obra;
        this.costo = costo;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isObra() {
        return obra;
    }

    public double getCosto() {
        return costo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setObra(boolean obra) {
        this.obra = obra;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    @Override
    public String toString() {
        return "nombre=" + this.getNombre() + ", obra=" + this.isObra() + ", costo=" + this.getCosto()+". ";
    }

    
    
}
