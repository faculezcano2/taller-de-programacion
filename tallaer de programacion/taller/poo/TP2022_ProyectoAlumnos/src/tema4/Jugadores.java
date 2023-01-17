/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema4;

/**
 *
 * @author Facu
 */
public class Jugadores extends Empleados {
    private int partJudados;
    private int golesAnotados;

    public Jugadores(int partJudados, int golesAnotados, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.partJudados = partJudados;
        this.golesAnotados = golesAnotados;
    }

    public int getPartJudados() {
        return this.partJudados;
    }

    public int getGolesAnotados() {
        return this.golesAnotados;
    }

    public void setPartJudados(int partJudados) {
        this.partJudados = partJudados;
    }

    public void setGolesAnotados(int golesAnotados) {
        this.golesAnotados = golesAnotados;
    }

    
    public double calcularEfectividad(){
        return (((double)this.getGolesAnotados()/this.getPartJudados()));
    }
    
    public double calcularSueldoACobrar(){
        double cobrar;
        if(this.calcularEfectividad() > 0.5){
            cobrar = this.getSueldo()+this.getSueldo();
        }else{
            cobrar = ((this.getSueldo()+(this.getSueldo()*0.10))*this.getAntiguedad());
        }
        return cobrar;
    }
    

    

    
    
    
    
}
