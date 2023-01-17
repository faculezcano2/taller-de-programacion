/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej4;

/**
 *
 * @author Facu
 */
/*
 coro semicircular en el que los coristas se colocan en el escenario uno al lado 
del otro

 agregar un corista al coro. 
o En el coro semicircular los coristas se deben ir agregando de izquierda 
a derecha

 determinar si un coro está lleno o no. Devuelve true si el coro tiene a todos sus 
coristas asignados o false en caso contrario.


 determinar si un coro (se supone que está lleno) está bien formado. Un coro 
está bien formado si:
o En el caso del coro semicircular, de izquierda a derecha los coristas 
están ordenados de mayor a menor en cuanto a tono fundamental. 

*/
public class CoroSemiCircular extends Coro {
    private Persona [] listcoristas;
    private int diml;
    private int dimf;

    public CoroSemiCircular( int dimf, String nombre, Persona director) {
        super(nombre, director);
        this.diml = 0;
        this.dimf = dimf;
        this.listcoristas = new Persona [this.dimf];
    }


    public int getDimf() {
        return dimf;
    }


    public void setDimf(int dimf) {
        this.dimf = dimf;
    }
    
    
    public void agregarCorista(Persona per){
        if(this.diml<this.dimf){
            this.listcoristas[diml] = per;
            diml++;
        }
    }
    
    public boolean estaLLeno(){
        boolean aux = false;
        if(this.diml == this.diml){
            aux = true;
        }
        return aux;
    }
    
    public boolean estaOrdenado(){
        boolean aux = true;
        if(this.estaLLeno() == true){
            int i = 0;
            while(i<this.diml && aux){
                aux = this.listcoristas[i].getEntero()> this.listcoristas[i+1].getEntero();
                i++;
            }
        }else{
            aux = false;
        }
        return aux;
    }

    @Override
    public String toString() {
        String aux = super.toString();
        for(int i =0; i<this.diml; i++){
            aux = aux + this.listcoristas[i].toString() + " tono fundamental: " + this.listcoristas[i].getEntero()+"\n";
        }
        return aux;
    }

    
    
    
    
    
    
    
    
}
