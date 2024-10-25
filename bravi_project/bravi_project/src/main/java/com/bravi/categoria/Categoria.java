public class Fornecedor extends PJ {

    private String categoria;

    public Fornecedor(String cnpj, String rua, String bairro, int cep, int numero, int inscricaoEstadual, String razaoSocial, String categoria) {
        super(cnpj, rua, bairro, cep, numero, inscricaoEstadual, razaoSocial);
        this.categoria = categoria;
    }

    public Fornecedor() {}

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "categoria='" + categoria + '\'' +
                ", " + super.toString() +
                '}';
    }
}
