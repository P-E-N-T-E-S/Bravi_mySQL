package br.com.Bravi.entidades.funcionario;

import br.com.Bravi.entidades.setor.Setor;
import java.util.List;

public interface FuncionarioService {
    void inserir(Funcionario funcionario);
    void alterar(Funcionario funcionario, String filtro, String valor);
    void excluir(Funcionario funcionario);
    List<Funcionario> listar();
    Funcionario buscarPorCPF(String cpf);
    Funcionario buscarPorSetor(Setor setor);
    Funcionario buscarPorNome(String nome);
    Funcionario buscarPorCargo(String cargo);
    Setor buscarSetorPorNome(String nome);
}
