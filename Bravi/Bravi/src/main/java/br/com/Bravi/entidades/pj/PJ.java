package br.com.Bravi.entidades.pj;

public class PJ {

    private String cnpj;
    private String rua;
    private String bairro;
    private String cep;
    private String numero;
    private String numero2;
    private String inscricaoEstadual;
    private String razaoSocial;

    public PJ(String cnpj, String rua, String bairro, String cep, String numero, String numero2, String inscricaoEstadual, String razaoSocial) {
        this.cnpj = cnpj;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.numero = numero;
        this.numero2 = numero2;
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

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero2() {
        return numero2;
    }

    public void setNumero2(String numero2) {
        this.numero2 = numero2;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
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
                ", cep='" + cep + '\'' +
                ", numero='" + numero + '\'' +
                ", numero2='" + numero2 + '\'' +
                ", inscricaoEstadual='" + inscricaoEstadual + '\'' +
                ", razaoSocial='" + razaoSocial + '\'' +
                '}';
    }
}
