package br.com.gestac.gestac.pessoas.cliente.application;

import br.com.gestac.gestac.pessoas.cliente.domain.Cliente;
import br.com.gestac.gestac.pessoas.cliente.domain.ClienteService;
import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/")
    public ResponseEntity<BusinessResponseEntity> incluir(@Valid @RequestBody Cliente cliente) throws BusinessException {
        clienteService.incluir(cliente);
        return BusinessResponseEntityFactory.getResponseSucess();
    }

    @GetMapping("/")
    public ResponseEntity<BusinessResponseEntity> buscarTodos() {
        return BusinessResponseEntityFactory.getResponseSucess(clienteService.buscarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BusinessResponseEntity> excluirPorId(@PathVariable Long id) throws BusinessException {
        clienteService.excluirPorId(id);
        return BusinessResponseEntityFactory.getResponseSucess();
    }
}
