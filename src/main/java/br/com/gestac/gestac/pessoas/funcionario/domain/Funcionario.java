package br.com.gestac.gestac.pessoas.funcionario.domain;

import br.com.gestac.gestac.pessoas.commons.Pessoa;
import br.com.gestac.gestac.pessoas.funcionario.cargo.domain.Cargo;
import br.com.gestac.gestac.pessoas.funcionario.jornada.domain.Jornada;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class Funcionario extends Pessoa {

    private LocalDate dataNascimento;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Cargo> cargos;
    @OneToOne
    private Jornada jornada;
}
