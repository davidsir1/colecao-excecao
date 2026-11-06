package com.davidsir1.cadastropaciente.controller;

import com.davidsir1.cadastropaciente.HelloApplication;
import com.davidsir1.cadastropaciente.model.Paciente;
import com.davidsir1.cadastropaciente.repository.PacienteRepository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import java.io.IOException;

public class ListaPacienteController {
    @FXML private ListView<Paciente> listaPaciente;

    public void initialize() {
        listaPaciente.setItems(PacienteRepository.getInstancia().getPacientes());
    }

    @FXML
    public void abrirTelaAdicionarPaciente() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    HelloApplication.class.getResource("adicionar-paciente-view.fxml")
            );
            Stage stage = new Stage();
            stage.setTitle("Adicionar Paciente");
            stage.setScene(new Scene(fxmlLoader.load()));
            stage.show();
        } catch (IOException | IllegalStateException e) {
            System.err.println("Erro ao abrir a tela de adicionar pacientes: " + e.getMessage());
        }
    }
}
