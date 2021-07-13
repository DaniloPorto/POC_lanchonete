package br.com.gestac.gestac.produto.domain;

import br.com.gestac.gestac.produto.estoque.domain.EstoqueProduto;
import br.com.gestac.gestac.produto.tipo.domain.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    @Id
    private String codigo;

    private String descricao;

    private BigDecimal precoVenda;

    @OneToOne
    private TipoProduto tipoProduto;

    @OneToMany(mappedBy = "produto")
    private List<EstoqueProduto> estoqueProduto;

}
