package br.com.Bravi.cliente.impl;

import br.com.Bravi.cliente.Cliente;
import br.com.Bravi.cliente.ClienteRepository;
import br.com.Bravi.cliente.ClienteService;
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
        clienteRepository.alterar(cliente);
    }

    @Override
    public void excluir(String cnpj) {
        clienteRepository.excluir(cnpj);
    }

    @Override
    public List<Cliente> listar() {
        return clienteRepository.listar();
    }

    @Override
    public Cliente buscarPorCNPJ(String cnpj) {
        return clienteRepository.buscarPorCNPJ(cnpj);
    }
}
