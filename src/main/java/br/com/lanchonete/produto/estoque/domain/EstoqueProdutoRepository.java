package br.com.lanchonete.produto.estoque.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstoqueProdutoRepository extends JpaRepository<EstoqueProduto, Long> {

    @Query(value = "select from estoque_produto where id_produto =: codigoProduto  ", nativeQuery = true)
    List<EstoqueProduto> buscarEstoquePorIdProduto(String codigoProduto);
}
