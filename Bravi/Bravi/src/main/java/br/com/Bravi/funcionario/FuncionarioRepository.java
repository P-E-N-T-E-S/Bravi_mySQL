package br.com.Bravi.funcionario;

import java.util.List;

public interface FuncionarioRepository {
    void inserir(Funcionario funcionario);
    void alterar(Funcionario funcionario);
    void excluir(Funcionario funcionario);
    List<Funcionario> listar();
    Funcionario buscarPorCPF(String cpf);
    Funcionario buscarPorSetor(String setor);
    Funcionario buscarPorNome(String nome);
    Funcionario buscarPorCargo(String cargo);
}
