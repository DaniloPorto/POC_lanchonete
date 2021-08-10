package br.com.lanchonete.pedido.itemPedido.domain;

import br.com.lanchonete.pedido.domain.Pedido;
import br.com.lanchonete.produto.domain.Produto;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<Produto> produtos;
    private String observacoes;
    @ManyToOne
    private Pedido pedido;
}

