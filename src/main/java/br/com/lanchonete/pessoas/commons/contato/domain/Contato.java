package br.com.lanchonete.pessoas.commons.contato.domain;

import br.com.lanchonete.pessoas.commons.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private Pessoa pessoa;

}
