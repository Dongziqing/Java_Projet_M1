package com.gvv.controller;

import com.gvv.JavaProjetM1Application;
import com.gvv.entity.CustomerVO;
import com.gvv.entity.OrderVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.ResourceBundle;

@FXMLController
public class MainController implements Initializable {



    @FXML
    private AnchorPane root;

    @FXML
    private Tab homeTab;

    @FXML
    private Tab ordersTab;

    @FXML
    private Tab accountTab;

    @FXML
    private Tab aboutTab;

    @FXML
    public TableView<VehicleVO> hTable;
    @FXML
    public TableColumn<VehicleVO, String> hColumnBrand;
    @FXML
    public TableColumn<VehicleVO, BigDecimal> hColumnPrice;
    @FXML
    public TableColumn<VehicleVO, String> hColumnVehicleType;

    @FXML
    public TableView<OrderVO> oTable;
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

    @Autowired
    private VOServiceImpl voServiceImpl;

    private CustomerVO customerVO;

    private List<OrderVO> orderVOs;

    private List<VehicleVO> vehicleVOs;

    public void setCustomerVO() {
        /*
        Scene s = root.getScene();
        customerVO = (CustomerVO) s.getUserData();
        */
        this.customerVO = JavaProjetM1Application.customerVO;
    }

    public void setOrderVO() {
        this.orderVOs = voServiceImpl.getOrderVOsByCustomerId(customerVO.getCustomerId());
    }

    public void setVehicleVO() {
        this.vehicleVOs = voServiceImpl.getAllVehicleVOs();
    }

    public void showHome() {
        hColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        hColumnPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        hColumnVehicleType.setCellValueFactory(new PropertyValueFactory<>("vehicleTypeName"));
        hTable.setItems(FXCollections.observableList(vehicleVOs));
    }

    public void showOrders() {
        oColumnTime.setCellValueFactory(new PropertyValueFactory<>("orderCreateDate"));
        for(OrderVO vo : orderVOs){
            vo.setTotalPrise();
        }
        oColumnPrice.setCellValueFactory(new PropertyValueFactory<>("totalPrice"));
        oColumnBrand.setCellValueFactory(new PropertyValueFactory<>("brandName"));
        oColumnStatus.setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
        oColumnType.setCellValueFactory(new PropertyValueFactory<>("paymentType"));
        oTable.setItems(FXCollections.observableList(orderVOs));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCustomerVO();
        setOrderVO();
        setVehicleVO();
        showHome();
        showOrders();
    }
}
