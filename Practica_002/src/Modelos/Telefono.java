/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

/**
 *
 * @author e_d_d
 */
public class Telefono {
      private String numero;
    private String operadora;
  

    public Telefono(String operadora, String numero) {
        this.operadora = operadora;
        this.numero = numero;
    }

    public String getOperadora() {
        return operadora;
    }

    public String getNumero() {
        return numero;
    }
    
    
}
