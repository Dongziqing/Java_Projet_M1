package com.gvv;

import com.gvv.view.CustomLoadingView;
import com.gvv.view.LoginView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gvv.mapper")
public class JavaProjetM1Application extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(JavaProjetM1Application.class, LoginView.class, new CustomLoadingView() ,args);
    }

}
