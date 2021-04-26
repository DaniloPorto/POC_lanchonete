package br.com.gestac.gestac.commons.business.exception;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<BusinessResponseEntity> handleBusinessException(BusinessException e) {

        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .mensagem(e.getMessage())
                .httpStatus(e.getHttpStatus())
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .build();

        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }

}
