/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

/**
 *
 * @author Facu
 * 
 * 
 * 7)
1) Queremos representar estanterías de libros. Una estantería mantiene sus libros
organizados en N estantes cada uno con lugar para M libros. Un libro posee título, nombre
de su primer autor y peso.
a) Implemente las clases de su modelo, con sus atributos y getters/setters adecuados.
Provea constructores para iniciar: los libros a partir de toda su información; la estantería
para N estantes y lugar para M libros por estante (inicialmente no debe tener libros
cargados).
b) Implemente los siguientes métodos:
- almacenarLibro: recibe un libro y lo almacena en el primer estante que tenga lugar.
Asuma que hay espacio para almacenar el libro.
- sacarLibro: saca y devuelve el libro que se encuentra en el estante X, lugar Y (X e Y se
reciben y son válidos). Dicho lugar debe quedar disponible.
- calcular: calcula y devuelve la cantidad de libros de un autor cuyo nombre se recibe.

* 
* 
* 2) Realice un programa que instancie una estantería para 5 estantes y 3 libros por
estante. Almacene 7 libros en la estantería. A partir de la estantería: saque un libro e
informe su representación String; luego,informe la cantidad de libros de “Borges”.
 * 
 */
public class Ej4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanteria est = new Estanteria(5,3);
        
        Libro lib1 = new Libro("cars","Borges",9);
        Libro lib2 = new Libro("sirenita","alberto",3);
        Libro lib3 = new Libro("teletubies","Borges",20);
        Libro lib4 = new Libro("el señor de los anillos","alberto",1);
        Libro lib5 = new Libro("harry potter","Borges",2);
        Libro lib6 = new Libro("50 sombras de grey","alberto",7);
        Libro lib7 = new Libro("el principito","Borges",10);
        
        
        est.almacenarLibro(lib1);
        est.almacenarLibro(lib2);
        est.almacenarLibro(lib3);
        est.almacenarLibro(lib4);
        est.almacenarLibro(lib5);
        est.almacenarLibro(lib6);
        est.almacenarLibro(lib7);   
        
        
        //System.out.println(lib2.toString());
        System.out.println(est.leerVec());
        System.out.println(est.calcular("Borges"));
        Libro lib = est.sacarLibro(2, 0);
        System.out.println("saque libro " + lib.toString());
        System.out.println(est.leerVec());
    }
    
}
