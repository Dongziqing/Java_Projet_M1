package com.gvv;

import com.gvv.controller.LoginController;
import com.gvv.controller.MainController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    protected final String LoginViewRes = "/view/login.fxml";
    protected final String MainViewRes = "/view/main.fxml";

    public Stage primaryStage;
    public LoginController loginController;
    public MainController mainController;

    public MainApp(){}

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage=primaryStage;
        loginWindow();
        primaryStage.show();
    }

    public void mainWindow(){
        try {
            primaryStage.setWidth(676);
            primaryStage.setHeight(605);
            mainController = (MainController) replaceSceneContent(MainViewRes);
            mainController.setApp(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void loginWindow(){
        try {
            primaryStage.setWidth(676);
            primaryStage.setHeight(605);
            loginController = (LoginController) replaceSceneContent(LoginViewRes);
            loginController.setApp(this);
        }catch(Exception e){
            e.printStackTrace();
        }
    }



    public Initializable replaceSceneContent(String fxml) throws Exception {
        // Load the fxml file and create a new stage for the popup.
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(fxml));
        Parent page = loader.load();
        Platform.runLater(() -> {
            primaryStage.setScene(new Scene(page));
            primaryStage.sizeToScene();
        });
        return (Initializable) loader.getController();
    }

}
