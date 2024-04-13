/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import Modelos.Contacto;
import Modelos.Telefono;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXMLlistarController implements Initializable {

    @FXML
    private Button btn_cerrar;
    @FXML
    private ComboBox<Contacto> cbo_contactos;
    @FXML
    private TableView<Telefono> tv_detalle;
    @FXML
    private TableColumn<?, ?> col_numero;
    @FXML
    private TableColumn<?, ?> col_operadora;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //asosciar las columnas del tableview con los atributos de mi objetto
        
        this.col_numero.setCellValueFactory(new PropertyValueFactory("numero"));
        this.col_operadora.setCellValueFactory(new PropertyValueFactory("operadora"));
        
        //cargar el combobox
        this.fun_cargarCombo();
        
        
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
            Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();

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
            Object evento = event.getSource();
            if(evento.equals(this.cbo_contactos)){ //si hico clic en el combo box
                this.fun_MostrarDetalleContacto(this.cbo_contactos.getSelectionModel().getSelectedItem().getListatelefonos());
                
            }
        } catch (Exception e) {
        }
    
        
    }
    
    
    public void fun_MostrarDetalleContacto(ArrayList<Telefono> detallecontactos){
        try {
            //limpiar
            this.tv_detalle.getItems().clear();
            //cargar el tableview con el arraylist
            this.tv_detalle.getItems().addAll(detallecontactos);
        } catch (Exception e) {
        }
    }
    
    public void fun_cargarCombo(){
        try {
            this.cbo_contactos.getItems().addAll(Modelos.Mod_general.listaContactos);
        } catch (Exception e) {
        }
    }
}
