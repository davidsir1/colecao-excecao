package com.davidsir1.cadastropaciente;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
                HelloApplication.class.getResource("listar-paciente-view.fxml")
        );
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Cadastro de Pacientes");
        stage.setScene(scene);
        stage.show();
    }
}
