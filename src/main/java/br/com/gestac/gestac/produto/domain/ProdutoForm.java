package br.com.gestac.gestac.produto.domain;

import br.com.gestac.gestac.produto.estoque.domain.EstoqueProduto;
import br.com.gestac.gestac.produto.estoque.domain.EstoqueProdutoForm;
import br.com.gestac.gestac.produto.tipo.domain.TipoProduto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProdutoForm {

    @NotNull
    @NotBlank
    private String codigo;
    @NotNull
    @NotBlank
    private String descricao;

    private BigDecimal precoVenda;

    @NotNull
    private Long idTipoProduto;
    @NotNull
    private List<EstoqueProdutoForm> estoqueProdutos;

    public Produto toModel() {
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setId(this.idTipoProduto);
        List<EstoqueProduto> estoqueProdutoList = this.estoqueProdutos.stream().map(EstoqueProduto::from).collect(Collectors.toList());
        return new Produto(this.codigo, this.descricao, this.getPrecoVenda(), tipoProduto, estoqueProdutoList);
    }
}
