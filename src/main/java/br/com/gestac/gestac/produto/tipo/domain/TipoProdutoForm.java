package br.com.gestac.gestac.produto.tipo.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TipoProdutoForm {

    private Long id;

    @NotNull
    @NotBlank
    private String descricao;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 1)
    private String flagPerecivel;

    @NotNull
    @NotBlank
    @Size(min = 1, max = 1)
    private String flagValidade;

    public TipoProduto toModel() {
        TipoProduto tipo = new TipoProduto();
        tipo.setId(this.getId());
        tipo.setDescricao(this.getDescricao());
        tipo.setFlagValidade(this.getFlagValidade());
        tipo.setFlagPerecivel(this.getFlagPerecivel());

        return tipo;
    }
}
