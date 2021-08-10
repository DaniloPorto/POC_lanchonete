package br.com.lanchonete.produto.estoque.domain;

import br.com.lanchonete.produto.domain.Produto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class EstoqueProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String numeroLote;
    private LocalDate dataVencimento;
    private LocalDate dataCompra;
    private BigDecimal quantidadeEntrada;
    private BigDecimal quantidadeRetirada;
    private BigDecimal precoCompra;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "codigo_produto", nullable = false)
    private Produto produto;

    public static EstoqueProduto from(EstoqueProdutoForm form) {
        EstoqueProduto estoqueProduto = new EstoqueProduto();
        estoqueProduto.setId(form.getId());
        estoqueProduto.setNumeroLote(form.getNumeroLote());
        estoqueProduto.setDataVencimento(form.getDataVencimento());
        estoqueProduto.setDataCompra(form.getDataCompra());
        estoqueProduto.setQuantidadeRetirada(form.getQuantidadeRetirada());
        estoqueProduto.setQuantidadeEntrada(form.getQuantidadeEntrada());
        estoqueProduto.setPrecoCompra(form.getPrecoCompra());
        estoqueProduto.setProduto(null);

        return estoqueProduto;
    }
}
