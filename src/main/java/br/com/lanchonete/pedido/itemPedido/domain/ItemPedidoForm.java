package br.com.lanchonete.pedido.itemPedido.domain;

import br.com.lanchonete.produto.domain.ProdutoForm;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.stream.Collectors;


@Getter
@Setter
public class ItemPedidoForm {

    private Long id;
    @NotNull(message = "{produto.not.null}")
    @NotEmpty(message = "{list.produto.not.empty}")
    private List<ProdutoForm> produtos;
    private String observacoes;

    public ItemPedido toModel() {
        ItemPedido itemPedido = new ItemPedido();
        itemPedido.setId(this.id);
        itemPedido.setProdutos(this.produtos.stream().map(produtoForm -> produtoForm.toModel()).collect(Collectors.toList()));
        return itemPedido;
    }
}
