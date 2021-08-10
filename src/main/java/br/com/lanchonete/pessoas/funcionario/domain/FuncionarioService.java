package br.com.lanchonete.pessoas.funcionario.domain;

import br.com.lanchonete.commons.business.exception.BusinessException;
import br.com.lanchonete.pessoas.commons.contato.domain.ContatoService;
import br.com.lanchonete.pessoas.jornada.domain.Jornada;
import br.com.lanchonete.pessoas.jornada.domain.JornadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;
    @Autowired
    private JornadaService jornadaService;
    @Autowired
    private ContatoService contatoService;

    @Transactional
    public Funcionario incluir(Funcionario funcionario) throws BusinessException {
        try {
            Jornada jornada = jornadaService.buscarPorId(funcionario.getJornada().getId());
            funcionario.setJornada(jornada);
            return funcionarioRepository.save(funcionario);
        } catch (Exception e) {
            throw new BusinessException("Erro ao tentar incluir um Funcionario --> ".concat(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Transactional
    public void excluirPorId(Long idFuncionario) throws BusinessException {
        try {
            Funcionario funcionario = buscarPorId(idFuncionario);
            funcionarioRepository.delete(funcionario);
        }catch(Exception e) {
            throw new BusinessException("Erro ao tentar excluír funcionario", HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Transactional
    public Funcionario atualizar(FuncionarioForm funcionarioForm) throws BusinessException {
        Funcionario funcionarioOld = buscarPorId(funcionarioForm.getId());
        funcionarioOld.setNome(funcionarioForm.getNome());
        funcionarioOld.setCargo(funcionarioForm.getCargo());
        funcionarioOld.setCpfCnpj(funcionarioForm.getCpfCnpj());
        funcionarioOld.setTipoPessoa(funcionarioForm.getTipoPessoa());
        funcionarioOld.setDataNascimento(funcionarioForm.getDataNascimento());

        return funcionarioOld;
    }

    public Funcionario buscarPorId(Long idFuncionario) throws BusinessException {
        if (null == idFuncionario) {
            throw new BusinessException("O ID do funcionário não pode ser nulo");
        }

        Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(idFuncionario);
        if (funcionarioOptional.isEmpty()) {
            throw new BusinessException("Não foi possível encontrar funcionario com o ID " + idFuncionario);
        }

        return funcionarioOptional.get();
    }

    public List<Funcionario> buscarTodos() {
        return funcionarioRepository.findAll();
    }

}
