package br.com.lanchonete.pedido.domain;

import br.com.lanchonete.pedido.itemPedido.domain.ItemPedido;
import br.com.lanchonete.pessoas.funcionario.domain.Funcionario;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Enumerated(EnumType.STRING)
    private TipoDeEntrega tipoDeEntrega;
    private String descricaoDaEntrega;
    @OneToOne
    private Funcionario funcionario;
    private LocalDateTime dataHora;
    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itensPedido;

}
