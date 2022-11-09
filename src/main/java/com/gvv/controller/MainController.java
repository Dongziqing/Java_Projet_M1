package com.gvv.controller;

import com.gvv.entity.CustomerVO;
import de.felixroske.jfxsupport.FXMLController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

@FXMLController
public class MainController {
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

    private CustomerVO customerVO;

    public void getData(ActionEvent event) {
        Scene s = root.getScene();
        this.customerVO = (CustomerVO) s.getUserData();
    }

}
