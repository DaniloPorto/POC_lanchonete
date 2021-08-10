package br.com.lanchonete.commons.business;

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

    private List<String> mensagens;
    private LocalDateTime dateTime;
    private int httpStatus;
    private List<Object> objetos = new ArrayList<>();
}
