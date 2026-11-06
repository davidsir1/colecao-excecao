package com.davidsir1.cadastropaciente.controller;

import com.davidsir1.cadastropaciente.exception.DadosInvalidosException;
import com.davidsir1.cadastropaciente.model.Paciente;
import com.davidsir1.cadastropaciente.repository.PacienteRepository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AdicionarPacienteController {
    @FXML TextField inNomePaciente;
    @FXML TextField inIdadePaciente;
    @FXML TextField inCpfPaciente;
    @FXML ChoiceBox<String> tipoSanguineo;

    @FXML Button btnCancelar;
    @FXML Button btnAdicionar;

    public void initialize() {
        tipoSanguineo.setItems(FXCollections.observableArrayList(
                "A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"
        ));
    }

    @FXML
    public void salvarPaciente() {
        try {
            String nome = inNomePaciente.getText();
            if (nome.isEmpty()) throw new DadosInvalidosException("Nome do paciente não pode ser vazio.");

            int idade = Integer.parseInt(inIdadePaciente.getText());
            if (idade <= 0) throw new DadosInvalidosException("A idade do paciente não pode ser negativo.");

            String cpf = inCpfPaciente.getText();
            if (cpf.length() != 11) throw new DadosInvalidosException("O CPF deve ter 11 dígitos.");
            if (!cpf.matches("\\d+")) throw new DadosInvalidosException("O CPF deve conter apenas números.");

            String sangue = tipoSanguineo.getValue();
            if (sangue == null) throw new DadosInvalidosException("Selecione o tipo sanguineo.");


            Paciente p = new Paciente(nome, idade, cpf, sangue);
            PacienteRepository.getInstancia().adicionarPaciente(p);

            exibirAlerta(Alert.AlertType.CONFIRMATION, "Sucesso", "Paciente cadastrado!");

        } catch (DadosInvalidosException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Dados Inválidos", e.getMessage());
        } catch (NumberFormatException e) {
            exibirAlerta(Alert.AlertType.ERROR, "Formatação", e.getMessage());
        }
    }

    @FXML
    public void cancelar() {
        fecharJanela();
    }

    public void fecharJanela() {
        Stage stage = (Stage) inNomePaciente.getScene().getWindow();
        stage.close();
    }

    public void exibirAlerta(Alert.AlertType tipoAlerta, String titulo, String messagem) {
        Alert alerta = new Alert(tipoAlerta);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(messagem);
        alerta.showAndWait();
    }
}
