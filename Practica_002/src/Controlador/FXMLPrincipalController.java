/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author e_d_d
 */
public class FXMLPrincipalController implements Initializable {

    @FXML
    private Button btn_registrocontacto;
    @FXML
    private Button btn_listarContactos;
    @FXML
    private Button btn_reegistrarTelefonos;
    @FXML
    private Button btn_cerrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void acc_abrirPantallaContactos(ActionEvent event) {
        try {
            String formulario = "/Vistas/FXMLRegistroContacto.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXMLRegistroContactoController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            controlador.Focus_Inicial();
            stage.show();
            
            //cerrar el fomrulario
            stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
             Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
        
                    
                    
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_abrirPantallaLista(ActionEvent event) {
        try {
            String formulario = "/Vistas/FXMLlistar.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXMLlistarController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
            //cerrar el fomrulario
            stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
             Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
        
                    
                    
        } catch (Exception e) {
        }
        
    }

    @FXML
    private void acc_abrirPantallaTelefonos(ActionEvent event) {
        try {
            String formulario = "/Vistas/FXMLTelefonos.fxml";
            FXMLLoader loader = new FXMLLoader(getClass().getResource(formulario));
            Parent root = loader.load();
            //INDICAR CON QUE CONTROLADOR ESTÁ TRBAJANDO        
            FXMLTelefonosController controlador = loader.getController();
            
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            
            //cerrar el fomrulario
            stage.setOnCloseRequest(eh->controlador.cerrarFormulario());
             Stage myStage = (Stage)this.btn_cerrar.getScene().getWindow();
                    
            myStage.close();
        
                    
                    
        } catch (Exception e) {
        }
    }

    @FXML
    private void acc_cerrarPantalla(ActionEvent event) {
        try {
            System.exit(0);
            
        } catch (Exception e) {
        }
    }
    
}
