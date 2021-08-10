package br.com.lanchonete.commons.business;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BusinessResponseEntityFactory {

    public static ResponseEntity<BusinessResponseEntity> getResponseSucess(Object result) {
        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .objetos(Arrays.asList(result))
                .httpStatus(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<BusinessResponseEntity> getResponseSucess(Object result, String mensagem) {
        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .mensagens(Arrays.asList(mensagem))
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .objetos(Arrays.asList(result))
                .httpStatus(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<BusinessResponseEntity> getResponseSucess(List<Object> results) {
        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .objetos(results)
                .httpStatus(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<BusinessResponseEntity> getResponseSucess() {
        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .objetos(new ArrayList<>())
                .httpStatus(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }

    public static ResponseEntity<BusinessResponseEntity> getResponseSucess(String mensagem) {
        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .objetos(new ArrayList<>())
                .mensagens(Arrays.asList(mensagem))
                .httpStatus(HttpStatus.OK.value())
                .build();

        return ResponseEntity.ok(response);
    }
}
