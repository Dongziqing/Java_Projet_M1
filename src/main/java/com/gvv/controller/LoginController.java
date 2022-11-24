package com.gvv.controller;

import com.gvv.GVVApplication;
import com.gvv.entity.CustomerVO;
import com.gvv.service.impl.VOServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.stage.Window;
import org.springframework.beans.factory.annotation.Autowired;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

@FXMLController
public class LoginController implements Initializable {
    @FXML
    private TextField userNameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button loginBtn;

    @Autowired
    private VOServiceImpl voServiceImpl;

    @FXML
    private void login(Event event) {
        Window owner = loginBtn.getScene().getWindow();

        if(userNameField.getText().isEmpty()) {
            GVVApplication.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter your userName");
            return;
        }
        if (passwordField.getText().isEmpty()) {
            GVVApplication.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter a password");
            return;
        }

        String userName = userNameField.getText();
        String password = passwordField.getText();

        CustomerVO customerVO = voServiceImpl.login(userName, password);
        if(customerVO == null) {
            GVVApplication.infoBox("Please enter correct Email and Password", null, "Failed");
        }else {
            /*
            Scene s = loginBtn.getScene();
            s.setUserData(customerVO);
            */
            GVVApplication.customerVO = customerVO;
            GVVApplication.voServiceImpl = voServiceImpl;
            if(customerVO.getCustomerTypeName().equals("admin")) {
                GVVApplication.gvvApplication.refresh("/view/admin.fxml");
            }else {
                GVVApplication.gvvApplication.refresh("/view/main.fxml");
            }

            /*
            s.setWidth(800);
            s.setHeight(628);
            s.centerOnScreen();
            GVVApplication.showView(MainView.class);
            */

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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GVVApplication.voServiceImpl = this.voServiceImpl;
    }
}
