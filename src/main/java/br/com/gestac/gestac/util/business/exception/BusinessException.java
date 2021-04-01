package br.com.gestac.gestac.util.business.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BusinessException extends Exception{

    @Getter
    private int httpStatus;

    public BusinessException(String mensagem) {
        super(mensagem);
        defaultHttpStatus();
    }

    public BusinessException(String mensagem, int httpStatus) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }
    public BusinessException (String mensagem, Throwable causa){
        super(mensagem, causa);
        defaultHttpStatus();
    }

    public BusinessException (String mensagem, Throwable causa, int httpStatus){
        super(mensagem, causa);
        this.httpStatus = httpStatus;
    }

    public BusinessException(Throwable causa) {
        super(causa);
    }

    private void defaultHttpStatus() {
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();
    }
}
