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
public class Entrenadores extends Empleados {
    private int cantCampeonatosGanados;

    public Entrenadores(int cantCampeonatosGanados, String nombre, double sueldo, int antiguedad) {
        super(nombre, sueldo, antiguedad);
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }

    public int getCantCampeonatosGanados() {
        return this.cantCampeonatosGanados;
    }

    public void setCantCampeonatosGanados(int cantCampeonatosGanados) {
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }
    
    
    public double calcularEfectividad(){
        return ((double)this.getCantCampeonatosGanados()/this.getAntiguedad());
    }
    
    public double calcularSueldoACobrar(){
        double cobrar = 0;
        if(this.getCantCampeonatosGanados()>=1 && this.getCantCampeonatosGanados()<=4){
            cobrar = this.getSueldo()+5000;
        }else if(this.getCantCampeonatosGanados()>=5 && this.getCantCampeonatosGanados()<=10){
            cobrar = this.getSueldo()+30000;
        }else if(this.getCantCampeonatosGanados()>10){
            cobrar = this.getSueldo()+ 50000;
        }
        return cobrar;
    }
    


    
    
    
}
