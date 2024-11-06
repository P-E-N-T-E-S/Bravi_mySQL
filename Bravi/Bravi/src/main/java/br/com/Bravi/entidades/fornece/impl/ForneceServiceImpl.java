package br.com.Bravi.entidades.fornece.impl;

import br.com.Bravi.entidades.fornece.Fornece;
import br.com.Bravi.entidades.fornece.ForneceRepository;
import br.com.Bravi.entidades.fornece.ForneceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForneceServiceImpl implements ForneceService {

    private final ForneceRepository forneceRepository;

    public ForneceServiceImpl(ForneceRepository forneceRepository) {
        this.forneceRepository = forneceRepository;
    }

    @Override
    public void inserirFornece(Fornece fornece) {
        forneceRepository.inserir(fornece);
    }

    @Override
    public void atualizarFornece(Fornece fornece) {
        forneceRepository.atualizar(fornece);
    }

    @Override
    public void excluirFornece(int id) {
        forneceRepository.excluir(id);
    }

    @Override
    public List<Fornece> listarFornece() {
        return forneceRepository.listar();
    }

    @Override
    public Fornece buscarFornecePorId(int id) {
        return forneceRepository.buscarPorId(id);
    }
}
