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
Una gira es un recital que además tiene un nombre y las “fechas” donde se repetirá la
actuación. De cada “fecha” se conoce la ciudad y el día. Además la gira guarda el
número de la fecha en la que se tocará próximamente (actual).

El constructor de giras
además recibe el nombre de la gira y la cantidad de fechas que tendrá.


ii. La gira debe saber responder a los mensajes:
 agregarFecha que recibe una “fecha” y la agrega adecuadamente.
 La gira debe responder al mensaje actuar de manera distinta. Imprime la leyenda
“Buenas noches …” seguido del nombre de la ciudad de la fecha “actual”. Luego
debe imprimir el listado de temas como lo hace cualquier recital. Además debe
establecer la siguiente fecha de la gira como la nueva “actual”.

*/
public class Gira extends Recital{
    private String nombre;
    private int cantFechas;
    private Fecha [] fechas;
    private int diml;
    private int actual;

    public Gira(String nombre, int cantFechas, String nombreBanda, int cantCanciones) {
        super(nombreBanda, cantCanciones);
        this.nombre = nombre;
        this.cantFechas = cantFechas;
        this.fechas = new Fecha[this.cantFechas];
        this.diml = 0;
        this.actual = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantFechas() {
        return cantFechas;
    }

    public int getActual() {
        return actual;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantFechas(int cantFechas) {
        this.cantFechas = cantFechas;
    }


    public void setActual(int actual) {
        this.actual = actual;
    }
    
    
    public void agregarFecha(Fecha fecha){
        if(this.diml<this.cantFechas){
            this.fechas[diml] = fecha;
            diml++;
        }
    }
    
    public String actuar(){
        String aux;
        aux = "buenas noches... nombre ciudad fecha actual: "+ this.fechas[this.actual].getCiudad() + " , " + super.actuar();
        this.actual++;
        return aux;
    }
    
    public double calcularCosto(){
        return this.cantFechas * 3000;
    }
}
