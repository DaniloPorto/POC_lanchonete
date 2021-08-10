package br.com.lanchonete.commons.validator;

import br.com.lanchonete.commons.business.exception.BusinessException;

public abstract class Validator<T extends Object> {

    public abstract boolean ehValido(T t);
    public abstract String getMensagem();

    void validar(T t) throws BusinessException {
        if (!ehValido(t)) {
            throw new BusinessException(getMensagem());
        }
    }
}
