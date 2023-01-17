/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5;

/**
 *
 * @author Facu
 * 
 * 
 * 17) 
1- Una galería de arte quiere reunir información de sus artistas en un catálogo. El catálogo
almacena a lo sumo 15 artistas. De los artistas se registra el nombre artístico y la 
categoría. 
a) Genere las clases necesarias. Provea constructores para iniciar: el catálogo (sin 
artistas); los artistas a partir de toda su información.
b) Implemente los métodos necesarios, en las clases que correspondan, para permitir: 
- Agregar un artista al catálogo. Asuma que hay espacio.
- Devolver la cantidad de artistas cuya categoría coincide con una recibida. 

* 
* 2- Implemente un programa que instancie un catálogo y agreguele dos artistas. A partir del
catálogo: obtenga y muestre la cantidad de artistas de la categoría “pintura”.
 */
public class Ej5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Catalogo cat = new Catalogo();
        Artista art1 = new Artista("facash","pintura");
        Artista art2 = new Artista("nylonsh","pintu");
        
        cat.agregarArtistaAlCatalogo(art1);
        cat.agregarArtistaAlCatalogo(art2);
        
        System.out.println(cat.cantidad("pintura"));
    }
    
}
