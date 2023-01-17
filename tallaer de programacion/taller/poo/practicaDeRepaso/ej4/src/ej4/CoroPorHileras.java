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
 agregar un corista al coro.
o En el coro por hileras los coristas se deben ir agregando de izquierda a 
derecha, completando la hilera antes de pasar a la siguiente.

 determinar si un coro está lleno o no. Devuelve true si el coro tiene a todos sus 
coristas asignados o false en caso contrario.


 determinar si un coro (se supone que está lleno) está bien formado. Un coro 
está bien formado si:
o En el caso del coro por hileras, todos los miembros de una misma hilera 
tienen el mismo tono fundamental y además todos los primeros
miembros de cada hilera están ordenados de mayor a menor en cuanto 
a tono fundamental.

*/
public class CoroPorHileras extends Coro {
    private Persona [][] matrCoristas;
    private int filas;
    private int col;
    private int dimlcol;
    private int dimlfil;

    public CoroPorHileras(int filas, int col, String nombre, Persona director) {
        super(nombre, director);
        this.filas = filas;
        this.col = col;
        this.matrCoristas = new Persona[this.filas][this.col];
        this.dimlcol = 0;
        this.dimlfil = 0;
    }

    public int getFilas() {
        return filas;
    }

    public int getCol() {
        return col;
    }

    public int getDimlcol() {
        return dimlcol;
    }

    public int getDimlfil() {
        return dimlfil;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setDimlcol(int dimlcol) {
        this.dimlcol = dimlcol;
    }

    public void setDimlfil(int dimlfil) {
        this.dimlfil = dimlfil;
    }

    public void agregarCorista(Persona per){
        if(this.dimlfil<this.filas){
            if(this.dimlcol<this.col){
                this.matrCoristas[this.dimlfil][this.dimlcol] = per;
                this.dimlcol++;
            }
            this.dimlfil++;
        }
    }
    
    
    public boolean estaLLeno(){
        boolean aux = false;
        if((this.dimlfil == this.filas)&&( this.dimlcol == this.col)){
            aux = true;
        }
        return aux;
    }

    
    
    public boolean estaOrdenado(){
        boolean aux1 = true;
        boolean aux2 = true;
        int i = 0;
        int j = 0;
        if(this.estaLLeno() == true){
            while(i<this.dimlfil && aux2 && aux1){
                while(j<this.dimlcol && aux1){
                    aux1 = this.matrCoristas[i][j].getEntero() == this.matrCoristas[i][j+1].getEntero();
                    j++;
                }
                aux2 = this.matrCoristas[i][1].getEntero()>this.matrCoristas[i+1][1].getEntero();
                j=0;
                i++;
            }
        }
        return aux1 && aux2;
    }

    @Override
    public String toString() {
        int j;
        String aux = super.toString();
        for(int i=0; i<this.dimlfil;i++){
            for(j=0; j<this.dimlcol;j++){
                aux= aux + this.matrCoristas[i][j].toString()+" tono fundamental: " + this.matrCoristas[i][j].getEntero()+".\n";
            }
        }
        return aux;
    }

    
    
    
    
}
