package com.gvv.controller;

import com.gvv.GVVApplication;
import com.gvv.entity.Country;
import com.gvv.entity.CustomerType;
import com.gvv.service.impl.VOServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Window;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class SignUpController implements Initializable {

    private VOServiceImpl voServiceImpl;

    @FXML
    private TextField userNameField;

    @FXML
    private TextField passwordField;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField addressField;

    @FXML
    private TextField phoneNumberField;

    @FXML
    private Button signUpBtn;

    @FXML
    private ChoiceBox<Country> countryCB;

    @FXML
    private ChoiceBox<CustomerType> customerTypeCB;


    public void signUp(Event event) {
        Window owner = signUpBtn.getScene().getWindow();
        if (userNameField.getText().isEmpty()
                || passwordField.getText().isEmpty()
                || firstNameField.getText().isEmpty()
                || lastNameField.getText().isEmpty()
                || emailField.getText().isEmpty()
                || addressField.getText().isEmpty()
                || phoneNumberField.getText().isEmpty()
                ) {
            GVVApplication.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "Please enter all your information.");
            return;
        }

        int customerTypeId = customerTypeCB.getSelectionModel().getSelectedItem().getCustomerTypeId();
        int countryId = countryCB.getSelectionModel().getSelectedItem().getCountryId();
        String userName = userNameField.getText().trim();
        String password = passwordField.getText().trim();
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String address = addressField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        voServiceImpl.signUp(customerTypeId, countryId, userName, password, firstName, lastName, email, address, phoneNumber);
        GVVApplication.gvvApplication.refresh("/view/login.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.voServiceImpl = GVVApplication.voServiceImpl;

        List<CustomerType> customerTypes = voServiceImpl.getCustomerTypes();
        for (CustomerType customerType : customerTypes) {
            if(customerType.getCustomerTypeId() != 1){
                customerTypeCB.getItems().add(customerType);
            }
        }
        customerTypeCB.getSelectionModel().select(0);

        List<Country> countries = voServiceImpl.getCountries();
        for (Country country : countries) {
            countryCB.getItems().add(country);
        }
        countryCB.getSelectionModel().select(0);

    }
}
