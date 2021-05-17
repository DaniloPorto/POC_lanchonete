package br.com.gestac.gestac.produto.estoque.domain;

import br.com.gestac.gestac.produto.domain.Produto;
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
    private BigDecimal quantidadeMinima;
    private BigDecimal quantidadeRetirada;
    private BigDecimal valorUnitario;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
}
