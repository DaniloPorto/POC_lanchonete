package br.com.gestac.gestac.produto.domain;

import br.com.gestac.gestac.produto.estoque.domain.EstoqueProduto;
import br.com.gestac.gestac.produto.tipo.domain.TipoProduto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String codigo;

    private String descricao;

    @OneToOne
    private TipoProduto tipoProduto;

    @OneToMany(mappedBy = "produto")
    private List<EstoqueProduto> estoqueProduto;

}
