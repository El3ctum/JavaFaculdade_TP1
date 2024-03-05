package br.edu.infnet.davivieira.tp1.model.domain;

public class Funcionario {

    private int cadastro;
    private String nome;
    private float salario;
    private boolean especialista;
    private Endereco endereco;

    public Funcionario() {
        this.setCadastro(9098);
        this.setNome("Davi Vieira");
        this.setSalario(500);
        this.setEspecialista(true);
        this.setEndereco(new Endereco("82840220", "Rua Rio Japurá", "Casa", "Bairro Alto", "Curitiba", "UF"));
    }

    public Funcionario(int cadastro) {
        this();
        this.setCadastro(123);
    }

    public Funcionario(Endereco endereco) {
        this();
        this.setEndereco(endereco);
    }
    public float calcularSalario(){

        float salarioTotal = salario + (especialista ? 1250 : 750);

        return indicativoGratificacao() ? salarioTotal + 1000 : salarioTotal;
    }

    public boolean indicativoGratificacao() {
        return salario >= 5000 && especialista;
    }

    @Override
    public String toString() {
        return "Funcionario: " + cadastro + " - " + nome + " - " + salario + " - " + especialista + " - " + endereco;
    }

    public int getCadastro() {
        return cadastro;
    }
    public void setCadastro(int cadastro) {
        this.cadastro = cadastro;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public float getSalario() {
        return salario;
    }
    public void setSalario(float salario) {
        this.salario = salario;
    }
    public boolean isEspecialista() {
        return especialista;
    }
    public void setEspecialista(boolean especialista) {
        this.especialista = especialista;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
