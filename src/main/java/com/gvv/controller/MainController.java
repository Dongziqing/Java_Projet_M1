package com.gvv.controller;

import com.gvv.JavaProjetM1Application;
import com.gvv.entity.CustomerVO;
import com.gvv.entity.OrderVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import de.felixroske.jfxsupport.FXMLController;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.collections.FXCollections;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.net.URL;
import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
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
    public Button hSearchBtn;

    @FXML
    public TextField hTextField;

    @FXML
    public TableColumn<VehicleVO, String> hColumnBrand;
    @FXML
    public TableColumn<VehicleVO, String> hColumnInfo;
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

    @FXML
    public Label acTextFiled;

    @FXML
    public Label aTextFiled;

    @FXML
    public ImageView aImage1;

    @Autowired
    private VOServiceImpl voServiceImpl;

    private CustomerVO customerVO;

    private List<OrderVO> orderVOs;

    private List<VehicleVO> vehicleVOs;

    public void hSearch(Event event){
        String s = hTextField.getText();
        if (s.isEmpty()){
            vehicleVOs = voServiceImpl.getAllVehicleVOs();
        }else {
            vehicleVOs = voServiceImpl.getVehicleVOsWithCondition(s);
        }
        showHome();
    }

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
        hColumnInfo.setCellValueFactory(new PropertyValueFactory<>("info"));
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

    public void showAccount() {
        StringBuffer sb = new StringBuffer();
        sb.append("Username: ").append(this.customerVO.getUserName()).append("\n");
        sb.append("Name: ").append(this.customerVO.getFirstName()).append(" ").append(this.customerVO.getLastName()).append("\n");
        sb.append("Address: ").append(this.customerVO.getAddress()).append("\n");
        sb.append("Email: ").append(this.customerVO.getEmail()).append("\n");
        sb.append("Customer Type: ").append(this.customerVO.getCustomerTypeName());
        acTextFiled.setText(sb.toString());
    }

    public void showAbout() {
        aTextFiled.setText("GVV version 1.0 \n" + "Created by CHEN Zhoujing and DONG Ziqing.");
        aImage1.setImage(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/images/czj.png"))));
    }

    /*
    @FXML
    public WebView iWebView;
    public void showIndex() {

        WebEngine we = iWebView.getEngine();
        String mainUrl = Objects.requireNonNull(getClass().getResource("/html/index.html")).toExternalForm();
        we.load(mainUrl);
    }
    */



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCustomerVO();
        setOrderVO();
        setVehicleVO();
        showHome();
        showOrders();
        showAccount();
        showAbout();
    }
}
