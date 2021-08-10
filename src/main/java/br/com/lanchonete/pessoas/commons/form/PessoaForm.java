package br.com.lanchonete.pessoas.commons.form;

import br.com.lanchonete.pessoas.commons.TipoPessoa;
import br.com.lanchonete.pessoas.commons.contato.domain.Contato;
import br.com.lanchonete.pessoas.commons.endereco.domain.Endereco;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaForm {

    long id;

    @NotNull(message = "{nome.not.null}")
    @NotBlank(message = "{nome.not.blank}")
    private String nome;

    @NotNull(message = "{cptCnpj.not.null}")
    @NotBlank(message = "{cpfCnpj.not.blank}")
    private String cpfCnpj;

    @NotNull(message = "{tipoPessoa.not.null}")
    private TipoPessoa tipoPessoa;

    @NotEmpty(message = "contatos.not.empty")
    private List<Contato> contatos;

    @NotEmpty(message = "enderecos.not.empty")
    private List<Endereco> enderecos;

}
