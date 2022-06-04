package com.ecommerce.produto.service.impl;

import com.ecommerce.produto.domains.Produto;
import com.ecommerce.produto.dto.ProdutoRequest;
import com.ecommerce.produto.dto.ProdutoResponse;
import com.ecommerce.produto.repositories.ProdutoRepository;
import com.ecommerce.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class ProdutoServiceImpl implements ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoResponse criar(ProdutoRequest produtoRequest) {
        var produto = new Produto(produtoRequest);
        produtoRepository.save(produto);
        return new ProdutoResponse(produto);
    }

    @Override
    public ProdutoResponse mostrar(Long id) {
        var produto = produtoRepository.findById(id).orElseThrow();
        return new ProdutoResponse(produto);
    }

    @Override
    public List<ProdutoResponse> mostrarTodos() {
        return ProdutoResponse.toResponse(
            produtoRepository.findAll()
        );
    }

    @Override
    public ProdutoResponse atualizar(Long id, ProdutoRequest produtoRequest) {
        var produto = produtoRepository.findById(id).orElseThrow();
        produto.setCategoria(produtoRequest.getCategoria());
        produto.setDescricao(produtoRequest.getDescricao());
        produto.setNome(produtoRequest.getNome());
        produto.setPreco(produtoRequest.getPreco());
        return new ProdutoResponse(produto);
    }

    @Override
    public void deletar(Long id) {
        var produto = produtoRepository.findById(id).orElseThrow();
        produtoRepository.delete(produto);
    }
}
