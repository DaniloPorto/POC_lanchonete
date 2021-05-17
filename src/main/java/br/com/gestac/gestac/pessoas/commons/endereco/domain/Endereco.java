package br.com.gestac.gestac.pessoas.commons.endereco.domain;

import br.com.gestac.gestac.pessoas.commons.Pessoa;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bairro;
    private String rua;
    private String numero;
    private String Cidade;
    private String cep;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "pessoa_id", nullable = false)
    private Pessoa pessoa;
}
