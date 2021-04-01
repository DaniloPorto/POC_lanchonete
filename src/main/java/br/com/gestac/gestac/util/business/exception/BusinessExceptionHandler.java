package br.com.gestac.gestac.util.business.exception;

import br.com.gestac.gestac.util.business.BusinessResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class BusinessExceptionHandler{

    @ExceptionHandler(value = {BusinessException.class})
    public ResponseEntity<BusinessResponse> handleBusinessException(BusinessException e) {

        BusinessResponse response = BusinessResponse.builder()
                                                    .mensagemValidacao(e.getMessage())
                                                    .httpStatus(e.getHttpStatus())
                                                    .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                                                    .build();

        return ResponseEntity.status(e.getHttpStatus()).body(response);
    }

}
