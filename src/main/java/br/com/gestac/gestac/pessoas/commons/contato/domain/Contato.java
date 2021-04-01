package br.com.gestac.gestac.pessoas.commons.contato.domain;

import br.com.gestac.gestac.pessoas.commons.Pessoa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String telefone;
    private String email;
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;

}
