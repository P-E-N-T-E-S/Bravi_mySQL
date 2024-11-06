package br.com.Bravi.entidades.pj;

public class PJ {

    private String cnpj;
    private String rua;
    private String bairro;
    private int cep;
    private int numero;
    private int inscricaoEstadual;
    private String razaoSocial;

    public PJ(String cnpj, String rua, String bairro, int cep, int numero, int inscricaoEstadual, String razaoSocial) {
        this.cnpj = cnpj;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.inscricaoEstadual = inscricaoEstadual;
        this.razaoSocial = razaoSocial;
    }

    public PJ() {}

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
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

    public int getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(int inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    @Override
    public String toString() {
        return "PJ{" +
                "cnpj='" + cnpj + '\'' +
                ", rua='" + rua + '\'' +
                ", bairro='" + bairro + '\'' +
                ", cep=" + cep +
                ", numero=" + numero +
                ", inscricaoEstadual=" + inscricaoEstadual +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
