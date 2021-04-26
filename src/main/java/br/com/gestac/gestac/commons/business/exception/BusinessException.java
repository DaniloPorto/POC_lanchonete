package br.com.gestac.gestac.commons.business.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

public class BusinessException extends Exception {

    @Getter
    private int httpStatus;

    /**
     * Por padrão este construtor define o status http UNPROCESSABLE_ENTITY
     *
     * @param mensagem É o texto da validação gerada
     */
    public BusinessException(String mensagem) {
        super(mensagem);
        defaultHttpStatus();
    }

    /**
     * Este construtor permite a inserção de um status http
     *
     * @param mensagem   É o texto da validação gerada
     * @param httpStatus Status http de retorno
     */
    public BusinessException(String mensagem, int httpStatus) {
        super(mensagem);
        this.httpStatus = httpStatus;
    }

    private void defaultHttpStatus() {
        this.httpStatus = HttpStatus.UNPROCESSABLE_ENTITY.value();
    }
}
