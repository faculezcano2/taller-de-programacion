/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej1;

/**
 *
 * @author Facu
 */

/*
De cada investigador se tiene: nombre completo,
categoría (1 a 5) y especialidad. Además, cualquier investigador puede pedir hasta un
máximo de 5 subsidios.
*/
public class Investigador {
    private String nombre;
    private int categoria;
    private String especialidad;
    private Subsidio [] vecSubs;
    int dimL = 0;

    public Investigador(String nombre, int categoria, String especialidad) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.especialidad = especialidad;
        this.vecSubs = new Subsidio[5];
    }

    public String getNombre() {
        return nombre;
    }

    public int getCategoria() {
        return categoria;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    
    
    public Subsidio getSubsidio(int num){
        return this.vecSubs[num];
    }
    
    public double getTotalEnSub(){
        int recorrer = 0;
        double total = 0;
        while(recorrer<this.dimL){
            total = total + this.getSubsidio(recorrer).getMonto();
            recorrer++;
        }
        return total;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void agregarSubsidio(Subsidio unSubsidio){
        // agregar un subsidio al investigador.
        this.vecSubs[this.dimL] = unSubsidio;
        this.dimL++;
    }

    @Override
    public String toString() {
        return "nombre= " + this.getNombre() + ", categoria= " + this.getCategoria() + ", especialidad= " + this.getEspecialidad();
    }

    
    
    
    
}
