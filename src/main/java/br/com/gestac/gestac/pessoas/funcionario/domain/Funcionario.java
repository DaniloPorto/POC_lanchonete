package br.com.gestac.gestac.pessoas.funcionario.domain;

import br.com.gestac.gestac.pessoas.commons.Pessoa;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Funcionario extends Pessoa {

    private LocalDate dataNascimento;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Cargo> cargos;
}
