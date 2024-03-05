package br.edu.infnet.davivieira.tp1.model.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Empresa {
    private String cnpj;
    private String razaoSocial;
    private String nomeFantasia;
    private Endereco endereco;
    private List<Funcionario> funcionarios;

    public Empresa() {
        this.setCnpj("80937287000110");
        this.setNomeFantasia("Empresa Teste LTDA.");
        this.setNomeFantasia("Testinhos");
        this.setEndereco(new Endereco());
        this.setFuncionarios(new ArrayList<Funcionario>(Arrays.asList(new Funcionario())));
    }

    public Empresa(String razaoSocial) {
        this();
        this.setRazaoSocial(razaoSocial);
    }

    public Empresa(String razaoSocial, String nomeFantasia) {
        this(razaoSocial);
        this.setNomeFantasia(nomeFantasia);
    }

    public Empresa(String razaoSocial, String nomeFantasia, Endereco endereco) {
        this(razaoSocial, nomeFantasia);
        this.setEndereco(endereco);
    }

    @Override
    public String toString() {
        return "Empresa: " + nomeFantasia + " - " + razaoSocial + " - " + endereco + " - " + funcionarios;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }
}
