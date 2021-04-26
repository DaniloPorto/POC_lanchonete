package br.com.gestac.gestac.pessoas.funcionario.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.pessoas.jornada.domain.Jornada;
import br.com.gestac.gestac.pessoas.jornada.domain.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private JornadaService jornadaService;

    @Transactional
    public Funcionario incluir(Funcionario funcionario) throws BusinessException {
        Jornada jornada = jornadaService.buscarPorId(funcionario.getJornada().getId());
        funcionario.setJornada(jornada);
        return funcionarioRepository.save(funcionario);
    }
}
