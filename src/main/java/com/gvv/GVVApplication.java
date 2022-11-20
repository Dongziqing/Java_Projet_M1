package com.gvv;

import com.gvv.entity.CustomerVO;
import com.gvv.entity.VehicleVO;
import com.gvv.service.impl.VOServiceImpl;
import com.gvv.view.CustomLoadingView;
import com.gvv.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.Objects;

@SpringBootApplication
@MapperScan("com.gvv.mapper")
public class GVVApplication extends AbstractJavaFxApplicationSupport {

    public static CustomerVO customerVO;

    public static VehicleVO vehicleVO;

    public static VOServiceImpl voServiceImpl;

    public static  GVVApplication gvvApplication = new GVVApplication();

    public static void infoBox(String infoMessage, String headerText, String title) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(infoMessage);
        alert.setTitle(title);
        alert.setHeaderText(headerText);
        alert.showAndWait();
    }

    public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public void refresh() {
        Stage st = GVVApplication.getStage();
        try {
            AnchorPane pane = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/main.fxml")));
            st.setScene(new Scene(pane));
            st.centerOnScreen();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        launch(GVVApplication.class, LoginView.class, new CustomLoadingView() ,args);
    }

}
