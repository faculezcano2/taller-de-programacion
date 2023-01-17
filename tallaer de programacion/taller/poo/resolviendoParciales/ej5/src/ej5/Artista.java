/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5;

/**
 *
 * @author Facu
 */
public class Artista {
    private String nombreArtistico;
    private String categoria;

    public Artista(String nombreArtistico, String categoria) {
        this.nombreArtistico = nombreArtistico;
        this.categoria = categoria;
    }

    public void setNombreArtistico(String nombreArtistico) {
        this.nombreArtistico = nombreArtistico;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNombreArtistico() {
        return nombreArtistico;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "nombreArtistico=" + this.getNombreArtistico() + ", categoria=" + this.getCategoria();
    }

    
}
