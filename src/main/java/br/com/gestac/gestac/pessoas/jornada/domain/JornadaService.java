package br.com.gestac.gestac.pessoas.jornada.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.util.data.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class JornadaService {

    @Autowired
    private JornadaRepository jornadaRepository;

    @Transactional
    public Jornada incluir(Jornada jornada) throws BusinessException {
        try {
            Integer totalDeHorasPrimeiraJornada = DateUtil.totalDeHoras(jornada.getInicioJornada(), jornada.getInicioAlmoco());
            Integer totalDeHorasSegundaJornada = DateUtil.totalDeHoras(jornada.getInicioJornada(), jornada.getInicioAlmoco());
            Integer totalDeHoras = totalDeHorasPrimeiraJornada + totalDeHorasSegundaJornada;
            jornada.setTotalDeHoras(totalDeHoras);
            return jornadaRepository.save(jornada);
        } catch (Exception e) {
            throw new BusinessException("Falha ao tentar salvar jornada: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Transactional
    public void excluirPorId(Long idJornada) throws BusinessException {
        Jornada jornada = buscarPorId(idJornada);
        jornadaRepository.deleteById(jornada.getId());
    }

    public Jornada buscarPorId(Long idJornada) throws BusinessException {
        Optional<Jornada> jornadaOptional = jornadaRepository.findById(idJornada);
        if (jornadaOptional.isEmpty()) {
            throw new BusinessException("Jornada " + jornadaOptional.get().getId() + " não encontrada");
        }
        return jornadaOptional.get();
    }

}
