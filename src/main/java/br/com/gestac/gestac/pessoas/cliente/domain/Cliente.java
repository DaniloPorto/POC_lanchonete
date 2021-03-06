package br.com.gestac.gestac.pessoas.cliente.domain;

import br.com.gestac.gestac.pessoas.commons.Pessoa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Cliente extends Pessoa {

    private LocalDate dataNascimento;
}
