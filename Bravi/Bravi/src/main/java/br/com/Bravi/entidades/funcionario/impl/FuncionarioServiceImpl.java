package br.com.Bravi.entidades.funcionario.impl;

import br.com.Bravi.entidades.funcionario.Funcionario;
import br.com.Bravi.entidades.funcionario.FuncionarioRepository;
import br.com.Bravi.entidades.funcionario.FuncionarioService;
import br.com.Bravi.entidades.setor.Setor;
import br.com.Bravi.exceptions.FuncionarioNaoEncontradoException;
import br.com.Bravi.exceptions.FiltroNaoDisponivelException;
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
    public void alterar(Funcionario funcionario, String filtro, String valor) {
        Funcionario funcionarioExistente = buscarFuncionarioPorFiltro(filtro, valor);
        if (funcionarioExistente == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado.");
        }
        funcionarioRepository.alterar(funcionario);
    }

    @Override
    public void excluir(Funcionario funcionario) {
        Funcionario funcionarioExistente = funcionarioRepository.buscarPorCPF(funcionario.getCpf());
        if (funcionarioExistente == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário não encontrado.");
        }
        funcionarioRepository.excluir(funcionario);
    }

    @Override
    public List<Funcionario> listar() {
        return funcionarioRepository.listar();
    }

    @Override
    public Funcionario buscarPorCPF(String cpf) {
        Funcionario funcionario = funcionarioRepository.buscarPorCPF(cpf);
        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário com CPF " + cpf + " não encontrado.");
        }
        return funcionario;
    }

    @Override
    public Funcionario buscarPorSetor(Setor setor) {
        Funcionario funcionario = funcionarioRepository.buscarPorSetor(setor);
        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException("Nenhum funcionário encontrado no setor.");
        }
        return funcionario;
    }

    @Override
    public Funcionario buscarPorNome(String nome) {
        Funcionario funcionario = funcionarioRepository.buscarPorNome(nome);
        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário com nome " + nome + " não encontrado.");
        }
        return funcionario;
    }

    @Override
    public Funcionario buscarPorCargo(String cargo) {
        Funcionario funcionario = funcionarioRepository.buscarPorCargo(cargo);
        if (funcionario == null) {
            throw new FuncionarioNaoEncontradoException("Funcionário com cargo " + cargo + " não encontrado.");
        }
        return funcionario;
    }

    @Override
    public Setor buscarSetorPorNome(String nome) {
        Setor setor = funcionarioRepository.buscarSetorPorNome(nome);
        if (setor == null) {
            throw new FuncionarioNaoEncontradoException("Setor com nome " + nome + " não encontrado.");
        }
        return setor;
    }

    public Funcionario buscarFuncionarioPorFiltro(String filtro, String valor) {
        switch (filtro) {
            case "cpf":
                return buscarPorCPF(valor);
            case "setor":
                return buscarPorSetor(new Setor(Integer.parseInt(valor), valor));
            case "nome":
                return buscarPorNome(valor);
            case "cargo":
                return buscarPorCargo(valor);
            default:
                throw new FiltroNaoDisponivelException("Filtro " + filtro + " não disponível");
        }
    }
}
