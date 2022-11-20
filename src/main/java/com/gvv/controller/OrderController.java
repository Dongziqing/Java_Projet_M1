package com.gvv.controller;

import com.gvv.GVVApplication;
import com.gvv.entity.CustomerVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Collection;
import java.util.ResourceBundle;

@FXMLController
public class OrderController implements Initializable {

    private VehicleVO vehicleVO;
    private CustomerVO customerVO;


    private VOServiceImpl voServiceImpl;

    @FXML
    private Label CustomerInfoField;

    @FXML
    private Label VehicleInfoField;

    @FXML
    private VBox vBox;

    @FXML
    private RadioButton creditRBtn;

    @FXML
    private RadioButton cashRBtn;

    @FXML
    private Button payBtn;

    @FXML
    private Button cancelBtn;


    public void cancel() {
        Stage s = (Stage)cancelBtn.getScene().getWindow();
        s.close();
    }

    public void pay() {
        String paymentType = null;
        if(creditRBtn.isSelected()) {
            paymentType = "0";
        }
        else if(cashRBtn.isSelected()) {
            paymentType = "1";
        }
        voServiceImpl.createOrder(customerVO.getCustomerId(),vehicleVO.getVehicleId(), paymentType);
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
        creditRBtn.setToggleGroup(toggleGroup);
        cashRBtn.setToggleGroup(toggleGroup);
    }
    public void showVehicleInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(vehicleVO.getInfo()).append("\n");
        sb.append("price with tax: ").append(voServiceImpl.getVehiclePriceWithTax(vehicleVO.getPrice(), customerVO.getTaxRate()));
        VehicleInfoField.setText(sb.toString());
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.voServiceImpl = GVVApplication.voServiceImpl;
        this.vehicleVO = GVVApplication.vehicleVO;
        this.customerVO = GVVApplication.customerVO;
        showCustomerInfo();
        showPayType();
        showVehicleInfo();
    }
}
