package com.ecommerce.produto.service;

import com.ecommerce.produto.dto.ProdutoRequest;
import com.ecommerce.produto.dto.ProdutoResponse;

import java.util.List;

public interface ProdutoService {
    ProdutoResponse criar(ProdutoRequest produtoRequest);
    ProdutoResponse mostrar(Long id);
    List<ProdutoResponse> mostrarTodos();
    ProdutoResponse atualizar(Long id, ProdutoRequest produtoRequest);
    void deletar(Long id);
}
