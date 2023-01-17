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
public class Libro {
    private String titulo;
    private String nombreAutor;
    private double peso;

    public Libro(String titulo, String nombreAutor, double peso) {
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.peso = peso;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public double getPeso() {
        return peso;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "titulo=" + this.getTitulo() + ", nombreAutor=" + this.getNombreAutor() + ", peso=" + this.getPeso();
    }
    
    
}

