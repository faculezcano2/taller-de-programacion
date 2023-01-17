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
3-A- Defina una clase para representar estantes. Un estante almacena a lo sumo 20 libros.
Implemente un constructor que permita iniciar el estante sin libros. Provea métodos para:
(i) devolver la cantidad de libros que almacenados (ii) devolver si el estante está lleno
(iii) agregar un libro al estante (iv) devolver el libro con un título particular que se recibe.
B- Realice un programa que instancie un estante. Cargue varios libros. A partir del estante,
busque e informe el autor del libro “Mujercitas”.
C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
almacenen como máximo N libros? ¿Cómo instanciaría el estante?
*/
public class estante {
    private int max = 20;    //dimF
    private Libro[] vectorEstante;
    private int canthay = 0;    //dimL
    
    
    
    
    public estante(){
        this.canthay = 0;
        this.vectorEstante  = new Libro[max];
        for (int i = 0; i < vectorEstante.length; i++) {
            System.out.println(vectorEstante[i]);
            
        }
    }
    
    public int getCantLibros(){
        return this.canthay;
    }
    
    public boolean getEstaLLeno(){
        return(this.canthay == this.max);
    }
    
    public void setLibroEnEstante(Libro lib){
        if(!getEstaLLeno()){
            this.vectorEstante[this.canthay] = lib;
            this.canthay ++;
        }else{
            System.out.println("Esta lleno");
        }
    }
    
    public Libro getLibroDeEsteTitulo(String titulo){
        int i = 0;
        while(i<this.canthay){
            if(this.vectorEstante[i].getTitulo().equals(titulo)){
                return this.vectorEstante[i];
            }
            i++;
        }
        return null;
    }
    
    
    /*
    C- Piense: ¿Qué modificaría en la clase definida para ahora permitir estantes que
    almacenen como máximo N libros? ¿Cómo instanciaría el estante?
    
    lo que haria es crar el constructor y que la persona elija el maximo de libros a ingresar:
    public class estante {
        private int max;    //dimF
        private Libro vectorEstante [] = new Libro[max];
        private int canthay;    //dimL
    
        public void setCantMax(int max){
        this.max = max;
        }
    
        //y dsp todos los demas metodos
    }
        
    }
    */
}

