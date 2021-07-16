package br.com.gestac.gestac.commons.handlers;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;

@ControllerAdvice
public class BusinessExceptionHandler {

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<BusinessResponseEntity> handleBusinessException(BusinessException e) {

        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .mensagens(Arrays.asList(e.getMessage()))
                .httpStatus(e.getHttpStatus())
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .build();

        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }

}
