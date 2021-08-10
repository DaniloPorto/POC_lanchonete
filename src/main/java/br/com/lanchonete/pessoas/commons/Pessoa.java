package br.com.lanchonete.pessoas.commons;

import br.com.lanchonete.pessoas.commons.contato.domain.Contato;
import br.com.lanchonete.pessoas.commons.endereco.domain.Endereco;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@EqualsAndHashCode
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String cpfCnpj;

    @Enumerated(EnumType.STRING)
    private TipoPessoa tipoPessoa;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Contato> contatos;

    @OneToMany(mappedBy = "pessoa", cascade = CascadeType.ALL)
    private List<Endereco> enderecos;


    public void setContatos(List<Contato> contatos) {
        contatos.forEach(contato -> {
            contato.setPessoa(this);
        });
        this.contatos = contatos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        enderecos.forEach(endereco -> {
            endereco.setPessoa(this);
        });
        this.enderecos = enderecos;
    }
}
