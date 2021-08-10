package br.com.lanchonete.produto.tipo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TipoProdutoForm {

    private Long id;

    @NotNull(message = "{descricao.not.null}")
    @NotBlank(message = "{descricao.not.blank}")
    private String descricao;

    @NotNull(message = "{flag.perecivel.not.null}")
    @NotBlank(message = "{flag.perecivel.not.blank}")
    @Size(min = 1, max = 1, message = "{flag.perecivel.size}")
    private String flagPerecivel;

    @NotNull(message = "{flag.validade.not.null}")
    @NotBlank(message = "{flag.validade.not.blank}")
    @Size(min = 1, max = 1, message = "{flag.validade.size}")
    private String flagValidade;

    @NotNull(message = "{flag.estocavel.not.null}")
    @NotBlank(message = "{flag.estocavel.not.blank}")
    @Size(min = 1, max = 1, message = "{flag.estocavel.size}")
    private String flagEstocavel;

    public TipoProduto toModel() {
        TipoProduto tipo = new TipoProduto();
        tipo.setId(this.getId());
        tipo.setDescricao(this.getDescricao());
        tipo.setFlagValidade(this.getFlagValidade());
        tipo.setFlagPerecivel(this.getFlagPerecivel());
        tipo.setFlagEstocavel(this.getFlagEstocavel());
        return tipo;
    }
}
