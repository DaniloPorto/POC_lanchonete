package br.com.lanchonete.produto.domain;

import br.com.lanchonete.produto.estoque.domain.EstoqueProduto;
import br.com.lanchonete.produto.tipo.domain.TipoProduto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.math.BigDecimal;
import java.util.List;

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
