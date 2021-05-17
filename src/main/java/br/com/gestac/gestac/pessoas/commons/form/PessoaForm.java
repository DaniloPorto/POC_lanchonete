package br.com.gestac.gestac.pessoas.commons.form;

import br.com.gestac.gestac.pessoas.commons.TipoPessoa;
import br.com.gestac.gestac.pessoas.commons.contato.domain.Contato;
import br.com.gestac.gestac.pessoas.commons.endereco.domain.Endereco;
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

    @NotNull
    @NotBlank
    private String nome;

    @NotNull
    @NotBlank
    private String cpfCnpj;

    @NotNull
    private TipoPessoa tipoPessoa;

    @NotEmpty
    private List<Contato> contatos;

    @NotEmpty
    private List<Endereco> enderecos;

}
