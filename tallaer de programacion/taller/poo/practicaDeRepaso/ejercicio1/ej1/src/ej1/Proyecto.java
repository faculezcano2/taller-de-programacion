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
Un proyecto
tiene: nombre, código, nombre completo del director y los investigadores que participan
en el proyecto (50 como máximo).
*/


public class Proyecto {
    private String nombre;
    private int codigo;
    private String nombreDirector;
    private Investigador [] vecInvestigadores;
    private int dimL = 0;

    public Proyecto(String nombre, int codigo, String nombreDirector) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.nombreDirector = nombreDirector;
        this.vecInvestigadores = new Investigador[50];
    }

    public String getNombre() {
        return nombre;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }



    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

    public void agregarInvestigador(Investigador unInvestigador){
    // agregar un investigador al proyecto.
        this.vecInvestigadores[this.dimL] = unInvestigador;
        this.dimL++;
    }

    
    public double dineroTotalOtorgado(){
        double total = 0;
        int recorrer1 = 0;
        int recorrer2 = 0;
        /*devolver el monto total otorgado en subsidios del proyecto (tener en cuenta
        todos los subsidios otorgados de todos los investigadores)*/
        while(recorrer1<this.dimL){
            while(recorrer2<this.vecInvestigadores[recorrer1].dimL){
                total = total + this.vecInvestigadores[recorrer2].getSubsidio(recorrer2).getMonto();
                recorrer2++;
            }
            total = total + this.vecInvestigadores[recorrer1].getSubsidio(recorrer1).getMonto();
            recorrer1++;
        }
        return total;
    }
    
    
    public void otorgarTodos(String nombre_completo){
        /*otorgar todos los subsidios no-otorgados del investigador llamado
        nombre_completo*/
        int recorrer1 = 0;
        int recorrer2 = 0;
        while(recorrer1<this.dimL){
            if(this.vecInvestigadores[recorrer1].getNombre().equals(nombre_completo)){
                while(recorrer2<this.vecInvestigadores[recorrer1].dimL){
                    if((this.vecInvestigadores[recorrer1].getSubsidio(recorrer1).isOtorgado()) == false){
                        this.vecInvestigadores[recorrer1].getSubsidio(recorrer1).setOtorgado(true);
                    }
                    recorrer2++;
                }
            }
            
            
            
            recorrer1++;
        }
        
    }



    
    public String toString() {
        /*
        devolver un string con: nombre del proyecto, código, nombre del director, el
        total de dinero otorgado del proyecto y la siguiente información de cada
        investigador: nombre, categoría, especialidad, y el total de dinero de sus
        subsidios otorgados.
        */
        String aux = "nombre= " + this.getNombre() + ", codigo= " + this.getCodigo() + ", nombreDirector= " + this.getNombreDirector() + ", total dinero otorgado= " 
                + this.dineroTotalOtorgado();
                for(int i = 0; i<this.dimL;i++){
                    aux = aux + "\n. investigador "+ (i+1)+": " + this.vecInvestigadores[i].toString();
                }
        return aux;
    }
}



