/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Contacto;
import Modelos.Telefono;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXMLTelefonosController implements Initializable {

    @FXML
    private Button btn_cerrar;
    @FXML
    private ComboBox<Contacto> cbo_contactos; //cambiar el cosososos
    @FXML
    private TextField txt_numero;
    @FXML
    private TextField txt_operadora;
    @FXML
    private Button btn_grabar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.fun_cargarComboContactos();
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
    private void acc_clickComboContacto(ActionEvent event) {
        try {
            //    System.out.println(""+ this.cbo_contactos.getSelectionModel().getSelectedItem().getNombres());
        } catch (Exception e) {
        }
    }

    public void fun_cargarComboContactos() {
        try {
            this.cbo_contactos.getItems().addAll(Modelos.Mod_general.listaContactos);
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_grabar(ActionEvent event) {
        try {
            if (this.fun_validar()) {
                Telefono objTelefono = new Telefono(this.txt_operadora.getText(), this.txt_numero.getText());
                this.cbo_contactos.getSelectionModel().getSelectedItem().addListatelefonos(objTelefono);

                Modelos.Mod_general.fun_mensajeInformacion("Se registró con éxito");
                this.fun_limpiar();

                /*
                System.out.println("Nombre: "+ this.cbo_contactos.getSelectionModel().getSelectedItem().getNombres());
                for (Telefono object : this.cbo_contactos.getSelectionModel().getSelectedItem().getListatelefonos()) {
                    System.out.println("operadora: " + object.getOperadora());
                System.out.println("numero: " + object.getNumero());
                }*/
            }
        } catch (Exception e) {
        }
    }

    public boolean fun_validar() {
        if (this.txt_numero.getText().equals("")) {
            Modelos.Mod_general.fun_mensajeInformacion("Registre el numero de telefono");
            this.txt_numero.requestFocus();
            return false;

        }
        if (this.txt_operadora.getText().equals("")) {
            Modelos.Mod_general.fun_mensajeInformacion("Registre la operadora");
            this.txt_operadora.requestFocus();
            return false;

        }
        return true;
    }

    public void fun_limpiar() {
        this.txt_numero.clear();
        this.txt_operadora.clear();

        //redireccionar el curso a cedsudlalañlalkasddlmkñasdlmkñasd
        this.txt_numero.requestFocus();
    }

    @FXML
    private void txt_numero_Key_Pressed(KeyEvent event) {
        try {
            if (event.getCode() == KeyCode.ENTER) {
                this.txt_operadora.requestFocus();
            }
        } catch (Exception e) {
        }

    }

    @FXML
    private void txt_operadora_Key_Pressed(KeyEvent event) {
        try {
            if (event.getCode() == KeyCode.ENTER) {
                this.btn_grabar.requestFocus();
            }
        } catch (Exception e) {
        }

    }

    @FXML
    private void cbo_contactos_On_Key_Pressed(KeyEvent event) {
        System.out.println(""+event.getCode());
    }

 

}
