package br.com.lanchonete.pessoas.jornada.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Jornada {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String descricao;
    private LocalTime inicioJornada;
    private LocalTime inicioAlmoco;
    private LocalTime fimAlmoco;
    private LocalTime fimJornada;
    private Integer totalDeHoras;
}
