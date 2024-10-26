package br.com.Bravi.funcionario.impl;

import br.com.Bravi.funcionario.Funcionario;
import br.com.Bravi.funcionario.FuncionarioRepository;
import br.com.Bravi.funcionario.FuncionarioService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioServiceImpl(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public void inserir(Funcionario funcionario) {
        funcionarioRepository.inserir(funcionario);
    }

    @Override
    public void alterar(Funcionario funcionario) {
        funcionarioRepository.alterar(funcionario);
    }

    @Override
    public void excluir(Funcionario funcionario) {
        funcionarioRepository.excluir(funcionario);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarioRepository.listar();
    }

    @Override
    public Funcionario buscarPorCPF(String cpf) {
        return funcionarioRepository.buscarPorCPF(cpf);
    }

    @Override
    public Funcionario buscarPorSetor(String setor) {
        return funcionarioRepository.buscarPorSetor(setor);
    }

    @Override
    public Funcionario buscarPorNome(String nome) {
        return funcionarioRepository.buscarPorNome(nome);
    }

    @Override
    public Funcionario buscarPorCargo(String cargo) {
        return funcionarioRepository.buscarPorCargo(cargo);
    }
}
