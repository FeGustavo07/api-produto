package com.ecommerce.produto.dto;

import com.ecommerce.produto.domains.Categoria;
import com.ecommerce.produto.domains.Produto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
public class ProdutoResponse {
    private Long id;
    private String nome;
    private String descricao;
    private Categoria categoria;
    private double preco;

    public ProdutoResponse(Produto produto) {
        this.id = produto.getId();
        this.categoria = produto.getCategoria();
        this.preco = produto.getPreco();
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
    }

    public static List<ProdutoResponse> toResponse(List<Produto> produtos) {
        return produtos.stream().map(ProdutoResponse::new).collect(Collectors.toList());
    }
}
