package br.com.gestac.gestac.commons.business;

import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResponseEntity {

    private String mensagemValidacao;
    private LocalDateTime dateTime;
    private int httpStatus;
    private List<Object> objetos = new ArrayList<>();
}
