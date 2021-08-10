package br.com.lanchonete.pedido.domain;

import br.com.lanchonete.pedido.itemPedido.domain.ItemPedido;
import br.com.lanchonete.pedido.itemPedido.domain.ItemPedidoForm;
import br.com.lanchonete.pessoas.funcionario.domain.Funcionario;
import br.com.lanchonete.pessoas.funcionario.domain.FuncionarioForm;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class PedidoForm {

    private Long id;
    @NotNull(message = "{tipo.produto.not.null}")
    private TipoDeEntrega tipoDeEntrega;
    @NotNull(message = "{descricao.entrega.not.null}")
    @NotBlank(message = "{descricao.entrega.not.blank}")
    private String descricaoDaEntrega;
    @NotNull(message = "{funcionario.not.null}")
    private Long idFuncionario;
    private LocalDateTime dataHora;

    @NotNull(message = "{item.pedido.not.null}")
    @NotEmpty(message = "{item.pedido.not.empty}")
    private List<ItemPedidoForm> itensPedido;

    public Pedido toModel() {
        Pedido pedido = new Pedido();
        pedido.setId(this.id);
        pedido.setTipoDeEntrega(this.tipoDeEntrega);
        pedido.setDescricaoDaEntrega(this.descricaoDaEntrega);
        Funcionario funcionario = new Funcionario();
        funcionario.setId(idFuncionario);
        pedido.setFuncionario(funcionario);
        pedido.setDataHora(this.dataHora);
        pedido.setItensPedido(this.itensPedido.stream().map(item -> item.toModel()).collect(Collectors.toList()));
        return pedido;
    }
}
