package br.com.gestac.gestac.pessoas.cliente.application;

import br.com.gestac.gestac.commons.business.BusinessResponseEntity;
import br.com.gestac.gestac.commons.business.BusinessResponseEntityFactory;
import br.com.gestac.gestac.commons.business.exception.BusinessException;
import br.com.gestac.gestac.pessoas.cliente.domain.Cliente;
import br.com.gestac.gestac.pessoas.cliente.domain.ClienteForm;
import br.com.gestac.gestac.pessoas.cliente.domain.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/incluir")
    public ResponseEntity<BusinessResponseEntity> incluir(@Valid @RequestBody ClienteForm clienteForm) throws BusinessException {
        clienteService.incluir(clienteForm.toModel());
        return BusinessResponseEntityFactory.getResponseSucess();
    }

    @GetMapping("/buscarTodos")
    public ResponseEntity<BusinessResponseEntity> buscarTodos() {
        return BusinessResponseEntityFactory.getResponseSucess(clienteService.buscarTodos());
    }

    @DeleteMapping("/excluir/")
    public ResponseEntity<BusinessResponseEntity> excluirPorId(@RequestParam Long id) throws BusinessException {
        clienteService.excluirPorId(id);
        return BusinessResponseEntityFactory.getResponseSucess();
    }
}
