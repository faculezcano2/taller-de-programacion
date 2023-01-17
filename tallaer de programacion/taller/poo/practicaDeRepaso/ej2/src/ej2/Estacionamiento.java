/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej2;

/**
 *
 * @author Facu
 */
/*
Un estacionamiento conoce su
nombre, dirección, hora de apertura, hora de cierre, y almacena para cada número de piso
(1..N) y número de plaza (1..M), el auto que ocupa dicho lugar.
*/
public class Estacionamiento {
    private String nombre;
    private String direccion;
    private String horaAper;
    private String horaCie;
    private int piso;
    private int plazas;
    private Auto [][] matAutos;

    public Estacionamiento(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaAper = "8:00";
        this.horaCie = "21:00";
        this.piso = 5;
        this.plazas = 10;
        this.matAutos = new Auto[this.piso][this.plazas];
    }

    public Estacionamiento(String nombre, String direccion, String horaAper, String horaCie, int piso, int plazas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.horaAper = horaAper;
        this.horaCie = horaCie;
        this.piso = piso;
        this.plazas = plazas;
        this.matAutos = new Auto[this.piso][this.plazas];
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getHoraAper() {
        return horaAper;
    }

    public String getHoraCie() {
        return horaCie;
    }

    public int getPiso() {
        return piso;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setHoraAper(String horaAper) {
        this.horaAper = horaAper;
    }

    public void setHoraCie(String horaCie) {
        this.horaCie = horaCie;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }
    
    
    
    
    /*
    c) Implemente métodos para:
    - Dado un auto A, un número de piso X y un número de plaza Y, registrar al auto
    en el estacionamiento en el lugar X,Y. Suponga que X, Y son válidos (es decir,
    están en rango 1..N y 1..M respectivamente) y que el lugar está desocupado.
    */
    public void setAutoEnLugar(Auto auto, int piso, int plaza){
        this.matAutos[piso][plaza] = new Auto(auto.getNombreDueño(),auto.getPatente());
         this.matAutos[piso][plaza] = auto;
    }
    
    /*
    - Dada una patente, obtener un String que contenga el número de piso y plaza
    donde está dicho auto en el estacionamiento. En caso de no encontrarse,
    retornar el mensaje “Auto Inexistente”.
    */
    public String buscarAuto(String patente){
        int recorrerPiso = 0;
        int pisoesta = -1;
        int plazaesta = -1;
        int recorrerPlaza = 0;
        String aux;
        while(recorrerPiso<this.piso){
            while(recorrerPlaza<this.plazas){
                if(this.matAutos[recorrerPiso][recorrerPlaza] == null){
                    recorrerPlaza++;
                }else{
                    if(this.matAutos[recorrerPiso][recorrerPlaza].getPatente().equals(patente)){
                        pisoesta = recorrerPiso;
                        plazaesta = recorrerPlaza;
                        recorrerPlaza++;
                    }
                    recorrerPlaza++;
                }
            }
            recorrerPlaza = 0;
            recorrerPiso++;   
        }
        if((pisoesta==-1) || (plazaesta==-1)){
            aux = "Auto inexistente";
        }else{
            aux = "El auto se encuentra en el piso: "+ pisoesta+", plaza: "+ plazaesta;
        }
        return aux;
    }
    
    
    /*
    - Obtener un String con la representación del estacionamiento. Ejemplo: “Piso 1
    Plaza 1: libre Piso 1 Plaza 2: representación del auto …
    Piso 2 Plaza 1: libre … etc”
    */
    
    @Override
    public String toString() {
        String aux;
        aux = "Estacionamiento{" + "nombre=" + this.getNombre() + ", direccion=" + this.getDireccion() + ", horaAper=" + this.getHoraAper() + ", horaCie=" + this.getHoraCie() + ", piso=" + this.getPiso() + ", plazas=" + this.getPlazas()+". ";
        String aux2 = "";
        for (int i = 0; i<this.piso;i++){
            for (int j = 0; j<this.plazas;j++){
                if(this.matAutos[i][j] == null){
                    aux2 = aux2 + " \n Piso "+i+", plaza "+j+ ":  libre.";
                }else{
                    aux2 = aux2 + " \n Piso "+i+", plaza "+j+  ": "+ this.matAutos[i][j].toString();
                }
            }
        }
        return aux + aux2;
    }

    
    
    /*
    - Dado un número de plaza Y, obtener la cantidad de autos ubicados en dicha
    plaza (teniendo en cuenta todos los pisos).
    */
     
   public int cantAutosEnPlaza(int plaza){
       int total=0;
       for(int i=0;i<this.piso;i++){
           if(this.matAutos[i][plaza] == null){
               total = total + 0;
           }else{
               total ++;
           }
       }
       return total;
   }
    
    
    
    
    
    
    
}
