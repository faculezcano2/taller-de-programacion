/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej8;

/**
 *
 * @author Facu
 */
public class Concurso {
    private Pareja [] vecParejas;
    private int diml;
    private int dimf;

    public Concurso(int N) {
        this.dimf = N;
        this.vecParejas = new Pareja[this.dimf];
        this.diml = 0;
    }

    public int getDiml() {
        return diml;
    }

    public int getDimf() {
        return dimf;
    }


    public void setDiml(int diml) {
        this.diml = diml;
    }

    public void setDimf(int dimf) {
        this.dimf = dimf;
    }
    
    
    public void agregarPareja(Pareja pa){
        this.vecParejas[this.diml] = pa;
        this.diml++;
    }
        
    public Pareja difMasEdad(){
        int max=0;
        Participante p1 = new Participante(0,"",0);
        Participante p2 = new Participante(0,"",0);
        Pareja parMax = new Pareja (p1,p2,"");
        for(int i=0;i<this.diml;i++){
            if(this.vecParejas[i].difEdad()>max){
                max = this.vecParejas[i].difEdad();
                parMax.setP1(this.vecParejas[i].getP1());
                parMax.setP2(this.vecParejas[i].getP2());
                parMax.setEstilo(this.vecParejas[i].getEstilo());
            }
        }
        return parMax;
    }
}
