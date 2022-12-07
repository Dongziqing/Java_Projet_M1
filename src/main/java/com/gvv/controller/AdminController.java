package com.gvv.controller;

import com.gvv.GVVApplication;
import com.gvv.entity.OrderVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Window;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class AdminController implements Initializable {

    private VOServiceImpl voServiceImpl;

    private List<OrderVO> orderVOs;

    private int maxOrderId = -1;

    @FXML
    public TextField orderIdField;

    @FXML
    public ChoiceBox<String> orderStatusCB;

    @FXML
    public Button setNewStatusBtn;

    @FXML
    public TableView<OrderVO> oTable;

    @FXML
    public TableColumn<OrderVO, Integer> oColumnId;
    @FXML
    public TableColumn<OrderVO, Timestamp> oColumnTime;
    @FXML
    public TableColumn<OrderVO, BigDecimal> oColumnPrice;
    @FXML
    public TableColumn<OrderVO, String> oColumnBrand;
    @FXML
    public TableColumn<OrderVO, Boolean> oColumnStatus;
    @FXML
    public TableColumn<OrderVO, String> oColumnType;
    @FXML
    public TableColumn<OrderVO, String> oColumnUserName;

    public void setChoiceBox() {
        orderStatusCB.getItems().addAll("In progress", "Validated", "Delivered");
        orderStatusCB.getSelectionModel().select(0);
    }

    public void setOrderVO() {
        this.orderVOs = voServiceImpl.getAllOrderVOs();
        for(OrderVO vo : orderVOs) {
            maxOrderId = Math.max(vo.getOrderId(), maxOrderId);
        }
    }

    public void showOrders() {
        oTable.setRowFactory(tv -> {
            TableRow<OrderVO> row = new TableRow<>();
            row.setOnMouseClicked(event -> {
                if (event.getClickCount() == 2 && (! row.isEmpty())) {
                    orderIdField.setText(row.getItem().getOrderId().toString());
                }
            });
            return row;
        });
        oColumnId.setCellValueFactory(new PropertyValueFactory<>("orderId"));
        oColumnTime.setCellValueFactory(new PropertyValueFactory<>("orderCreateDate"));
        oColumnPrice.setCellValueFactory(new PropertyValueFactory<>("salePrice"));
        oColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        oColumnStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatusName"));
        oColumnType.setCellValueFactory(new PropertyValueFactory<>("paymentTypeName"));
        oColumnUserName.setCellValueFactory(new PropertyValueFactory<>("userName"));
        oTable.setItems(FXCollections.observableList(orderVOs));
    }

    public boolean isNumeric(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public void setNewStatus() {
        Window owner = setNewStatusBtn.getScene().getWindow();
        if(orderIdField.getText().trim().isEmpty() || !isNumeric(orderIdField.getText().trim()) || Integer.parseInt(orderIdField.getText().trim()) > maxOrderId) {
            GVVApplication.showAlert(Alert.AlertType.ERROR, owner, "Form Error!",
                    "The information entered is faulty.");
        }
        int orderId = Integer.parseInt(orderIdField.getText().trim());
        String orderStatusName = orderStatusCB.getValue();
        String newStatus = null;
        switch (orderStatusName) {
            case "In progress":
                newStatus = "0";
                break;
            case "Validated":
                newStatus = "1";
                break;
            case "Delivered":
                newStatus = "2";
                break;
        }
        voServiceImpl.updateOrderStatus(orderId, newStatus);
        GVVApplication.gvvApplication.refresh("/view/admin.fxml");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.voServiceImpl = GVVApplication.voServiceImpl;
        setChoiceBox();
        setOrderVO();
        showOrders();
    }
}