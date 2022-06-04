package com.ecommerce.produto.controllers;

import com.ecommerce.produto.dto.ProdutoRequest;
import com.ecommerce.produto.dto.ProdutoResponse;
import com.ecommerce.produto.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoResponse criar(@RequestBody ProdutoRequest produtoRequest) {
        return produtoService.criar(produtoRequest);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponse mostrar(@PathVariable Long id) {
        return produtoService.mostrar(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<ProdutoResponse> mostrarTodos() {
        return produtoService.mostrarTodos();
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProdutoResponse atualizar(@PathVariable Long id, @RequestBody ProdutoRequest produtoRequest) {
        return produtoService.atualizar(id, produtoRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletar(@PathVariable Long id) {
        produtoService.deletar(id);
    }
}
