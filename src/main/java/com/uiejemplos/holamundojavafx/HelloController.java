package com.uiejemplos.holamundojavafx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.util.Optional;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick(ActionEvent event) {
        welcomeText.setText("Welcome to JavaFX Application!");
        Alert msgBox =
            new Alert(Alert.AlertType.CONFIRMATION);
        msgBox.setTitle("Salir");

        msgBox.setHeaderText(null);
        msgBox.setContentText("¿Realmente quiere salir?");
        Image icon = new Image("file:src/main/resources/com/uiejemplos/holamundojavafx/privcrypt.jpg"); // Asegúrate de que la ruta sea correcta
        ImageView imageView = new ImageView(icon);
        msgBox.setGraphic(imageView);


        //msgBox.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        //msgBox.getDialogPane().getStyleClass().add("dialog-title");
        msgBox.getDialogPane().getStylesheets().add(getClass().getResource("alertStyle.css").toExternalForm());
        //msgBox.getDialogPane().getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
        //msgBox.getDialogPane().getStyleClass().add("dialog-title");
        Optional<ButtonType> result = msgBox.showAndWait();
        if (result.isPresent()) {
            if (result.get() == ButtonType.OK) {
                // El usuario hizo clic en OK
                System.out.println("El usuario eligió OK.");
                Node source = (Node) event.getSource();
                Stage stage = (Stage) source.getScene().getWindow();

                // Cerrar el Stage
                stage.close();
            } else if (result.get()==ButtonType.CANCEL){
                // El usuario hizo clic en Cancelar o cerró la ventana
                System.out.println("El usuario eligió Cancelar.");
            }
        } else {
            // No hay valor presente (aunque en este contexto esto no debería ocurrir)
            System.out.println("No se recibió respuesta del usuario.");
        }
    }
}