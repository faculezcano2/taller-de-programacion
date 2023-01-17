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
public class Catalogo {
    private Artista[] vecArtistas;
    private int dimL;

    public Catalogo() {
        this.vecArtistas = new Artista[15];
        this.dimL = 0;
    }
    
    public void agregarArtistaAlCatalogo(Artista ar){
        if(this.dimL<15){
            this.vecArtistas[this.dimL] = ar;
            this.dimL++;
        }
    }
    
    public int cantidad(String cat){
        int cant = 0;
        for(int i = 0; i<this.dimL;i++){
            if(this.vecArtistas[i].getCategoria().equals(cat)){
                cant++;
            }
        }
        return cant;
    }
}
