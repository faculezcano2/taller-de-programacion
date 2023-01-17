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
 * 6)
1) Queremos representar libros electrónicos e impresos. De cualquier libro se conoce:
título, precio base y el nombre de los autores (a lo sumo 8). Adicionalmente: los libros
electrónicos tienen el formato (ej: “.pdf”, “.epub”) y su tamaño en MB; mientras que los
libros impresos registran si es tapa dura o no.
a) Implemente las clases del modelo con sus atributos y getters/setters adecuados.
Provea constructores para iniciar los libros a partir de toda su información y sin autores.
b) Agregue a las clases implementadas los métodos necesarios para incorporar la
siguiente funcionalidad:
i- Agregar al libro un autor cuyo nombre se recibe. Asuma que hay espacio.
ii- Obtener el precio final del libro teniendo en cuenta que:
- Para los libros electrónicos es el precio base al que se adiciona un impuesto de
descarga de 2,5$ por MB.
- Para los libros impresos es el precio base al que se adiciona 500$ si es de tapa dura.
iii-Obtener la representación String del libro, la cual se compone de título, precio final y
nombre de sus autores.
* 
* 
2) Realice un programa que instancie un libro electrónico y un libro impreso. Cargue 3
autores a cada uno. Para finalizar, muestre la representación String de los libros.
 */
public class Ej3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        LibroElectronico le = new LibroElectronico("jpg",5.5,"el principito",200);
        LibroImpreso li = new LibroImpreso(true,"el principito",200);
        
        le.AgregarAutor("franco");
        le.AgregarAutor("pepe");
        le.AgregarAutor("cacatua");
        
        li.AgregarAutor("pedro");
        li.AgregarAutor("cacatua");
        li.AgregarAutor("nilo");
        
        System.out.println("libro electronico: " + le.toString());
        System.out.println("libro impreso: " + li.toString());
    }
    
}
