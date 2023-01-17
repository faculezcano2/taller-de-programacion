    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej9;



/**
 *
 * @author Facu
 */
public abstract class Premiaciones {
    private int dimL;
    private int dimF;
    private Postulado [] vecPostulados;

    public Premiaciones( int dimF) {
        this.dimL = 0;
        this.dimF = dimF;
        this.vecPostulados = new Postulado[this.dimF];
    }

    public int getDimL() {
        return dimL;
    }

    public int getDimF() {
        return dimF;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }

    public void setDimF(int dimF) {
        this.dimF = dimF;
    }

   
    public Postulado getPostulante(int i){
        return this.vecPostulados[i];
    }
    
    public void agregarPostulado(Postulado po){
        if(this.dimL<this.dimF){
            this.vecPostulados[this.dimL] = po;
            this.dimL++;
        }
    }
    
    public abstract String otorgarPremio(int x);
    
    
}
