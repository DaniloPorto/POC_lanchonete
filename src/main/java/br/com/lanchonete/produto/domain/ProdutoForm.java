package br.com.lanchonete.produto.domain;

import br.com.lanchonete.produto.estoque.domain.EstoqueProduto;
import br.com.lanchonete.produto.estoque.domain.EstoqueProdutoForm;
import br.com.lanchonete.produto.tipo.domain.TipoProduto;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class ProdutoForm {

    @NotNull
    @NotBlank
    private String codigo;

    @NotNull(message = "{descricao.not.null}")
    @NotBlank(message = "{descricao.not.blank}")
    private String descricao;

    private BigDecimal precoVenda;

    @NotNull
    private Long idTipoProduto;

    private List<EstoqueProdutoForm> estoqueProdutos;

    public Produto toModel() {
        TipoProduto tipoProduto = new TipoProduto();
        tipoProduto.setId(this.idTipoProduto);

        List<EstoqueProduto> estoqueProdutoList = new ArrayList<>();
        if (estoqueProdutos != null && !estoqueProdutos.isEmpty()) {
            this.estoqueProdutos.stream().map(EstoqueProduto::from).collect(Collectors.toList());
        }
        return new Produto(this.codigo, this.descricao, this.getPrecoVenda(), tipoProduto, estoqueProdutoList);
    }
}
