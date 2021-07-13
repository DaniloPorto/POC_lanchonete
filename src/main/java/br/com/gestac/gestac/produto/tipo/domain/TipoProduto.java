package br.com.gestac.gestac.produto.tipo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class TipoProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 250)
    private String descricao;

    @Column(length = 1)
    private String flagPerecivel;

    @Column(length = 1)
    private String flagValidade;

}
