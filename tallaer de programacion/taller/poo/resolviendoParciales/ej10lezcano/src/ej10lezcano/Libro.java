/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej10lezcano;

/**
 *
 * @author Facu
 */
public abstract class Libro {
    private String titulo;
    private double precioBase;
    private int diml;
    private int dimf;
    private String [] vecAutores;

    public Libro(String titulo, double precioBase) {
        this.titulo = titulo;
        this.precioBase = precioBase;
        this.diml = 0;
        this.dimf = 8;
        this.vecAutores = new String [this.dimf];
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public int getDiml() {
        return diml;
    }

    public int getDimf() {
        return dimf;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    
    public void agregarAutor(String autor){
        this.vecAutores[this.diml] = autor;
        this.diml++;
    }
    
    
    public abstract double precio();

    @Override
    public String toString() {
        String aux = "titulo= " + this.getTitulo() + ", precioFinal= " + this.precio()+ ". Autores: \n";
        for(int i=0;i<this.getDiml();i++){
            aux = aux + this.vecAutores[i] +".\n";
        }
        return aux;
    }
    
    
}
