package br.com.gestac.gestac.pessoas.cliente.domain;

import br.com.gestac.gestac.commons.business.exception.BusinessException;
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

        try {
            Cliente clienteSalvo = clienteRepository.save(cliente);
            Optional<Cliente> clienteOptional = buscarPorId(clienteSalvo.getId());

            if (clienteOptional.isEmpty()) {
                throw new BusinessException("");
            }

            clienteOptional.get().setContatos(cliente.getContatos());
            clienteOptional.get().setEnderecos(cliente.getEnderecos());

            return clienteRepository.save(clienteOptional.get());
        } catch (Exception e) {
            throw new BusinessException("Erro ao tentar incluir um cliente", HttpStatus.INTERNAL_SERVER_ERROR.value());
            //todo LOGs
        }

    }

    @Transactional
    public void excluirPorId(Long idCliente) throws BusinessException {

        try {
            Optional<Cliente> clienteOptional = buscarPorId(idCliente);
            if (clienteOptional.isEmpty()) {
                throw new BusinessException("Não foi possivel encontrar um cliente com o ID " + idCliente + ", para a exclusão");
            }
            clienteRepository.delete(clienteOptional.get());
        } catch (Exception e) {
            throw new BusinessException("Falha ao tentar excluir o cliente com ID: " + idCliente, HttpStatus.INTERNAL_SERVER_ERROR.value());
        }

    }

    public Optional<Cliente> buscarPorId(Long idCliente) {
        return clienteRepository.findById(idCliente);
    }

    public List<Cliente> buscarTodos() {
        return clienteRepository.findAll();
    }
}
