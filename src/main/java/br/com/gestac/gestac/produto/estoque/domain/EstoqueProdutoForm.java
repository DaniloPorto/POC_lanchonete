package br.com.gestac.gestac.produto.estoque.domain;

import br.com.gestac.gestac.produto.domain.Produto;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class EstoqueProdutoForm {

    private Long id;
    @NotNull
    private String numeroLote;
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataVencimento;
    @NotNull
    @JsonFormat(pattern = "dd/MM/yyyy", shape = JsonFormat.Shape.STRING)
    private LocalDate dataCompra;
    private BigDecimal quantidadeEntrada;
    private BigDecimal quantidadeRetirada;
    @NotNull
    private BigDecimal precoCompra;

    public EstoqueProduto toModel() {

        EstoqueProduto estoqueProduto = new EstoqueProduto();
        estoqueProduto.setId(this.id);
        estoqueProduto.setNumeroLote(this.numeroLote);
        estoqueProduto.setDataVencimento(this.dataVencimento);
        estoqueProduto.setDataCompra(this.dataCompra);
        estoqueProduto.setProduto(new Produto());
        estoqueProduto.setPrecoCompra(this.precoCompra);
        estoqueProduto.setQuantidadeEntrada(this.quantidadeEntrada);
        estoqueProduto.setQuantidadeRetirada(this.quantidadeRetirada);

        return estoqueProduto;
    }
}
