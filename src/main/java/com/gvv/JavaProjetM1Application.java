package com.gvv;


import javafx.application.Application;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.gvv.mapper")
public class JavaProjetM1Application implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(JavaProjetM1Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Application.launch(MainApp.class, args);
    }
}
