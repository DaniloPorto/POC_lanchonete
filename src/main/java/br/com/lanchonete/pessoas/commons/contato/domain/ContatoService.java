package br.com.lanchonete.pessoas.commons.contato.domain;

import br.com.lanchonete.commons.business.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContatoService {

    @Autowired
    private ContatoRepository contatoRepository;

    @Transactional
    public Contato atualizar(Contato contato) throws BusinessException {
        Contato contatoOld = buscarPorId(contato.getId());
        contatoOld.setEmail(contato.getEmail());
        contatoOld.setPessoa(contato.getPessoa());
        contatoOld.setTelefone(contato.getTelefone());

        return contato;
    }

    @Transactional
    public List<Contato> atualizar(List<Contato> contatos) throws BusinessException {

        List<Contato> contatosReturn = new ArrayList<>();
        for (Contato contato : contatos) {
            Contato contatoOld = buscarPorId(contato.getId());
            contatoOld.setEmail(contato.getEmail());
            contatoOld.setPessoa(contato.getPessoa());
            contatoOld.setTelefone(contato.getTelefone());
            contatosReturn.add(contatoOld);
        }



        return contatosReturn;
    }

    public Contato buscarPorId(int idContato) throws BusinessException {
        Optional<Contato> contatoOptional = contatoRepository.findById(idContato);
        if (contatoOptional.isEmpty()) {
            throw new BusinessException("Não foi possível encontrar o contato com ID " + idContato);
        }
        return contatoOptional.get();
    }
}
