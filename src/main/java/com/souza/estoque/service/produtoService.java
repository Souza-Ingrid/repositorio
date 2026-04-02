package com.souza.estoque.service;

import com.souza.estoque.model.Produto;
import com.souza.estoque.repository.produtoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class produtoService {

    private final produtoRepository produtoRepository;

    public produtoService(produtoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto criar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        produtoRepository.delete(buscarPorId(id));
    }
}