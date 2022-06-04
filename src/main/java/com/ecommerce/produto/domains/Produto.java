package com.ecommerce.produto.domains;

import com.ecommerce.produto.dto.ProdutoRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@RequiredArgsConstructor
@Getter @Setter
public class Produto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @Column
    @Enumerated(EnumType.STRING)
    private Categoria categoria;

    @Column
    private double preco;

    public Produto(ProdutoRequest produtoRequest) {
        this.categoria = produtoRequest.getCategoria();
        this.descricao = produtoRequest.getDescricao();
        this.nome = produtoRequest.getNome();
        this.preco = produtoRequest.getPreco();
    }
}
