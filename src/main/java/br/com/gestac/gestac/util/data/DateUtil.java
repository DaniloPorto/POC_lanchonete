package br.com.gestac.gestac.util.data;

import java.time.LocalDate;

public class DateUtil {

    public static Integer converterDataEmIdade(LocalDate dataNascimento) {

        Integer anosDeIdade = dataNascimento.getYear() - LocalDate.now().getYear();

        if(dataNascimento.getMonth().getValue() >  LocalDate.now().getMonth().getValue()) {

        }

        return anosDeIdade;
    }
}
