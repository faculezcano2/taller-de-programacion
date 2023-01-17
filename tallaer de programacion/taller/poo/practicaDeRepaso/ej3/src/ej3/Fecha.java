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
De cada “fecha” se conoce la ciudad y el día.
*/
public class Fecha {
    private String ciudad;
    private String dia;

    public Fecha(String ciudad, String dia) {
        this.ciudad = ciudad;
        this.dia = dia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getDia() {
        return dia;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Fecha: " + "ciudad=" + this.getCiudad() + ", dia=" + this.getDia();
    }
    
    
}
