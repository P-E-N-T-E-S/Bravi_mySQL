package br.com.Bravi.entidades.cliente.impl;

import br.com.Bravi.entidades.cliente.Cliente;
import br.com.Bravi.entidades.cliente.ClienteRepository;
import br.com.Bravi.entidades.cliente.ClienteService;
import br.com.Bravi.exceptions.ClienteNaoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public void inserir(Cliente cliente) {
        clienteRepository.inserir(cliente);
    }

    @Override
    public void alterar(Cliente cliente) {
        if (clienteRepository.buscarPorCNPJ(cliente.getCnpj()) == null) {
            throw new ClienteNaoEncontradoException("Cliente com CNPJ " + cliente.getCnpj() + " não encontrado");
        }
        clienteRepository.alterar(cliente);
    }

    @Override
    public void excluir(String cnpj) {
        if (clienteRepository.buscarPorCNPJ(cnpj) == null) {
            throw new ClienteNaoEncontradoException("Cliente com CNPJ " + cnpj + " não encontrado");
        }
        clienteRepository.excluir(cnpj);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.listar();
    }

    @Override
    public Cliente buscarPorCNPJ(String cnpj) {
        Cliente cliente = clienteRepository.buscarPorCNPJ(cnpj);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("Cliente com CNPJ " + cnpj + " não encontrado");
        }
        return cliente;
    }
}
