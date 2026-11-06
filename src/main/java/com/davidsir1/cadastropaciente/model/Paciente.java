package com.davidsir1.cadastropaciente.model;

import java.io.Serializable;

public class Paciente implements Serializable {
    /*
    Isso aqui é anotação de estudo sobre Serializable

    Serializable é uma interface do pacote IO da linguagem Java e é usado para indicar que um objeto
    da classe pode ser convertido em um fluxo de bytes (serialização) e depois reconstruído de volta
    em objeto.

    A interface é completamente vazia e funciona como etiqueta, dizendo para o JVM que a classe pode ser
    convertida em bytes

    Serialização: O objeto é salvo na memória e durante a serialização, o estado do objeto é convertido
    em fluxo de bytes e pode ser salvo em um arquivo, memória ou banco de dados
     */
    private String nome;
    private int idade;
    private String cpf;
    private String tipoSanguineo;

    public Paciente(String nome, int idade, String cpf, String tipoSanguineo) {
        this.nome = nome;
        this.idade = idade;
        this.cpf = cpf;
        this.tipoSanguineo = tipoSanguineo;
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTipoSanguineo() {
        return tipoSanguineo;
    }

    public void setTipoSanguineo(String tipoSanguineo) {
        this.tipoSanguineo = tipoSanguineo;
    }

    @Override
    public String toString() {
        return nome + " - " + idade + " - " + cpf + " - " + tipoSanguineo;
    }
}
