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
public class Estanteria {
    private int n;
    private int m;
    private Libro [][] vecEstantes;

    public Estanteria(int n, int m) {
        this.n = n;
        this.m = m;
        this.vecEstantes = new Libro[n][m];
    }

    public int getN() {
        return n;
    }

    public int getM() {
        return m;
    }

    public void setN(int n) {
        this.n = n;
    }

    public void setM(int m) {
        this.m = m;
    }
    
    
    public void almacenarLibro(Libro lib){
        int i = 0;
        int j = 0;
        boolean es = true;
        while(i<this.n && es == true){
            while(j<this.m && es == true){
                if(this.vecEstantes[i][j] == null){
                    this.vecEstantes[i][j] = lib;
                    es = false;
                }
                j++;
            }
            j=0;
            i++;
        }
    }
    
    public Libro sacarLibro(int x, int y){
        Libro libroADevolver = new Libro("","",0);
        if(this.vecEstantes[x][y]!= null){
            libroADevolver.setNombreAutor(this.vecEstantes[x][y].getNombreAutor());
            libroADevolver.setTitulo(this.vecEstantes[x][y].getTitulo());
            libroADevolver.setPeso(this.vecEstantes[x][y].getPeso());
            this.vecEstantes[x][y] = null;
        }
        return libroADevolver;
    }
    
    
    public int calcular(String autor){
        int i = 0;
        int j = 0;
        int cant = 0;
        while(i<this.n){
            while(j<this.m){
                if(this.vecEstantes[i][j] == null){
                   j++; 
                }else{
                    if(this.vecEstantes[i][j].getNombreAutor().equals(autor)){
                        cant++;
                    }
                    j++;
                }
            }
            j = 0;
            i++;
        }
        return cant;
    }
    
    public String leerVec(){
        int i = 0;
        int j = 0;
        String aux = "";
        while(i<this.n){
            while(j<this.m){
                if(this.vecEstantes[i][j] != null){
                   aux = aux + this.vecEstantes[i][j].toString()+"pos: "+i+" "+j+"\n";
                }
                j++;
            }
            j = 0;
            i++;
        }
        return aux;
    }
    
}
