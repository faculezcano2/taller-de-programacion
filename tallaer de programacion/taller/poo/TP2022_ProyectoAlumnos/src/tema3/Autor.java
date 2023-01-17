/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3;

/**
 *
 * @author Hewlett-Packard
 */

/*
2-A- Modifique la clase Libro.java (carpeta tema3) para ahora considerar que el primer
autor es un objeto instancia de la clase Autor.
Implemente la clase Autor, sabiendo que se caracterizan por nombre, biografía y origen
y que deben permitir devolver/modificar el valor de sus atributos y devolver una
representación String formada por nombre, biografía y origen.
Luego realice las modificaciones necesarias en la clase Libro.
B- Modifique el programa Demo01Constructores (carpeta tema3) para instanciar los
libros con su autor, considerando las modificaciones realizadas. Luego, a partir de uno de
los libros instanciados, obtenga e imprima la representación del autor de ese libro.
*/

public class Autor {
    
    private String nombre;
    private String biografia;
    private String origen;
    
    public Autor(String nombre, String biografia, String origen){
        this.nombre = nombre;
        this.biografia = biografia;
        this.origen = origen;
    };
    
    public Autor(){
    };
    
    //getters y setters
    //gets
    public String getNombre(){
        return this.nombre;
    }
    
    public String getBiografia(){
        return this.biografia;
    }
    
    public String getOrigen(){
        return this.origen;
    }
    
    //sets
    public void setNombre(String unNombre){
        this.nombre = unNombre;
    }
    
    public void setBiografia(String unaBiografia){
        this.biografia = unaBiografia;
    }
    
    public void setOrigen(String unOrigen){
        this.origen = unOrigen;
    }
    
    @Override
    public String toString(){
        String aux = "autor: "+this.nombre+", biografia: "+ this.biografia+", origen: "+this.origen;
        return(aux);
    }
}

