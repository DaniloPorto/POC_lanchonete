package br.com.gestac.gestac.pessoas.funcionario.domain;

import br.com.gestac.gestac.pessoas.commons.form.PessoaForm;
import br.com.gestac.gestac.pessoas.funcionario.domain.Cargo;
import br.com.gestac.gestac.pessoas.funcionario.domain.Funcionario;
import br.com.gestac.gestac.pessoas.jornada.domain.Jornada;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class FuncionarioForm extends PessoaForm {

    @NotNull
    @Min(1)
    private Long idJornada;

    @NotNull
    private Cargo cargo;

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
