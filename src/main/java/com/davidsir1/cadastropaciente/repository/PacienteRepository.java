package com.davidsir1.cadastropaciente.repository;

import com.davidsir1.cadastropaciente.model.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    private static PacienteRepository instancia;

    private final String arquivo = "pacientes.data";
    private ObservableList<Paciente> pacientes;

    public PacienteRepository() {
        pacientes = FXCollections.observableArrayList();
        carregarDosArquivo();
    }

    public static PacienteRepository getInstancia() {
        if (instancia == null) {
            instancia = new PacienteRepository();
        }
        return instancia;
    }

    public ObservableList<Paciente> getPacientes() {
        return pacientes;
    }

    public void adicionarPaciente(Paciente p) {
        pacientes.add(p);
        salvarNoArquivo();
    }

    private void salvarNoArquivo() {
        try {
            ObjectOutputStream saida = new ObjectOutputStream(new FileOutputStream(arquivo));
            saida.writeObject(new ArrayList<>(pacientes));
        } catch (IOException e) {
            System.err.println("Erro ao salvar pacientes: " + e.getMessage());
        }
    }

    private void carregarDosArquivo() {
        File f = new File(arquivo);
        if (!f.exists()) {
            System.out.println("Falha ao ler arquivo pacientes.data!");
            return;
        }

        try {
            ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(arquivo));
            List<Paciente> lidos = (List<Paciente>) entrada.readObject();
            pacientes.addAll(lidos);
        } catch (IOException e) {
            System.err.println("Erro ao carregar pacientes: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            /*
            Anotação de estudo

            O ClassNotFoundException checa se o JVM tenta carregar uma classe específica que não pode ser
            encontrada no projeto? Caminho da classe
             */
            System.err.println("Falha ao encontrar classe.");
        }
    }
}
