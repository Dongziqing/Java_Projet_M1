package com.gvv.controller;

import com.gvv.JavaProjetM1Application;
import com.gvv.entity.CustomerVO;
import com.gvv.service.impl.VOServiceImpl;
import com.gvv.view.MainView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import javafx.scene.control.TextField;
import org.springframework.boot.SpringApplication;

import java.io.IOException;

@FXMLController
public class LoginController {
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginBtn;

    @Autowired
    private VOServiceImpl voServiceImpl;

    private CustomerVO customerVO;

    @FXML
    private void login(Event event) {
        Window owner = loginBtn.getScene().getWindow();

        if(userNameField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your userName");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String userName = userNameField.getText();
        String password = passwordField.getText();

        customerVO = voServiceImpl.Login(userName, password);
        if(customerVO == null) {
            infoBox("Please enter correct Email and Password", null, "Failed");
        }else {
            /*
            Scene s = loginBtn.getScene();
            s.setUserData(customerVO);
            */
            JavaProjetM1Application.customerVO = customerVO;
            JavaProjetM1Application.showView(MainView.class);
            /*
            try{
                AnchorPane page = FXMLLoader.load(getClass().getResource("/view/main.fxml"));
                Scene newScene = new Scene(page);
                Stage stage = new Stage();
                stage.setScene(newScene);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            */
        }
    }

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }



}
