/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Contacto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXMLRegistroContactoController implements Initializable {

    @FXML
    private Button btn_cerrar;
    @FXML
    private Button btn_grabar;
    @FXML
    private TextField txt_cedula;
    @FXML
    private TextField txt_nombres;
    @FXML
    private TextArea txt_area;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        


    }
    

    public void cerrarFormulario() {
        System.out.println("cerrar");
        try {
            String formulario = "/Vistas/FXMLPrincipal.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);

            stage.show();
            Stage myStage = (Stage) this.btn_cerrar.getScene().getWindow();

            myStage.close();

        } catch (Exception e) {
        }
        //    
    }

    @FXML
    private void acc_cerrarPantalla(ActionEvent event) {
        this.cerrarFormulario();
    }

    @FXML
    private void acc_grabar(ActionEvent event) {
        try {
            //capturar el objeto
            // fun_val_cedula(this.txt_cedula.getText());
            if (fun_validar()) {
                String cedula, nombres, direccion;
                cedula = this.txt_cedula.getText();
                nombres = this.txt_nombres.getText();
                direccion = this.txt_area.getText();
                Contacto objContacto = new Contacto(cedula, nombres, direccion);

                Modelos.Mod_general.listaContactos.add(objContacto);//grabar a i8mnfp info
                Modelos.Mod_general.fun_mensajeInformacion("Se registró con éxito");
                this.fun_limpiar();
                this.mostrar();
            }

        } catch (Exception e) {
            Modelos.Mod_general.fun_mensajeInformacion(e.getMessage());

        }
    }

    public void fun_limpiar() {
        this.txt_cedula.clear();
        this.txt_area.clear();
        this.txt_nombres.clear();
        //redireccionar el curso a cedsudlalañlalkasddlmkñasdlmkñasd
        this.txt_cedula.requestFocus();
    }

    public void mostrar() {

        for (Contacto object : Modelos.Mod_general.listaContactos) {
            System.out.println("" + object.getNombres());
            System.out.println("");
        }
    }

    public boolean fun_validar() {

        if (this.txt_cedula.getText().equals("")) {
            Modelos.Mod_general.fun_mensajeInformacion("Registre la cedula");
            this.txt_cedula.requestFocus();
            return false;

        }
        if (this.txt_nombres.getText().equals("")) {
            Modelos.Mod_general.fun_mensajeInformacion("Registre los nombres");
            this.txt_nombres.requestFocus();
            return false;

        }
        if (fun_val_cedula(this.txt_cedula.getText())) {
            Modelos.Mod_general.fun_mensajeInformacion("Cedula No Valida");
            this.txt_cedula.requestFocus();
            this.txt_cedula.clear();
            return false;
        }

        return true;
    }

    public boolean fun_val_cedula(String cedula) {
        int numero = 0, suma = 0, resultado = 0, tercer_dig = 0;
        String prov = "";

        if (cedula.length() == 10) {

            for (int i = 0; i < cedula.length(); i++) {

                numero = Integer.parseInt(String.valueOf(cedula.charAt(i)));

                if (i == 0 || i == 1) {
                    prov += cedula.charAt(i);
                }
                if (i == 2) {
                    tercer_dig = Integer.parseInt(String.valueOf(cedula.charAt(i)));
                }

                if (i % 2 == 0) {
                    numero = numero * 2;
                    if (numero > 9) {
                        numero = numero - 9;
                    }
                }
                suma = suma + numero;

            }

            if (Integer.parseInt(prov) <=24 || Integer.parseInt(prov) >= 1) {
                if(tercer_dig >= 0 || tercer_dig<=6){
                     if (suma % 10 != 0) {
                    resultado = 10 - (suma % 10);

                    //si el resultado es igual al ultimo digito, es ecuatoriana
                    if (resultado == numero) {
                        //es ecuatoriana
                        return false;
                    }
                } else {
                    //la cedula es ecuatoriana
                    return false;

                }
                }
               

            }

        }

        return true;
    }

    @FXML
    private void txt_cedula_KeyPressed(KeyEvent event) {
       // System.out.println(""+event.getCode());
        if(event.getCode() == KeyCode.ENTER){
            this.txt_nombres.requestFocus();
        }
    }

    @FXML
    private void txt_nombres_Ket_Pressed(KeyEvent event) {
         if(event.getCode() == KeyCode.ENTER){
            this.txt_area.requestFocus();
        }
    }

    @FXML
    private void txt_area_Key_Pressed(KeyEvent event) {
         if(event.getCode() == KeyCode.ENTER){
            this.btn_grabar.requestFocus();
        }
    }
    public void Focus_Inicial(){
        this.txt_cedula.requestFocus();
    }
}
