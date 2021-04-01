package br.com.gestac.gestac.util.business;

import lombok.*;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BusinessResponse<T> {

    private String mensagemValidacao;
    private LocalDateTime dateTime;
    private int httpStatus;
    private List<Object> objetos = new ArrayList<>();
}
