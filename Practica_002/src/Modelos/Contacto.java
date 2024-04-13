/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;

/**
 *
 * @author e_d_d
 */
public class Contacto {
    private String cedula;
    private String nombres;
    private String direccion;
    
    private ArrayList<Telefono> listatelefonos=new ArrayList<Telefono>();

    public Contacto() {
    }

    public Contacto(String cedula, String nombres, String direccion) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.direccion = direccion;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public ArrayList<Telefono> getListatelefonos() {
        return listatelefonos;
    }

    public void addListatelefonos(Telefono objTelefono) {
        this.listatelefonos.add(objTelefono);  
    }

    @Override
    public String toString() {
        return nombres + "-"+ cedula ;
    }
    
    
    
    
}
