package br.com.lanchonete.pessoas.jornada.domain;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
public class JornadaForm {

    @NotNull(message = "A descrição da jornada não pode ser nula")
    @NotBlank(message = "A descrição da jornada não pode ser vazia")
    private String descricao;

    @NotNull(message = "A hora inicial da joranda não pode ser nula")
    private LocalTime inicioJorn;

    @NotNull(message = "A hora inicial do almoço não pode ser nula")
    private LocalTime inicioAlmoco;

    @NotNull(message = "A hora inicial do almoço não pode ser nula")
    private LocalTime fimAlmoco;

    @NotNull(message = "A hora final da jornada não pode ser nula")
    private LocalTime fimJorn;

    public Jornada toModel() {
        return Jornada.builder()
                .descricao(this.descricao)
                .inicioJornada(this.inicioJorn)
                .inicioAlmoco(this.inicioAlmoco)
                .fimAlmoco(this.fimAlmoco)
                .fimJornada(this.fimJorn).build();
    }
}
