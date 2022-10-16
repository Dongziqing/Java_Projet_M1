package com.gvv;

import com.gvv.view.HelloworldView;
import de.felixroske.jfxsupport.AbstractJavaFxApplicationSupport;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaProjetM1Application extends AbstractJavaFxApplicationSupport {

    public static void main(String[] args) {
        launch(JavaProjetM1Application.class, HelloworldView.class, args);
    }

}
