package com.ecommerce.produto.dto;

import com.ecommerce.produto.domains.Categoria;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProdutoRequest {
    private String nome;
    private String descricao;
    private Categoria categoria;
    private double preco;
}
