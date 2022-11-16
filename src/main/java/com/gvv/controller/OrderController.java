package com.gvv.controller;

import com.gvv.JavaProjetM1Application;
import com.gvv.entity.CustomerVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import com.gvv.view.MainView;
import de.felixroske.jfxsupport.FXMLController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;

import java.net.URL;
import java.util.ResourceBundle;

@FXMLController
public class OrderController implements Initializable {

    private VehicleVO vehicleVO;
    private CustomerVO customerVO;

    @Autowired
    private VOServiceImpl voServiceImpl;

    @FXML
    private Label CustomerInfoField;

    @FXML
    private Label VehicleInfoField;

    @FXML
    private AnchorPane paymentPane;

    @FXML
    private Button payBtn;

    @FXML
    private Button cancelBtn;


    public void cancel() {
        JavaProjetM1Application.showView(MainView.class);
    }

    public void pay() {
        voServiceImpl.createOrder(customerVO.getCustomerId(),vehicleVO.getVehicleId(), "0");
        cancel();
    }

    public void showCustomerInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(customerVO.getFirstName()).append(" ").append(customerVO.getLastName()).append("\n");
        sb.append(customerVO.getPhoneNumber()).append("\n");
        sb.append(customerVO.getEmail()).append("\n");
        sb.append(customerVO.getAddress());
        CustomerInfoField.setText(sb.toString());
    }

    public void showPayType() {
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton();
        RadioButton rb2 = new RadioButton();
        rb1.setToggleGroup(toggleGroup);
        rb2.setToggleGroup(toggleGroup);

    }
    public void showVehicleInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(vehicleVO.getInfo()).append("\n");
        sb.append("price with tax: ").append(voServiceImpl.getVehiclePriceWithTax(vehicleVO.getPrice(), customerVO.getTaxRate()));
        VehicleInfoField.setText(sb.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.vehicleVO = JavaProjetM1Application.vehicleVO;
        this.customerVO = JavaProjetM1Application.customerVO;
        showCustomerInfo();
        showPayType();
        showVehicleInfo();
    }
}
