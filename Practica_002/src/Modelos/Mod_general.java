/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelos;

import java.util.ArrayList;
import javafx.scene.control.Alert;

/**
 *
 * @author e_d_d
 */
public class Mod_general {
    public static ArrayList <Contacto>listaContactos=new ArrayList<Contacto>();
    
    public static void fun_mensajeInformacion(String mensaje){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("");
        alert.setTitle("Mensaje del sistema");
        alert.setContentText(mensaje);
        alert.showAndWait();
        
        
        
    }
    
    
}
