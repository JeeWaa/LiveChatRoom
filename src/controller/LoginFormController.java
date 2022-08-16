package controller;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    public JFXTextField txtUsername;
    public JFXPasswordField txtPassword;

    public void login(MouseEvent mouseEvent) throws IOException {
        Parent root = null;
        switch (txtUsername.getText()+txtPassword.getText()) {
            case "amal1234":
                root = FXMLLoader.load(this.getClass().getResource("../view/ChatRoom01Form.fxml"));
                break;
            case "kamal1234":
                root = FXMLLoader.load(this.getClass().getResource("../view/ChatRoom02Form.fxml"));
                break;
            case "nayana1234":
                root = FXMLLoader.load(this.getClass().getResource("../view/ChatRoom03Form.fxml"));
                break;
        }
        if (root != null) {
            Parent load = root;
            Scene scene = new Scene(load);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
    }
}
