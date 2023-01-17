/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej3;

/**
 *
 * @author Facu
 */
/*
De todo recital se conoce el nombre de la banda y la lista de temas que tocarán durante
el recital.

El constructor de recitales recibe el nombre de la banda y la cantidad de temas que tendrá el recital.

c) Implemente los métodos listados a continuación:
i. Cualquier recital debe saber responder a los mensajes:
 agregarTema que recibe el nombre de un tema y lo agrega a la lista de temas.
 actuar que imprime (por consola) para cada tema la leyenda “y ahora
tocaremos…” seguido por el nombre del tema.


iv. Todo recital debe saber responder al mensaje calcularCosto teniendo en cuenta lo
siguiente. Si es un evento ocasional devuelve 0 si es a beneficio, 50000 si es un show de TV
y 150000 si es privado. Las giras deben devolver 30000 por cada fecha de la misma.


*/
public abstract class Recital {
    private String nombreBanda;
    private int cantCanciones;
    private String [] listaCanciones;
    private int diml;
    private int atocar;

    public Recital(String nombreBanda, int cantCanciones) {
        this.nombreBanda = nombreBanda;
        this.cantCanciones = cantCanciones;
        this.diml = 0;
        this.atocar = -1;
        this.listaCanciones = new String[cantCanciones];
    }

    public String getNombreBanda() {
        return nombreBanda;
    }

    public int getCantCanciones() {
        return cantCanciones;
    }


    public void setNombreBanda(String nombreBanda) {
        this.nombreBanda = nombreBanda;
    }

    public void setCantCanciones(int cantCanciones) {
        this.cantCanciones = cantCanciones;
    }

    public void agregarTema(String tema){
        if(this.diml<this.cantCanciones){
            this.listaCanciones[diml] = tema;
            diml++;
        }
    }

    public String actuar(){
        String aux = " Ahora tocaremos... ";
        for(int i = 0; i < this.diml; i++){
            aux = aux + "\n" + this.listaCanciones[i]; 
        }
        return aux;
    }
    
    public abstract double calcularCosto();
    
}
