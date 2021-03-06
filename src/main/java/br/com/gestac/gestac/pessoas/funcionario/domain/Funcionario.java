package br.com.gestac.gestac.pessoas.funcionario.domain;

import br.com.gestac.gestac.pessoas.commons.Pessoa;
import br.com.gestac.gestac.pessoas.jornada.domain.Jornada;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Funcionario extends Pessoa {

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToOne
    private Jornada jornada;
}
