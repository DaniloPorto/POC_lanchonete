package br.com.gestac.gestac.pessoas.cliente.domain;

import br.com.gestac.gestac.pessoas.commons.form.PessoaForm;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
public class ClienteForm extends PessoaForm {

    @NotNull
    private LocalDate dataNascimento;

    public Cliente toModel() {
        Cliente cliente = new Cliente();
        cliente.setNome(this.getNome());
        cliente.setCpfCnpj(this.getCpfCnpj());
        cliente.setTipoPessoa(this.getTipoPessoa());
        cliente.setDataNascimento(this.getDataNascimento());
        cliente.setContatos(this.getContatos());
        cliente.setEnderecos(this.getEnderecos());
        return cliente;
    }
}
