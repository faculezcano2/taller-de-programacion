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
 * 
 * 
 * 
 * 5)
1) Queremos representar estanterías de libros. Una estantería mantiene sus libros
organizados en N estantes cada uno con lugar para M libros. Un libro posee título, nombre
de su primer autor y peso.
a) Implemente las clases de su modelo, con sus atributos y getters/setters adecuados.
Provea constructores para iniciar: los libros a partir de toda su información; la estantería
para N estantes y lugar para M libros por estante (inicialmente no debe tener libros
cargados).
b) Implemente los siguientes métodos:
- almacenarLibro: recibe un libro, un nro. de estante y nro. de lugar válidos y guarda al
libro en la estantería. Asuma que dicho lugar está disponible.
- sacarLibro: recibe el título de un libro, y saca y devuelve el libro con ese título, quedando
su lugar disponible. Tenga en cuenta que el libro puede no existir.
- calcular: calcula y devuelve el libro más pesado de la estantería.
* 
* 
* 
* 
2) Realice un programa que instancie una estantería para 5 estantes y 3 libros por
estante. Almacene 7 libros en la estantería. A partir de la estantería: saque un libro e
informe su representación String; luego, informe el título del libro más pesado.
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Estanteria est = new Estanteria(5,3);
        
        Libro lib1 = new Libro("cars","alberto",9);
        Libro lib2 = new Libro("sirenita","alberto",3);
        Libro lib3 = new Libro("teletubies","alberto",20);
        Libro lib4 = new Libro("el señor de los anillos","alberto",1);
        Libro lib5 = new Libro("harry potter","alberto",2);
        Libro lib6 = new Libro("50 sombras de grey","alberto",7);
        Libro lib7 = new Libro("el principito","alberto",10);
        
        
        est.almacenarLibro(lib1, 0, 0);
        est.almacenarLibro(lib2, 1, 1);
        est.almacenarLibro(lib3, 2, 2);
        est.almacenarLibro(lib4, 3, 0);
        est.almacenarLibro(lib5, 4, 1);
        est.almacenarLibro(lib6, 2, 1);
        est.almacenarLibro(lib7, 4, 0);
        
        
        
        Libro libroSacado = est.sacarLibro("harry potter");
        System.out.println(libroSacado.toString());
        System.out.println("titulo libro mas pesado: "+ est.libroMasPesado());
        
    }
    
}
