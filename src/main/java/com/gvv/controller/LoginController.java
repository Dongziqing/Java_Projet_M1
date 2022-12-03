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

    @FXML
    private Button signUpBtn;

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

        String userName = userNameField.getText().trim();
        String password = passwordField.getText().trim();

        CustomerVO customerVO = voServiceImpl.login(userName, password);
        if(customerVO == null) {
            GVVApplication.infoBox("Please enter correct UserName and Password", null, "Failed");
        }else {
            /*
            Scene s = loginBtn.getScene();
            s.setUserData(customerVO);
            */
            GVVApplication.customerVO = customerVO;
            if(customerVO.getCustomerTypeName().equals("admin")) {
                GVVApplication.gvvApplication.refresh("/view/admin.fxml");
            }else {
                GVVApplication.gvvApplication.refresh("/view/main.fxml");
            }

        }
    }

    @FXML
    private void signUp(Event event) {
        GVVApplication.gvvApplication.refresh("/view/signup.fxml");
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        GVVApplication.voServiceImpl = this.voServiceImpl;
    }
}
