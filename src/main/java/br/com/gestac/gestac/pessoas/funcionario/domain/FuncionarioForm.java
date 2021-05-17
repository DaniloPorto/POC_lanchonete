package br.com.gestac.gestac.pessoas.funcionario.domain;

import br.com.gestac.gestac.pessoas.commons.form.PessoaForm;
import br.com.gestac.gestac.pessoas.jornada.domain.Jornada;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioForm extends PessoaForm {

    @NotNull
    private long idJornada;

    @NotNull
    private Cargo cargo;

    private LocalDate dataNascimento;

    public Funcionario toModel() {
        Funcionario func = new Funcionario();
        func.setNome(this.getNome());
        func.setCargo(this.getCargo());
        func.setCpfCnpj(this.getCpfCnpj());
        func.setContatos(this.getContatos());
        func.setEnderecos(this.getEnderecos());
        func.setTipoPessoa(this.getTipoPessoa());
        func.setJornada(Jornada.builder().id(this.getIdJornada()).build());
        return func;
    }
}
