package br.com.lanchonete.commons.handlers;

import br.com.lanchonete.commons.business.BusinessResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class MethodArgumentNotValidExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<BusinessResponseEntity> handleMethodArgumentNotValidException(MethodArgumentNotValidException exception) {

        List<FieldError> fieldErrors = exception.getBindingResult().getFieldErrors();
        List<String> mensagens = fieldErrors.stream()
                .map(fieldError -> messageSource.getMessage(fieldError, LocaleContextHolder.getLocale()))
                .collect(Collectors.toList());

        BusinessResponseEntity response = BusinessResponseEntity.builder()
                .mensagens(mensagens)
                .httpStatus(HttpStatus.UNPROCESSABLE_ENTITY.ordinal())
                .dateTime(LocalDateTime.now(ZoneId.systemDefault()))
                .build();

        return ResponseEntity.unprocessableEntity().body(response);
    }
}
