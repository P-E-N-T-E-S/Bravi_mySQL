package br.com.Bravi.entidades.funcionario;

import java.util.Date;

public class Funcionario {

    private String setor;
    private String cargo;
    private String cpf;
    private String nome;
    private Date dataDeNascimento;
    private String rua;
    private String bairro;
    private int cep;
    private int numero;
    private String cpfGerente;

    public Funcionario(String setor, String cargo, String cpf, String nome, Date dataDeNascimento,
                       String rua, String bairro, int cep, int numero, String cpfGerente) {
        this.setor = setor;
        this.cargo = cargo;
        this.cpf = cpf;
        this.nome = nome;
        this.dataDeNascimento = dataDeNascimento;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.cpfGerente = cpfGerente;
    }

    public Funcionario() {}

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(Date dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCpfGerente() {
        return cpfGerente;
    }

    public void setCpfGerente(String cpfGerente) {
        this.cpfGerente = cpfGerente;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "setor='" + setor + '\'' +
                ", cargo='" + cargo + '\'' +
                ", cpf='" + cpf + '\'' +
                ", nome='" + nome + '\'' +
                ", dataDeNascimento=" + dataDeNascimento +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep=" + cep +
                ", numero=" + numero +
                ", cpfGerente='" + cpfGerente + '\'' +
                '}';
    }
}