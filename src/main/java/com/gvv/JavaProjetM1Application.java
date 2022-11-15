package com.gvv;

import com.gvv.entity.CustomerVO;
import com.gvv.view.CustomLoadingView;
import com.gvv.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import javafx.scene.control.Alert;
import javafx.stage.Window;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gvv.mapper")
public class JavaProjetM1Application extends AbstractJavaFxApplicationSupport {

    public static CustomerVO customerVO;

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
    public static void main(String[] args) {
        launch(JavaProjetM1Application.class, LoginView.class, new CustomLoadingView() ,args);
    }

}
