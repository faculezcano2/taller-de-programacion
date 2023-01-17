/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Facu
 * 
 * De cualquier libro se conoce:
título, precio base y el nombre de los autores (a lo sumo 8)
 */
public abstract class Libro {
    private String titulo;
    private double precio;
    private int dimF;
    private int dimL;
    private String [] autores;

    public Libro(String titulo, double precio) {
        this.titulo = titulo;
        this.precio = precio;
        this.dimF = 8;
        this.dimL = 0;
        this.autores = new String[this.dimF];
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public int getDimF() {
        return dimF;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
    public void AgregarAutor(String autor){
        if(this.dimL < this.dimF){
            this.autores[this.dimL] = autor;
            this.dimL++;
        }
    }

    
    public abstract double obtenerPrecio();

    @Override
    public String toString() {
        String aux = "titulo= " + this.getTitulo() + ", precio= " + this.obtenerPrecio()+ "\n";
        for(int i = 0;i<this.dimL;i++){
            aux = aux + " " + this.autores[i]+"\n";
        }
        return aux;
    }
    
    
    
    
}
