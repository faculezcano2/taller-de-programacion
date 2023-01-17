/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

/**
 *
 * @author Facu
 * 
 * la estantería
para N estantes y lugar para M libros por estante (inicialmente no debe tener libros
* 
* b) Implemente los siguientes métodos:
- almacenarLibro: recibe un libro, un nro. de estante y nro. de lugar válidos y guarda al
libro en la estantería. Asuma que dicho lugar está disponible.
- sacarLibro: recibe el título de un libro, y saca y devuelve el libro con ese título, quedando
su lugar disponible. Tenga en cuenta que el libro puede no existir.
- calcular: calcula y devuelve el libro más pesado de la estantería.
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

    
    
    
    public void almacenarLibro(Libro lib, int n, int m){
        this.vecEstantes[n][m]=lib;
    }
    
    public Libro sacarLibro(String titulo){
        int i = 0;
        int j = 0;
        Libro libro = new Libro("","",0);
        while(i<this.n){
            while(j<this.m){
                if(this.vecEstantes[i][j] == null){
                    j++;
                }else{
                    if(this.vecEstantes[i][j].getTitulo().equals(titulo)){
                        libro.setNombreAutor(this.vecEstantes[i][j].getNombreAutor());
                        libro.setTitulo(this.vecEstantes[i][j].getTitulo());
                        libro.setPeso(this.vecEstantes[i][j].getPeso());
                        this.vecEstantes[i][j] = null;
                    }
                j++;
                }
            }
            j=0;
            i++;
        }
        return libro;
    }
    
    
    public String libroMasPesado(){
        int i = 0;
        int j = 0;
        double max = 0;
        String titMax = "";
        while(i<this.n){
            while(j<this.m){
                if(this.vecEstantes[i][j] == null){
                    j++;
                }else{
                    if(this.vecEstantes[i][j].getPeso()>max){
                    max = this.vecEstantes[i][j].getPeso();
                    titMax =  this.vecEstantes[i][j].getTitulo();
                }
                j++;
                }
            }
            j=0;
            i++;
        }
        return titMax;
    }
    
    
    
    
    
    
    
    
    @Override
    public String toString() {
        String aux;
        return "Estanteria{" + "num estanterias= " + this.getN() + ", num libros por estanteria= " + this.getM() + '}';
    }
    
    
    
}
