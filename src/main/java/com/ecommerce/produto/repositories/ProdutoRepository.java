package com.ecommerce.produto.repositories;

import com.ecommerce.produto.domains.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
