package br.com.lanchonete.pessoas.cliente.domain;

import br.com.lanchonete.pessoas.commons.Pessoa;
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
