package br.com.gestac.gestac.pessoas.cliente.domain;

import br.com.gestac.gestac.util.business.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente incluir(Cliente cliente) throws BusinessException {
        Cliente clienteSalvo = clienteRepository.save(cliente);
        Optional<Cliente> clienteOptional = buscarPorId(clienteSalvo.getId());

        if (clienteOptional.isPresent()) {
            clienteOptional.get().setContatos(cliente.getContatos());
            clienteOptional.get().setEnderecos(cliente.getEnderecos());
            return clienteRepository.save(clienteOptional.get());
        }

        return clienteOptional.get();
    }

    @Transactional
    public void excluirPorId(Long idCliente) throws BusinessException {
        Optional<Cliente> clienteOptional = buscarPorId(idCliente);
        if (clienteOptional.isPresent()) {
            clienteRepository.deleteById(idCliente);
        }
        throw new BusinessException("Não foi possivel encontrar um cliente com o ID " + idCliente, HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    public Optional<Cliente> buscarPorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
