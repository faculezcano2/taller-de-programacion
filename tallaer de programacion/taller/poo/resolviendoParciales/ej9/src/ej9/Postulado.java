/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;

/**
 *
 * @author Facu
 */
public class Postulado {
    private String nombre;
    private int cantPublicaciones;
    private int antiguedad;

    public Postulado(String nombre, int cantPublicaciones, int antiguedad) {
        this.nombre = nombre;
        this.cantPublicaciones = cantPublicaciones;
        this.antiguedad = antiguedad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantPublicaciones() {
        return cantPublicaciones;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantPublicaciones(int cantPublicaciones) {
        this.cantPublicaciones = cantPublicaciones;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }
    
    
}
