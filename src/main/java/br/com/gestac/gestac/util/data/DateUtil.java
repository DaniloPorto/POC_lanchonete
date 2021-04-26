package br.com.gestac.gestac.util.data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public abstract class DateUtil {

    public static Integer converterDataEmIdade(LocalDate dataNascimento) {
        Integer anosDeIdade = dataNascimento.getYear() - LocalDate.now().getYear();
        if (dataNascimento.getMonth().getValue() > LocalDate.now().getMonth().getValue()) {
        }
        return anosDeIdade;
    }

    public static Integer totalDeHoras(LocalTime horaMenor, LocalTime horaManior) {
        Long total = horaManior.until(horaMenor, ChronoUnit.HOURS);
        if (total < 0) {
            total = total * -1;
        }
        return total.intValue();
    }
}
